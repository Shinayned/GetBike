package controllers;

import comparator.IntervalComparator;
import components.Schedule;
import dto.OrderDTO;
import dto.TimeDTO;
import model.Bike;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.BikeService;

import java.util.*;

@Controller
@RequestMapping("/")
public class BikeController {
    @Autowired
    private BikeService bikeService;

    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping("/rent/getSchedule")
    public List<TimeDTO> getSchedule(@RequestParam OrderDTO order) {
        List<List<Bike>> bikeLists = bikeService.getArrayOfBikeList(order);
        List<TimeDTO> listOfTime = getAvailableTime(bikeLists, order);

        return listOfTime;
    }

    private static List<TimeDTO> getAvailableTime(List<List<Bike>> bikeLists, OrderDTO order) {
        Schedule schedule = bikeLists.get(0).get(0).getLocation().getSchedule();
        HashMap<Interval, Boolean> timeList = getTimeListBySchedule(schedule, order);

        List<HashMap<Interval, Boolean>> listOfTime = new ArrayList<>();
        for (int index = 0; index < bikeLists.size(); index++) {
            listOfTime.add((HashMap<Interval, Boolean>) timeList.clone());
            validateTimeForBikes(listOfTime.get(index), order.getDate(), bikeLists.get(index));
        }
        return compareTimeList(listOfTime);
    }

    private static void validateTimeForBikes(HashMap<Interval, Boolean> workTime, DateTime date, List<Bike> bikes) {
        int counter = 0;
        for(Bike bike : bikes) {
            counter = bike.getLoadList().checkLoadForTime(workTime, date, counter);
            if(counter == workTime.size()) {
                break;
            }
        }
    }

    private static HashMap<Interval, Boolean> getTimeListBySchedule(Schedule schedule, OrderDTO order) {
        HashMap<Interval, Boolean> timeList = new HashMap<>();

        Interval dailySchedule = schedule.getScheduleForDate(order.getDate());
        long workDayMinutes = dailySchedule.toDuration().getStandardMinutes();

        int requestMinutes = order.getHours() * 60 + schedule.getAdditionalTime();
        int counter = (int) (workDayMinutes - requestMinutes) / schedule.getOrderEveryMinutes();

        DateTime time = dailySchedule.getStart();
        for (int index = 0; index <=counter; index++) {
            timeList.put(new Interval(time, time.plus(requestMinutes)), false);
            time = time.plusMinutes(schedule.getOrderEveryMinutes());
        }
        return  timeList;
    }

    private static List<TimeDTO> compareTimeList(List<HashMap<Interval, Boolean>> listOfTime) {
        List<TimeDTO> availableTimeList = new ArrayList<>();
        List<Interval> keyList = new ArrayList<>();
        Collections.sort(keyList, new IntervalComparator());

        for (Interval time : keyList) {
            TimeDTO timeDTO = new TimeDTO(time.getStart().toDate(), true);
            for (HashMap<Interval, Boolean> list : listOfTime) {
                if(!list.get(time)) {
                    timeDTO.setAvailable(false);
                    break;
                }
            }
            availableTimeList.add(timeDTO);
        }
        return availableTimeList;
    }
}

package components;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoadList implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<Long, List<Interval>> loadList;

    public LoadList() {
        loadList = new HashMap<>();
    }

    public void addLoad(DateTime date, Interval load){
        long dateKey = getMillisUpToDay(date);
        List<Interval> dayLoad = loadList.get(dateKey);
        if(dayLoad == null) {
            dayLoad = new ArrayList<>();
            loadList.put(dateKey, dayLoad);
        }
        dayLoad.add(load);

    }

    public int checkLoadForTime(HashMap<Interval, Boolean> timeList, DateTime date, int counter) {
        List<Interval> dayLoad = loadList.get(getMillisUpToDay(date));
        if(dayLoad == null) {
            timeList.forEach((key, available) -> {
                available = true;
            });
            return timeList.size();
        }

        for(Interval interval : timeList.keySet()) {
            if(!timeList.get(interval)) {
                boolean isOverlaps = false;
                for (Interval interval1OfLoad : dayLoad) {
                    if (interval1OfLoad.overlaps(interval)) {
                        isOverlaps = true;
                        break;
                    }
                }
                if(!isOverlaps) {
                    timeList.put(interval, true);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static long getMillisUpToDay(DateTime date) {
        int year = date.getYear();
        int month = date.getMonthOfYear();
        int day = date.getDayOfMonth();

        Schedule sd = new Schedule();

        return new DateTime(year, month, day, 0, 0).getMillis();
    }
}

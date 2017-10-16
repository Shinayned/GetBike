package components;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private HashMap<Long, Interval> specialSchedule = new HashMap<>();
    private Interval[] normalSchedule = new Interval[7];
    private int additionalTime = 15;
    private int orderEveryMinutes = 15;

    public Schedule(){}

    public void addSpecialSchedule(DateTime date, Interval schedule) {
        long dayKey = getMillisUpToDay(date);
        specialSchedule.put(dayKey, schedule);
    }

    public void addDayOfWeekSchedule(int day, Interval schedule) throws Exception{
        validationOfDay(day);
        normalSchedule[day] = schedule;
    }

    public Interval getScheduleForDayOfWeek(int day){
        validationOfDay(day);
        return normalSchedule[day - 1];
    }

    public Interval getScheduleForDate(DateTime date){
        long dateKey = getMillisUpToDay(date);
        return specialSchedule.getOrDefault(dateKey, getScheduleForDayOfWeek(date.getDayOfWeek()));
    }

    public int getAdditionalTime() {
        return additionalTime;
    }

    public void setAdditionalTime(int additionalTime) {
        this.additionalTime = additionalTime;
    }

    public int getOrderEveryMinutes() {
        return orderEveryMinutes;
    }

    public void setOrderEveryMinutes(int orderEveryMinutes) {
        this.orderEveryMinutes = orderEveryMinutes;
    }

    private static void validationOfDay(int day){
        if(day <= 0 || day > 7) {
            throw new RuntimeException("'Day' must be in interval 1-7.");
        }
    }

    public static long getMillisUpToDay(DateTime date) {
        int year = date.getYear();
        int month = date.getMonthOfYear();
        int day = date.getDayOfMonth();
        return new DateTime(year, month, day, 0, 0).getMillis();
    }
}
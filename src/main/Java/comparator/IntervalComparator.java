package comparator;

import org.joda.time.Interval;

import java.util.Comparator;

public class IntervalComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Interval i1 = (Interval) o1;
        Interval i2 = (Interval) o2;

        if(i1.isBefore(i2)) {
            return -1;
        } else if (i1.isEqual(i2)) {
            return 0;
        } else if (i1.isAfter(i2)) {
            return 1;
        }

        return 0;
    }
}

package dto;

import org.joda.time.DateTime;

import java.util.List;

public class OrderDTO {
    private int pointNumber;
    private DateTime date;
    private int hours;
    private List<OrderedBikeDTO> orderedBikes;

    public int getPointNumber() {
        return pointNumber;
    }

    public DateTime getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public List<OrderedBikeDTO> getOrderedBikes() {
        return orderedBikes;
    }
}

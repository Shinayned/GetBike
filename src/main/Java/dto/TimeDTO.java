package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TimeDTO {
    @JsonFormat(shape=JsonFormat.Shape.NUMBER)
    private Date time;
    private boolean available;

    public TimeDTO(Date time, boolean available) {
        this.time = time;
        this.available = available;
    }

    public Date getTime() {
        return time;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }

        if(this.getClass() != obj.getClass()) {
            return false;
        }

        TimeDTO other = (TimeDTO) obj;
        return this.time.equals(other.time);
    }
}

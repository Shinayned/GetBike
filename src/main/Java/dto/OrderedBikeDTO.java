package dto;

import enums.BikeType;
import enums.Height;

public class OrderedBikeDTO {
    private BikeType type;
    private Height height;

    public BikeType getType() {
        return type;
    }

    public Height getHeight() {
        return height;
    }
}

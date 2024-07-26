package lld.parkinglot.constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public enum VehicleType {
    TWO_WHEELER(20),
    THREE_WHEELER(30),
    FOUR_WHEELER(50);

    private int capacity;

    VehicleType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

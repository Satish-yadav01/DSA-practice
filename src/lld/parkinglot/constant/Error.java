package lld.parkinglot.constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public enum Error {
    VEHICLE_TYPE_NOT_RECOGNIZED("Vehicle type not recognized"),
    TWO_WHEELER_NOT_ENOUGH_CAPACITY("not enough capacity to add 2 wheeler Vehicle on Floor no :"),
    THREE_WHEELER_NOT_ENOUGH_CAPACITY("not enough capacity to add 3 wheeler Vehicle on Floor no :"),
    FOUR_WHEELER_NOT_ENOUGH_CAPACITY("not enough capacity to add 4 wheeler Vehicle on Floor no :");


    private String message;
    Error(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

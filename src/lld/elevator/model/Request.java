package lld.elevator.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Request {
    private int id;
    private int sourceFloor;
    private int destinationFloor;

    public Request(int id, int sourceFloor, int destinationFloor) {
        this.id = id;
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}

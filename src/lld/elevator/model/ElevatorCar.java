package lld.elevator.model;

import lld.elevator.constant.Direction;
import lld.elevator.data.Button;
import lld.elevator.data.Door;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ElevatorCar {
    private int elevatorCarId;
    private int currentFloor;
    private List<Integer> destinationFloors;
    private Door door;
    private WeightSensor weightSensor;
    private String direction;
    private Button button;

    public ElevatorCar(int cardId) {
        this.elevatorCarId = cardId;
        this.currentFloor = 0;
        this.destinationFloors = new ArrayList<>();
        this.weightSensor = new WeightSensor();
        this.direction = Direction.IDLE.getVal();
    }

    public void moveToFloor(int floor) {

    }

    public void reachedFloor(int floor) {

    }

}

package lld.elevator.model;



import java.util.List;
import java.util.Queue;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ElevatorController {
    private List<ElevatorCar> elevatorCars;
    private Queue<Request> requests;

    public ElevatorController(int noOfElevators) {
        for (int i = 0; i < noOfElevators; i++) {
            elevatorCars.add(new ElevatorCar(i));
        }
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void ScheduleElevator(){
        while(!requests.isEmpty()){

        }
    }
}

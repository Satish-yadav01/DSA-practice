package designPattern.coreJava.behavioralPattern.observerPattern.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ParkingSpot {
    private List<Observer> observers = new ArrayList<>();
    private boolean isFull = false;
    private String status;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void isFull(boolean isFull) {
        this.isFull = isFull;
        if(isFull){
            notifyObservers("Parking lot is Full");
        }else {
            notifyObservers("Parking lot is not full");
        }
    }
}

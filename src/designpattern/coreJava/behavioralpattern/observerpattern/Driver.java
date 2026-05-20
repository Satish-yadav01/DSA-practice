package designpattern.coreJava.behavioralpattern.observerpattern;

import designpattern.coreJava.behavioralpattern.observerpattern.manager.MobileApp;
import designpattern.coreJava.behavioralpattern.observerpattern.manager.ParkingManagerSystem;
import designpattern.coreJava.behavioralpattern.observerpattern.model.Observer;
import designpattern.coreJava.behavioralpattern.observerpattern.model.ParkingSpot;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        ParkingSpot parkingSpot = new ParkingSpot();
        Observer managementSystem = new ParkingManagerSystem();
        Observer mobileApp = new MobileApp();

        parkingSpot.addObserver(managementSystem);
        parkingSpot.addObserver(mobileApp);

        parkingSpot.isFull(true);
    }
}

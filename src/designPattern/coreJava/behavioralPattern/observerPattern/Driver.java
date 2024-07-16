package designPattern.coreJava.behavioralPattern.observerPattern;

import designpattern.observerPattern.manager.MobileApp;
import designpattern.observerPattern.manager.ParkingManagerSystem;
import designpattern.observerPattern.model.Observer;
import designpattern.observerPattern.model.ParkingSpot;

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

package designPattern.coreJava.behavioralPattern.observerPattern;

import designPattern.coreJava.behavioralPattern.observerPattern.manager.MobileApp;
import designPattern.coreJava.behavioralPattern.observerPattern.manager.ParkingManagerSystem;
import designPattern.coreJava.behavioralPattern.observerPattern.model.Observer;
import designPattern.coreJava.behavioralPattern.observerPattern.model.ParkingSpot;

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

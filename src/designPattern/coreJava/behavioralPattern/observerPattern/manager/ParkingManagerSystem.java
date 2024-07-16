package designPattern.coreJava.behavioralPattern.observerPattern.manager;

import designPattern.coreJava.behavioralPattern.observerPattern.model.Observer;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ParkingManagerSystem implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ParkingManagerSystem: "+message);
    }
}

package designpattern.coreJava.behavioralpattern.observerpattern.manager;

import designpattern.coreJava.behavioralpattern.observerpattern.model.Observer;

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

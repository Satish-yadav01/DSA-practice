package designPattern.coreJava.behavioralPattern.observerPattern.manager;

import designpattern.observerPattern.model.Observer;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class MobileApp implements Observer {
    @Override
    public void update(String message) {
        System.out.println("MobileApp: " + message);
    }
}

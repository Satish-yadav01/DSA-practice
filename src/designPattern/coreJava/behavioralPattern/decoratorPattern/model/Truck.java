package designPattern.coreJava.behavioralPattern.decoratorPattern.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Truck implements Vehicle{
    @Override
    public void park() {
        System.out.println("Truck parked");
    }
}

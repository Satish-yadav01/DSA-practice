package designPattern.coreJava.structuralPattern.decoratorPattern.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Car implements Vehicle{
    @Override
    public void park() {
        System.out.println("Car has been parked");
    }
}

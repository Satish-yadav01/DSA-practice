package designPattern.coreJava.structuralPattern.decoratorPattern.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Bike implements Vehicle{
    @Override
    public void park() {
        System.out.println("Bike is parking");
    }
}

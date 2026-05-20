package designpattern.coreJava.structuralPattern.decoratorPattern;

import designpattern.coreJava.structuralPattern.decoratorPattern.decorator.GpsDecorator;
import designpattern.coreJava.structuralPattern.decoratorPattern.decorator.ParkingSensorDecorator;
import designpattern.coreJava.structuralPattern.decoratorPattern.model.Car;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        Car myCar = new Car();
        //I wanted to add GPS to my car
        GpsDecorator gpsDecorator = new GpsDecorator(myCar);

        //Also want to add parking sensor
        ParkingSensorDecorator parkingSensorDecorator = new ParkingSensorDecorator(gpsDecorator);

        parkingSensorDecorator.park();

    }
}

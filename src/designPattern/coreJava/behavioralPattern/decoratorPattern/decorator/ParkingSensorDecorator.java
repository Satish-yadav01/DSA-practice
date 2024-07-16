package designPattern.coreJava.behavioralPattern.decoratorPattern.decorator;

import designpattern.decoratorPattern.model.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ParkingSensorDecorator extends VehicleDecorator{
    public ParkingSensorDecorator(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public void park(){
        decoratedVehicle.park();
        addParkingSensor();
    }

    private void addParkingSensor() {
        System.out.println("parking sensor added");
    }
}

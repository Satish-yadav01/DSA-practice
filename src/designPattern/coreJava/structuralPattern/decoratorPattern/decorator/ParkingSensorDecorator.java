package designPattern.coreJava.structuralPattern.decoratorPattern.decorator;

import designPattern.coreJava.structuralPattern.decoratorPattern.model.Vehicle;

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

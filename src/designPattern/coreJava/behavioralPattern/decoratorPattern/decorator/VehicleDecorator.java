package designPattern.coreJava.behavioralPattern.decoratorPattern.decorator;

import designpattern.decoratorPattern.model.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public abstract class VehicleDecorator implements Vehicle {
    protected final Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }
    @Override
    public void park() {
        decoratedVehicle.park();
    }
}

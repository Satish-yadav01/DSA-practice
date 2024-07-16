package designPattern.coreJava.behavioralPattern.decoratorPattern.decorator;

import designpattern.decoratorPattern.model.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class GpsDecorator extends VehicleDecorator{
    public GpsDecorator(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public void park(){
        decoratedVehicle.park();
        addGps();
    }

    private void addGps() {
        System.out.println("GPS is added to the vehicle");
    }
}

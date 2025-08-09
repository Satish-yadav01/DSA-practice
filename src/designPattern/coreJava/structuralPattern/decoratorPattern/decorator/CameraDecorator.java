package designPattern.coreJava.structuralPattern.decoratorPattern.decorator;

import designPattern.coreJava.structuralPattern.decoratorPattern.model.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class CameraDecorator extends VehicleDecorator{
    public CameraDecorator(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
    }

    @Override
    public void park(){
        decoratedVehicle.park();
        addCamara();
    }

    private void addCamara() {
        System.out.println("camara is added");
    }
}

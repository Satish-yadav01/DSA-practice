package lld.parkinglot.model.vehicle;

import parkinglot.constant.VehicleType;
import parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Car implements Vehicle {
    private final String vehicleNo;
    private final String color;
    private final VehicleType vehicleType;

    public Car(String vehicleNo, String color, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public void park() {
        System.out.println("Car parked");
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public void unPark() {

    }

    @Override
    public String getVehicleNo() {
        return vehicleNo;
    }
}

package lld.parkinglot.model.vehicle;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Bike implements Vehicle {
    private final String vehicleNo;
    private final String color;
    private final VehicleType vehicleType;

    public Bike(String vehicleNo, String color, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public void park() {
        System.out.println("Bike parked");
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

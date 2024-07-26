package lld.parkinglot.model.vehicle;

import parkinglot.constant.VehicleType;
import parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Truck implements Vehicle {
    private final String vehicleNo;
    private final String color;
    private final VehicleType vehicleType;

    public Truck(String vehicleNo, String color, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public void park() {

    }

    @Override
    public void unPark() {

    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String getVehicleNo() {
        return vehicleNo;
    }
}

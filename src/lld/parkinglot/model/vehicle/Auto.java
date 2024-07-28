package lld.parkinglot.model.vehicle;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Auto implements Vehicle {
    private final String vehicleNo;
    private final String color;
    private final VehicleType vehicleType;

    public Auto(String vehicleNo, String color, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public void park() {
        System.out.println("Auto parked");
    }

    @Override
    public void unPark() {

    }

    @Override
    public String getVehicleNo() {
        return vehicleNo;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

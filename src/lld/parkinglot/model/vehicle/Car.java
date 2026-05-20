package lld.parkinglot.model.vehicle;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Car implements Vehicle {
    private final String vehicleNo;
    private final String color;
    private final VehicleType vehicleType;

    public Car(String vehicleNo, String color) {
        this.vehicleNo = vehicleNo;
        this.color = color;
        this.vehicleType = VehicleType.FOUR_WHEELER;
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
        System.out.println("Car unparked");
    }

    @Override
    public String getVehicleNo() {
        return vehicleNo;
    }
}

package lld.parkinglot.factory;


import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.constant.Error;
import lld.parkinglot.exception.ParkingException;
import lld.parkinglot.model.vehicle.Auto;
import lld.parkinglot.model.vehicle.Bike;
import lld.parkinglot.model.vehicle.Car;
import lld.parkinglot.repo.Vehicle;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class VehicleFactory {
    public static Vehicle getVehicle(String vehicleNo, String color,VehicleType vehicleType) {
        return switch (vehicleType){
            case VehicleType.TWO_WHEELER -> new Bike(vehicleNo,color,vehicleType);
            case VehicleType.THREE_WHEELER -> new Auto(vehicleNo,color,vehicleType);
            case VehicleType.FOUR_WHEELER -> new Car(vehicleNo,color,vehicleType);
            default -> {
                System.out.println(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
            }
        };
    }
}

package lld.parkinglot.factory;


import parkinglot.constant.VehicleType;
import parkinglot.exception.ParkingException;
import parkinglot.model.vehicle.Auto;
import parkinglot.model.vehicle.Bike;
import parkinglot.model.vehicle.Car;
import parkinglot.repo.Vehicle;

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

package lld.parkinglot.factory;

import parkinglot.constant.VehicleType;
import parkinglot.exception.ParkingException;
import parkinglot.model.spot.FourWheelerParkingSpot;
import parkinglot.model.spot.ThreeWheelerParkingSpot;
import parkinglot.model.spot.TwoWheelerParkingSpot;
import parkinglot.repo.ParkingSpot;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ParkingSpotFactory {
    public static ParkingSpot getParkingSpot(VehicleType vehicleType,int spotNumber) {
        return switch (vehicleType) {
            case TWO_WHEELER -> new TwoWheelerParkingSpot(spotNumber);
            case THREE_WHEELER -> new ThreeWheelerParkingSpot(spotNumber);
            case FOUR_WHEELER -> new FourWheelerParkingSpot(spotNumber);
            default -> {
                System.out.println(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
            }
        };
    }
}

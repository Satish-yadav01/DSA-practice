package lld.parkinglot.factory;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.exception.ParkingException;
import lld.parkinglot.model.spot.FourWheelerParkingSpot;
import lld.parkinglot.model.spot.ThreeWheelerParkingSpot;
import lld.parkinglot.model.spot.TwoWheelerParkingSpot;
import lld.parkinglot.repo.ParkingSpot;
import lld.parkinglot.constant.Error;

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

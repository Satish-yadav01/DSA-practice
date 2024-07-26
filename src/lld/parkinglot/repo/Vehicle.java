package lld.parkinglot.repo;

import parkinglot.constant.VehicleType;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface Vehicle {
    void park();
    void unPark();
    String getVehicleNo();

    VehicleType getVehicleType();
}

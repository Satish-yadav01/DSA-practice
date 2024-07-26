package lld.parkinglot.repo;

import parkinglot.constant.VehicleType;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface CostComputation {
    double calulateCostForTicket(VehicleType vehicleType);
}

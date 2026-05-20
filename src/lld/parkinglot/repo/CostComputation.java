package lld.parkinglot.repo;

import lld.parkinglot.constant.VehicleType;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface CostComputation {
    double calculateCostForTicket(VehicleType vehicleType);
}

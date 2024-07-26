package lld.parkinglot.costStrategy;

import parkinglot.constant.VehicleType;
import parkinglot.repo.CostComputation;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class MinuteBasedStrategy implements CostComputation {
    @Override
    public double calulateCostForTicket(VehicleType vehicleType) {
        return 0;
    }
}

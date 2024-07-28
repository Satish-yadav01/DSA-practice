package lld.parkinglot.costStrategy;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.repo.CostComputation;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class HourBasedStrategy implements CostComputation {
    @Override
    public double calulateCostForTicket(VehicleType vehicleType) {
        return 0;
    }
}

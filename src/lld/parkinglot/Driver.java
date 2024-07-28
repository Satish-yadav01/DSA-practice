package lld.parkinglot;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.costStrategy.MinuteBasedStrategy;
import lld.parkinglot.factory.VehicleFactory;
import lld.parkinglot.model.Admin;
import lld.parkinglot.model.Entrance;
import lld.parkinglot.model.Floor;
import lld.parkinglot.model.Ticket;
import lld.parkinglot.model.spot.ThreeWheelerParkingSpot;
import lld.parkinglot.model.spot.TwoWheelerParkingSpot;
import lld.parkinglot.repo.Vehicle;

import java.util.List;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        Floor floor1 = new Floor(1, 400);
        Floor floor2 = new Floor(2, 600);

        Admin admin = Admin.getInstance(List.of(floor1, floor2));


        try {
            admin.addParkingSpotOnFloor(new TwoWheelerParkingSpot(1),VehicleType.TWO_WHEELER,1);

            admin.addParkingSpotOnFloor(new TwoWheelerParkingSpot(2),VehicleType.TWO_WHEELER,1);

            admin.addParkingSpotOnFloor(new TwoWheelerParkingSpot(3),VehicleType.THREE_WHEELER,1);

            admin.removeParkingSpotOnFloor(new ThreeWheelerParkingSpot(1),VehicleType.THREE_WHEELER,1);

            admin.addParkingSpotOnFloor(new TwoWheelerParkingSpot(1),VehicleType.FOUR_WHEELER,2);

            int availableOnFloor = admin.getParkingSpotAvailOnAnyFloor(new TwoWheelerParkingSpot(1), VehicleType.THREE_WHEELER);

            if(availableOnFloor == -1){
                System.out.println("No parking spots available");
            }else {
                System.out.println("parking available on floor : "+availableOnFloor);
            }

            Vehicle vehicle = VehicleFactory.getVehicle("MH475499", "red", VehicleType.THREE_WHEELER);

            vehicle.park();

            Vehicle vehicle2 = VehicleFactory.getVehicle("MH475499", "red", VehicleType.TWO_WHEELER);

            vehicle2.park();


            Entrance entrance = Entrance.getInstance(admin);
            int spot = entrance.findSpot(VehicleType.TWO_WHEELER, 1);
            Ticket ticket = null;
            System.out.println("Vehicle : "+vehicle.getVehicleNo());
            if(spot != -1){
                ticket = entrance.bookSpotAndGiveTicket(vehicle, new MinuteBasedStrategy());
            }

            System.out.println("ticket found : " + ticket.getVehicle().getVehicleNo());


        } catch (Exception e) {
            System.out.println("error : "+ e.getMessage());
        }

    }
}

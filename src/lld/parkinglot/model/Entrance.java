package lld.parkinglot.model;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.factory.ParkingSpotFactory;
import lld.parkinglot.repo.CostComputation;
import lld.parkinglot.repo.Vehicle;

import java.time.LocalDateTime;

/**
 * @author : Satish Yadav
 * @purpose : Here also I wanted to make Entrance as a singleton because I wanted to make only one entrance in overall parking lot system design
 */
public class Entrance {
    private final Admin admin;
    private Ticket ticket;
    private int availableFloorForSpot;
    private static Entrance instance = null;
    private long ticketId=1;

    private Entrance(Admin admin) {
        this.admin = admin;
    }

    public static Entrance getInstance(Admin admin) {
        if (instance == null) {
            instance = new Entrance(admin);
        }
        return instance;
    }

    public int findSpot(VehicleType vehicleType,int spotNumber){
        availableFloorForSpot = admin.getParkingSpotAvailOnAnyFloor(ParkingSpotFactory.getParkingSpot(vehicleType,spotNumber),vehicleType);
        return availableFloorForSpot;
    }

    public Ticket bookSpotAndGiveTicket(Vehicle vehicle, CostComputation costComputation){
        //book spot
        admin.occupyParkingSpot(ParkingSpotFactory.getParkingSpot(vehicle.getVehicleType(), availableFloorForSpot),vehicle.getVehicleType());

        //calculate price
        int price = 500;

        //generate ticket
        ticket = new Ticket(1, admin.getParkingSpotNUmber(), LocalDateTime.now(), vehicle, price);
        return ticket;
    }
}

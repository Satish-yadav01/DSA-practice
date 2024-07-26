package lld.parkinglot.model;

import parkinglot.repo.Vehicle;

import java.time.LocalDateTime;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Ticket {
    private final int id;
    private final int parkingLotNumber;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private final Vehicle vehicle;
    private final double price;

    public Ticket(int id, int parkingLotNumber, LocalDateTime entryTime, Vehicle vehicle, double price) {
        this.id = id;
        this.parkingLotNumber = parkingLotNumber;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.price = price;
    }



    /*-----------getter and setter---------------------*/
    public int getId() {
        return id;
    }

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

package lld.parkinglot.model;

import lld.parkinglot.constant.VehicleType;
import lld.parkinglot.repo.ParkingSpot;

import java.util.List;

/**
 * @author : Satish Yadav
 * @purpose :
 * @apiNote : I am making this Admin class as a Singleton class because I want to make only one admin for overall parkingLot design
 */
public class Admin{
    private final List<Floor> floors;
    private static Admin instance = null;

    private Admin(List<Floor> floors){
        this.floors = floors;
    }

    public static Admin getInstance(List<Floor> floors) {
        if(instance == null){
            instance = new Admin(floors);
        }
        return instance;
    }

    public void addParkingSpotOnFloor(ParkingSpot parkingSpot, VehicleType vehicleType, int floorNumber) {
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                floor.addParkingSpot(parkingSpot, vehicleType);
            }
        }

    }

    public void removeParkingSpotOnFloor(ParkingSpot parkingSpot, VehicleType vehicleType, int floorNumber) {
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == floorNumber) {
                floor.removeParkingSpot(parkingSpot, vehicleType);
            }
        }
    }

    public int getParkingSpotAvailOnAnyFloor(ParkingSpot parkingSpot, VehicleType vehicleType) {
        int foundFloor = -1;
        for (Floor floor : floors) {
            if(floor.isParkingSpotAvailable(vehicleType) && !floor.isParkingSpotOccupied(vehicleType)){
                foundFloor = floor.getFloorNumber();
                break;
            }
        }
        return foundFloor;
    }

    public boolean isParkingSpotOccupied(ParkingSpot parkingSpot, VehicleType vehicleType) {
        int floor = getParkingSpotAvailOnAnyFloor(parkingSpot, vehicleType);
        if(floor != -1){
            for (Floor floor1 : floors) {
                if (floor1.getFloorNumber() == floor) {
                    return floor1.isParkingSpotOccupied(vehicleType);
                }
            }
        }
        return false;
    }

    public void occupyParkingSpot(ParkingSpot parkingSpot, VehicleType vehicleType) {
        int floorNumber = getParkingSpotAvailOnAnyFloor(parkingSpot, vehicleType);
        if(floorNumber != -1){
            for (Floor floor : floors) {
                if (floor.getFloorNumber() == floorNumber) {
                    floor.occupyParkingSpot(vehicleType,floor.getSpotIfAvailable(vehicleType));
                }
            }
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }


    public int getParkingSpotNUmber() {
        return 0;
    }
}

package lld.parkinglot.model;

import parkinglot.constant.VehicleType;
import parkinglot.exception.ParkingException;
import parkinglot.repo.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Floor {
    private int floorNumber;
    private int capacity;
    private final List<ParkingSpot> twoWheelerParkingSpots;
    private final List<ParkingSpot> threeWheelerParkingSpots;
    private final List<ParkingSpot> fourWheelerParkingSpots;

    Logger logger = Logger.getLogger(getClass().getName());

    public Floor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.capacity = capacity;
        this.twoWheelerParkingSpots = new ArrayList<>();
        this.threeWheelerParkingSpots = new ArrayList<>();
        this.fourWheelerParkingSpots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot, VehicleType vehicleType) {
        switch (vehicleType){
            case VehicleType.TWO_WHEELER:
                if(this.capacity >= VehicleType.TWO_WHEELER.getCapacity()){
                    this.twoWheelerParkingSpots.add(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.TWO_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            case VehicleType.THREE_WHEELER:
                if(this.capacity >= VehicleType.THREE_WHEELER.getCapacity()){
                    this.threeWheelerParkingSpots.add(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.THREE_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            case VehicleType.FOUR_WHEELER:
                if(this.capacity >= VehicleType.FOUR_WHEELER.getCapacity()){
                    this.fourWheelerParkingSpots.add(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.FOUR_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            default:
                logger.info(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());

        }
    }

    public void removeParkingSpot(ParkingSpot parkingSpot, VehicleType vehicleType){
        switch (vehicleType){
            case VehicleType.TWO_WHEELER:
                if(this.capacity >= VehicleType.TWO_WHEELER.getCapacity()){
                    this.twoWheelerParkingSpots.remove(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.TWO_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            case VehicleType.THREE_WHEELER:
                if(this.capacity >= VehicleType.THREE_WHEELER.getCapacity()){
                    this.threeWheelerParkingSpots.add(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.THREE_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            case VehicleType.FOUR_WHEELER:
                if(this.capacity >= VehicleType.FOUR_WHEELER.getCapacity()){
                    this.fourWheelerParkingSpots.add(parkingSpot);
                    this.capacity = this.capacity - VehicleType.TWO_WHEELER.getCapacity();
                }else {
                    throw new ParkingException(Error.FOUR_WHEELER_NOT_ENOUGH_CAPACITY.getMessage() + this.floorNumber);
                }
                break;
            default:
                logger.info(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());

        }
    }

    public boolean isParkingSpotAvailable(VehicleType vehicleType) {
        return switch (vehicleType) {
            case VehicleType.TWO_WHEELER -> !this.twoWheelerParkingSpots.isEmpty();
            case VehicleType.THREE_WHEELER -> !this.threeWheelerParkingSpots.isEmpty();
            case VehicleType.FOUR_WHEELER -> !this.fourWheelerParkingSpots.isEmpty();
            default -> {
                logger.info(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
            }
        };
    }

    public int getSpotIfAvailable(VehicleType vehicleType){
        boolean isParkingSpotAvailable = isParkingSpotAvailable(vehicleType);
        if(isParkingSpotAvailable){
            switch (vehicleType){
                case TWO_WHEELER -> {
                    for(ParkingSpot parkingSpot : this.twoWheelerParkingSpots){
                        if(!parkingSpot.isEmpty()){
                            return parkingSpot.getId();
                        }
                    }
                }
                case THREE_WHEELER -> {
                    for(ParkingSpot parkingSpot : this.threeWheelerParkingSpots){
                        if(!parkingSpot.isEmpty()){
                            return parkingSpot.getId();
                        }
                    }
                }
                case FOUR_WHEELER -> {
                    for(ParkingSpot parkingSpot : this.fourWheelerParkingSpots){
                        if(!parkingSpot.isEmpty()){
                            return parkingSpot.getId();
                        }
                    }
                }
            }
        }
        return -1;
    }

    public boolean isParkingSpotOccupied(VehicleType vehicleType) {
        return switch (vehicleType) {
            case VehicleType.TWO_WHEELER -> twoWheelerParkingSpots.stream().allMatch(parkingSpot -> !parkingSpot.isEmpty());
            case VehicleType.THREE_WHEELER -> threeWheelerParkingSpots.stream().allMatch(parkingSpot -> !parkingSpot.isEmpty());
            case VehicleType.FOUR_WHEELER -> fourWheelerParkingSpots.stream().allMatch(parkingSpot -> !parkingSpot.isEmpty());
            default -> {
                logger.info(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
            }
        };
    }



    public void occupyParkingSpot(VehicleType vehicleType,int spotId){
        switch (vehicleType){
            case VehicleType.TWO_WHEELER->{
                for (int i = 0; i < twoWheelerParkingSpots.size() - 1; i++) {
                    if(twoWheelerParkingSpots.get(i).getId() == spotId){
                        twoWheelerParkingSpots.get(i).occupy();
                    }
                }
            }
            case VehicleType.THREE_WHEELER->{
                for (int i = 0; i < threeWheelerParkingSpots.size() - 1; i++) {
                    if(threeWheelerParkingSpots.get(i).getId() == spotId){
                        threeWheelerParkingSpots.get(i).occupy();
                    }
                }
            }
            case VehicleType.FOUR_WHEELER->{
                for (int i = 0; i < fourWheelerParkingSpots.size() - 1; i++) {
                    if(fourWheelerParkingSpots.get(i).getId() == spotId){
                        fourWheelerParkingSpots.get(i).occupy();
                    }
                }
            }
            default -> {
                logger.info(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
                throw new ParkingException(Error.VEHICLE_TYPE_NOT_RECOGNIZED.getMessage());
            }
        }
    }

    /*-------------getter and setter---------------*/

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

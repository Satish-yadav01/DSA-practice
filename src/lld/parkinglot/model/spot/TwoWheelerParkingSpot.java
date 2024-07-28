package lld.parkinglot.model.spot;

import lld.parkinglot.repo.ParkingSpot;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class TwoWheelerParkingSpot implements ParkingSpot {
    private final int id;
    private boolean isOccupied;
    private int price;

    public TwoWheelerParkingSpot(int id) {
        this.id = id;
    }

    @Override
    public boolean isEmpty() {
        return !isOccupied;
    }

    @Override
    public void occupy() {
        this.isOccupied = true;
    }

    @Override
    public void vacateParkingSpot() {

    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

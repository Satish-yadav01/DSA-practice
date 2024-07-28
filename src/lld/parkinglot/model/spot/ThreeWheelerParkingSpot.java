package lld.parkinglot.model.spot;

import lld.parkinglot.repo.ParkingSpot;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ThreeWheelerParkingSpot implements ParkingSpot {
    private final int id;
    private boolean isOccupied;
    private int price;

    public ThreeWheelerParkingSpot(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return 0;
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
}

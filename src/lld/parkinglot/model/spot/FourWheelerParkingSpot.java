package lld.parkinglot.model.spot;

import parkinglot.repo.ParkingSpot;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class FourWheelerParkingSpot implements ParkingSpot {
    private final int id;
    private boolean isOccupied;
    private int price;

    public FourWheelerParkingSpot(int id) {
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

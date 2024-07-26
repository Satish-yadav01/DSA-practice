package lld.parkinglot.repo;


/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface ParkingSpot {
    int getId();
    boolean isEmpty();
    void occupy();
    void vacateParkingSpot();
}

package lld.elevator.model;

import elevator.constant.Constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class WeightSensor {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean maxWeight(int weight){
        this.weight += weight;
        return weight > Constant.MAX_WEIGHT;
    }
}

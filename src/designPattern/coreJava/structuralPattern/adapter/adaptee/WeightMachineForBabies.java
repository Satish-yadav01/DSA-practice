package designPattern.coreJava.structuralPattern.adapter.adaptee;

public class WeightMachineForBabies implements WeightMachine {

    @Override
    public double getWeightInPounds() {
        return 24;
    }
}

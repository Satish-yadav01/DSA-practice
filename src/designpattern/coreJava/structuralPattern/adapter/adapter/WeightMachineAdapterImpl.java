package designpattern.coreJava.structuralPattern.adapter.adapter;

import designpattern.coreJava.structuralPattern.adapter.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKilograms() {
        double weightInPounds = weightMachine.getWeightInPounds();
        return weightInPounds * .45;
    }
}

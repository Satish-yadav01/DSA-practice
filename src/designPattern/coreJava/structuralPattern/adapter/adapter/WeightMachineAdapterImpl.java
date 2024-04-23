package designPattern.coreJava.structuralPattern.adapter.adapter;

import designPattern.coreJava.structuralPattern.adapter.adaptee.WeightMachine;

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

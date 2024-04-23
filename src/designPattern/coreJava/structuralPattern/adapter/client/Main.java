package designPattern.coreJava.structuralPattern.adapter.client;

import designPattern.coreJava.structuralPattern.adapter.adaptee.WeightMachineForBabies;
import designPattern.coreJava.structuralPattern.adapter.adapter.WeightMachineAdapter;
import designPattern.coreJava.structuralPattern.adapter.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapterImpl weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKilograms());
    }
}

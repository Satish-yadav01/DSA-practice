package designpattern.coreJava.structuralPattern.adapter.client;

import designpattern.coreJava.structuralPattern.adapter.adaptee.WeightMachineForBabies;
import designpattern.coreJava.structuralPattern.adapter.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapterImpl weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKilograms());
    }
}

package designPattern.coreJava.structuralPattern.bridge;

public class TreeBreathImplementor implements BreathImplementor{

    @Override
    public void breath(Object animal) {
        System.out.println(animal.getClass().getName());
        System.out.println("Inhaling CO2");
        System.out.println("Exhaling Oxygen");
    }
}

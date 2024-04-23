package designPattern.coreJava.structuralPattern.bridge;

public class WaterBreathImplementor implements BreathImplementor{
    @Override
    public void breath(Object animal) {
        System.out.println(animal.getClass().getName());
        System.out.println("Inhaling oxygen from Nose");
        System.out.println("exhaling CO2");
    }
}

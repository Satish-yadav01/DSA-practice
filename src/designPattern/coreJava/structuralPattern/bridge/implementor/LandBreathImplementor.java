package designPattern.coreJava.structuralPattern.bridge.implementor;

public class LandBreathImplementor implements BreathImplementor {
    @Override
    public void breath(Object animal) {
        System.out.println(animal.getClass().getName());
        System.out.println("Inhaling oxygen from gulf");
        System.out.println("exhaling CO2");
    }
}

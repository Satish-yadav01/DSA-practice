package designPattern.coreJava.structuralPattern.bridge.abstraction;

import designPattern.coreJava.structuralPattern.bridge.implementor.BreathImplementor;

public class Fish extends LivingThings {
    private String name;
    public Fish(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess(Object animal) {
        breathImplementor.breath(animal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

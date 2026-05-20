package designpattern.coreJava.structuralPattern.bridge.abstraction;

import designpattern.coreJava.structuralPattern.bridge.implementor.BreathImplementor;

public abstract class LivingThings {
    BreathImplementor breathImplementor;

    public LivingThings(BreathImplementor breathImplementor) {
        this.breathImplementor = breathImplementor;
    }

    public abstract void breathProcess(Object animal);
}

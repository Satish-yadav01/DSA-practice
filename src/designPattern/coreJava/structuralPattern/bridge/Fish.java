package designPattern.coreJava.structuralPattern.bridge;

public class Fish extends LivingThings{
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

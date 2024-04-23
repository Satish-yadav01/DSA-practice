package designPattern.coreJava.structuralPattern.bridge;

public class Dog extends LivingThings{
    private String name;
    public Dog(BreathImplementor breathImplementor) {
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

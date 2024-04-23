package designPattern.coreJava.structuralPattern.bridge;

public class Tree extends LivingThings{
    private String name;
    public Tree(BreathImplementor breathImplementor) {
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

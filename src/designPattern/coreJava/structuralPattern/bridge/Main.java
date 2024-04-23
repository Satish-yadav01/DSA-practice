package designPattern.coreJava.structuralPattern.bridge;

public class Main {
    public static void main(String[] args) {
        Fish fish = new Fish(new WaterBreathImplementor());
        fish.setName("gold fish");
        fish.breathProcess(fish);
        Dog dog = new Dog(new LandBreathImplementor());
        dog.setName("jerman shephard");
        dog.breathProcess(dog);
        Tree tree = new Tree(new TreeBreathImplementor());
        tree.setName("oak tree");
        tree.breathProcess(tree);
    }
}

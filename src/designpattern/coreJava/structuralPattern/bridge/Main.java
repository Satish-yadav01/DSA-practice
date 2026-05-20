package designpattern.coreJava.structuralPattern.bridge;

import designpattern.coreJava.structuralPattern.bridge.abstraction.Dog;
import designpattern.coreJava.structuralPattern.bridge.abstraction.Fish;
import designpattern.coreJava.structuralPattern.bridge.abstraction.Tree;
import designpattern.coreJava.structuralPattern.bridge.implementor.LandBreathImplementor;
import designpattern.coreJava.structuralPattern.bridge.implementor.TreeBreathImplementor;
import designpattern.coreJava.structuralPattern.bridge.implementor.WaterBreathImplementor;

public class Main {
    public static void main(String[] args) {
        Fish fish = new Fish(new WaterBreathImplementor());
        fish.setName("gold fish");
        fish.breathProcess(fish);
        Dog dog = new Dog(new LandBreathImplementor());
        dog.setName("jerman shephard");
        dog.breathProcess(dog);
        Tree tree = new Tree(new TreeBreathImplementor());
        tree.setName("oak dsalgo.datastructure.tree");
        tree.breathProcess(tree);
    }
}

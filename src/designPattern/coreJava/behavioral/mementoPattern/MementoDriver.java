package designPattern.coreJava.behavioral.mementoPattern;

public class MementoDriver {
    public static void main(String[] args) {
        Originator originator = new Originator("Originator");
        CareTaker careTaker = new CareTaker();
        careTaker.addMemento(originator.save());
        originator.setState("Originator2");
        careTaker.addMemento(originator.save());
        originator.setState("Originator3");
        careTaker.addMemento(originator.save());

        System.out.println(originator.getState());

        originator.restore(careTaker.getMemento(0));
        System.out.println(originator.getState());
        originator.restore(careTaker.getMemento(1));

        System.out.println(originator.getState());
    }
}

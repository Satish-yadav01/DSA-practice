package designPattern.creationalPattern.abstractfactory;

public class MainClass {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactoryProducer.getProfession(false);
        Professions engineer = factory.getProfession("Engineer");
        engineer.print();
    }
}

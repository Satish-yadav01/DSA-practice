package designPattern.creationalPattern.factorypattern;

public class ProfessionMain {
    public static void main(String[] args) {
        ProfessionFactory professionFactory = new ProfessionFactory();
        Profession doctor = professionFactory.getProfession("doctor");
        doctor.print();
    }
}

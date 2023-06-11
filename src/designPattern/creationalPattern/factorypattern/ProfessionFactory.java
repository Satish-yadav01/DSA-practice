package designPattern.creationalPattern.factorypattern;

public class ProfessionFactory {
    public Profession getProfession(String profession){
        if(profession == null){
            return null;
        }
        if(profession.equalsIgnoreCase("Engineer")){
            return new Engineer();
        } else if (profession.equalsIgnoreCase("Doctor")) {
            return new Doctor();
        } else if (profession.equalsIgnoreCase("Teacher")) {
            return new Teacher();
        }
        return null;
    }
}

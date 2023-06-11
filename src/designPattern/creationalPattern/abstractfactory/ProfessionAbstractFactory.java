package designPattern.creationalPattern.abstractfactory;
//
//import designPattern.creationalPattern.factorypattern.Profession;

public class ProfessionAbstractFactory extends AbstractFactory{
    public Professions getProfession(String profession){
        if(profession == null){
            return null;
        }
        if (profession.equalsIgnoreCase("Engineer")) {
            return new Engineers();
        } else if (profession.equalsIgnoreCase("Teacher")) {
            return new Teachers();
        }
        return null;
    }

}

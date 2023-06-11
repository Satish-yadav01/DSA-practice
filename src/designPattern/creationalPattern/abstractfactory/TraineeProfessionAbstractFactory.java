package designPattern.creationalPattern.abstractfactory;


public class TraineeProfessionAbstractFactory extends AbstractFactory{
    public Professions getProfession(String profession){
        if(profession == null){
            return null;
        }
        if (profession.equalsIgnoreCase("Engineer")) {
            return new TraineeEngineer();
        } else if (profession.equalsIgnoreCase("Teacher")) {
            return new TraineeTeacher();
        }
        return null;
    }
}

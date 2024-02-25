package interviewBasics.interfaces;

//java8
//default method and static method in java

interface Person {
    void showName();
    void showAge();
    void showWeight();
    void showHeight();
}

interface College{
    default void shoeCollegeName(){
        System.out.println("viva college");
    }
}

interface Student extends Person,College{
    int getRollNo();
}

interface Teacher extends Person,College{
    float getSalary();
}

class Principle implements Student,Teacher{

    String studentName,teacherName;
    float sal;
    int rollNo;

    public Principle(String studentName, String teacherName, float sal, int rollNo) {
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.sal = sal;
        this.rollNo = rollNo;
    }


    @Override
    public void showName() {
        System.out.println("studentName " + studentName + " TeacherName : "+ teacherName);
    }

    @Override
    public void showAge() {
        System.out.println("age");
    }

    @Override
    public void showWeight() {
        System.out.println("weight");
    }

    @Override
    public void showHeight() {

    }

    @Override
    public int getRollNo() {
        return rollNo;
    }

    @Override
    public float getSalary() {
        return sal;
    }
}

interface I{
    static void show(){
        System.out.println("show method only");
    }
}

public class InterfaceExample implements I {
    public static void main(String[] args) {
        Principle p1 = new Principle("Satish","DON",2200.0f,22);
        p1.showName();
        p1.shoeCollegeName();
        p1.showAge();

        I.show();
    }
}

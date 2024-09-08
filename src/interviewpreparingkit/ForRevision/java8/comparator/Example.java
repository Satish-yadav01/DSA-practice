package interviewpreparingkit.ForRevision.java8.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student{
    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}


public class Example {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 22));
        students.add(new Student("Jane", 15));
        students.add(new Student("Jack", 25));

        students.sort(new AgeComparator());
        System.out.println(students);
    }
}

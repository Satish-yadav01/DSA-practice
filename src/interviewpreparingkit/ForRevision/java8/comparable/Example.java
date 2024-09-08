package interviewpreparingkit.ForRevision.java8.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Example {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", 18));
        people.add(new Person("Jane", 22));
        people.add(new Person("Bob", 15));

        Collections.sort(people);
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

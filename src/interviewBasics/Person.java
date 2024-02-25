package interviewBasics;

public class Person {
    public static void main(String[] args) {
        ImmutablePerson immutablePerson = new ImmutablePerson("Satish",22);
        String name = immutablePerson.getName();
        int age = immutablePerson.getAge();
        System.out.println("Name : " + name + " age : "+ age);
    }
}

package interviewpreparingkit.ForRevision.java8;

import java.util.function.Consumer;

public class Java8Features {
    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        list.forEach(new Consumer<Integer>() {
//
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

        Person satish = new Person("Satish", 22);
        satish.getAgeAfter10Years(new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getAgeAfter10Years(Consumer<Integer> action){
        action.accept(this.age + 10);
    }

}
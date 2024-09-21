package interviewpreparingkit.questionPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Question1: Write a Java program using lambda expressions to sort a list of strings based on their length.
class Questions1{
    public static void method1(){
        List<String> list = Arrays.asList("SatishYadav", "Jerry", "Alex", "Bob");

        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(list);
    }

    //Question2: Given a list of integers, write a program to find the sum of all even numbers using the Java 8 Stream API.
    public static void isEven(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }

//    Question: How can you avoid NullPointerException using Optional in Java 8? Demonstrate using a simple example.
    public static void avoidNullPointerExp(){
        String str = null;
        Optional<String> s = Optional.ofNullable(str);
        String emptyString = s.orElse("Empty String");
        System.out.println(s.orElseGet(() -> "satish"));
        System.out.println(emptyString);
    }

//    Question: Write a program to group a list of strings by their first letter using Java 8 streams.
    public static void groupAndCollect(){
        List<String> list = List.of("Satish", "shyam", "Sayan", "Abhi", "Arnav", "Naman", "Nandu");
        Map<Character, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(collect);
    }

//    Question: Given a list of integers, create a new list that contains the square of only the odd numbers using Java 8 streams.
    public static void filterMap(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        list.stream()
                .filter(x->x%2!=0)
                .map(x->x*x)
                .forEach(System.out::println);
    }

//    Question: Given a list of integers, find the first even number greater than 3 using Java 8 streams.
    public static void findFirstEvenNumber(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer i = list.stream()
                .filter(x -> x % 2 == 0)
                .filter(x -> x>7)
                .findFirst()
                .get();

        System.out.println(i);

    }

//    Question: Given a list of strings, write a Java 8 program to join them with a comma (,).
    public static void terminalOperation(){
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
        String collect = words.stream()
                .collect(Collectors.joining(","));

        System.out.println(collect);
    }

//    8. Custom Functional Interface


}




public class Questions {
    public static void main(String[] args) {
//        Questions1.method1();
//        Questions1.isEven();
//        Questions1.avoidNullPointerExp();
//        Questions1.groupAndCollect();
//        Questions1.filterMap();
        Questions1.terminalOperation();

    }
}

package interviewpreparingkit.ForRevision.java8.optional;

import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);
        Optional.of(list).ifPresent(System.out::println);
    }
}



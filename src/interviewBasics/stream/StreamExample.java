package interviewBasics.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list1 = list.stream().filter((i) -> i % 2 == 0).map(i -> i * 2).collect(Collectors.toList());
        list1.stream().forEach(i-> System.out.print(i+" "));
//        list.stream().map()
        System.out.println();
        List<Integer> list2 = Arrays.asList(3, 2, 4, 5, 7, 9);
        list2.stream().sorted().forEach(i-> System.out.print(i+" "));

        System.out.println();
        list2.stream().forEach(System.out::println);
        Optional<Integer> min = list2.stream().min((x, y) -> x.compareTo(y));
        System.out.println("min : " + min);
    }
}

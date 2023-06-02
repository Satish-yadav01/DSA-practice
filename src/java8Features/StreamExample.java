package java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i <=10; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        //map
//        List<Integer> integers = list.stream().map(listElement -> listElement * 2).toList();
//        System.out.println(integers);
//
//        Object[] toArray = list.stream().filter((element) -> element % 2 == 0).toArray();
////        System.out.println(toArray);
//
//        for (int i = 0; i < toArray.length; i++) {
//            System.out.print(toArray[i]+" ");
//        }



        //filter
//        counting empty string
        String[] arrayString = new String[]{"java", "c", "", "c++", "","","javascript","nodejs","",""};
        long count = List.of(arrayString).stream()
                .filter((element) -> element.isEmpty())
                .count();
        System.out.println(count);

        //count String whose length is more than 3
        List.of(arrayString).stream()
                .filter(element->element.length()>3)
                .forEach(res->System.out.print(res+" "));

        //count no of strings which starts with j
        System.out.println();
        long j = List.of(arrayString).stream()
                .filter(element -> element.startsWith("j"))
                .count();


        //remove all empty string from the list
        List.of(arrayString).stream()
                .filter(element -> !element.isEmpty())
                .forEach(res -> System.out.print(res + " "));
        System.out.println();

        //Convert String to uppercase and Join them with coma
        String collect = List.of(arrayString).stream()
                .map(element -> element.toUpperCase())
                .collect(Collectors.joining("-"));
        System.out.println(collect);

        //convert first letter of string in upper case
//        ["java", "c", "", "c++", "","","javascript","nodejs","",""]
//        first filter the empty string then apply map function to uppercase
        List<String> strings = List.of(arrayString).stream()
                .filter(word->!word.isEmpty())
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .toList();
        System.out.println(strings);

        //Create a List of the square of all distinct numbers
//        [9, 10, 3, 4, 7, 3, 4]
        int[] array = {9, 10, 3, 4, 7, 3, 4};
        Arrays.stream(array)
                .map(i->i*i)
                .distinct()
                .forEach(i-> System.out.print(i+" "));

        //Get count, min, max, sum, and the average for numbers
        List<Integer> ints = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> ints1 = ints.stream().sorted().toList();
        System.out.println(ints1);


    }
}

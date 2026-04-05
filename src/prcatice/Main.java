package prcatice;


import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    double dept;
    int salary;
    int age;

    Employee(String name, double dept, int salary, int age) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
    }

    public Employee(String name, int sal) {
        this.name = name;
        this.salary = sal;
    }

    public String getName() { return name; }
    public double getDept() { return dept; }
    public int getSalary() { return salary; }
    public int getAge() { return age; }
}



public class Main {
    public static void main(String[] args) {
////    Given a list of integers, return only even numbers.
//        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,6,6,7,7,7,8,8,8);
//
//        list.stream().filter(num-> num %2==0).forEach(n-> System.out.print(n+" "));
//
////        2. Convert strings to uppercase
//        List<String> stringList = Arrays.asList("hello","world","java","programming");
//
//        stringList.stream().map(s->s.toUpperCase()).forEach(n-> System.out.print(n+" "));
//
////        3. Sum of all numbers
//        list.stream().reduce(0,Integer::sum);
//
//        //remove duplicates
//        list.stream().distinct().forEach(n-> System.out.print(n + " "));
//
////🔥 3. Combine skip() + limit() (Very Important) => used for pagination
////        use 2nd page
//        System.out.println();
//        List<Integer> collect = list.stream()
//                .skip(1)
//                .limit(1)
//                .collect(Collectors.toList());
//        collect.forEach(n-> System.out.print(n+" "));
//
//        System.out.println();
//        List<String> names = Arrays.asList("A", "BB", "CCC", "DD", "E");
//
//        Map<Integer, Long> result = names.stream()
//                .peek(name -> System.out.println(name + " : " + name.length()+" "))
//                .collect(Collectors.groupingBy(
//                        s -> s.length(),
//                        Collectors.counting()
//                ));
//
//        System.out.println(result+" ");
//
//        List<Employee> employees = Arrays.asList(
//                new Employee("A", "IT", 1000, 25),
//                new Employee("B", "HR", 2000, 30),
//                new Employee("C", "IT", 3000, 28),
//                new Employee("D", "HR", 1500, 35),
//                new Employee("E", "Finance", 2000, 40)
//        );
//
//        Map<String, List<String>> result1 =
//                employees.stream()
//                        .collect(Collectors.groupingBy(
//                                e -> e.getDept(),
//                                Collectors.mapping(
//                                        e -> e.getName().toUpperCase(),
//                                        Collectors.toList()
//                                )
//                        ));
//
//
//        List<Integer> numbers = List.of(1, 2, 3, 2, 4, 5, 1);
//
//        List<Integer> list1 = numbers.stream()
//                .distinct()
//                .toList();
//
//        Set<Integer> seen = new HashSet<>();
//
//        List<Integer> duplicates =
//                numbers.stream()
//                        .filter(n -> !seen.add(n))
////                        .distinct()
//                        .toList();
//
//        System.out.println(list1);
//        System.out.println(duplicates);


//        🔥 2️⃣ Find First Non-Repeating Character
//        String input = "pqrppswiss";
//
//        Map<Character, List<Character>> collect = input.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        c -> c
//                ));
//
//        System.out.println(collect);

//        Character firstOccurenceChar = input.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        c -> c,
//                        LinkedHashMap::new,
//                        Collectors.counting()
//                ))
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue() == 1)
//                .map(e -> e.getKey())
//                .findFirst()
//                .orElse(null);
//
//        System.out.println("result : " + firstOccurenceChar);


////        🔥 3️⃣ Find last Second & Third-Highest Number
//        List<Integer> numbers = List.of(10, 20, 30, 40,50);
//
//        List<Integer> list = numbers.stream().sorted(Comparator.reverseOrder())
//                .skip(1)
//                .limit(2)
//                .toList();
//
//        System.out.println("second Highest Number :" + list);
//
////        find second-highest number
//        Integer secondHighestNumber = numbers.stream().sorted(Comparator.reverseOrder())
//                .skip(1)
////                .findFirst()
//                .findAny()
//                .orElse(null);
//
//        System.out.println("Second Highest Number : " + secondHighestNumber);

//

//        🔥 4️⃣ Group Strings by Length
        List<String> words = List.of("hi", "hello", "hey", "world");
        Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(
                word -> word.length()
        ));

        System.out.println("collect : " + collect);


//        🔥 5️⃣ Count Frequency of Each Element
        List<String> items = List.of("apple", "banana", "apple");
        Map<String, Long> collect1 = items.stream().collect(Collectors.groupingBy(
                item -> item,
                Collectors.counting()
        ));

        System.out.println("counts : " + collect1);

//        🔥 6️⃣ Find Even Numbers and Square Them
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> list = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .toList();

        System.out.println("list : " + list);

//        🔥 7️⃣ Sort Employees by Salary
        List<Employee> employees = List.of(
                new Employee("Amit", 50000),
                new Employee("Neha", 70000),
                new Employee("Raj", 60000)
        );

        List<Employee> list1 = employees.stream()
                .sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
                .toList();

        list1.forEach(emp -> System.out.print(emp.getSalary() + " "));


//        🔥 8️⃣ Join Strings
        List<String> names = List.of("A", "B", "C");
        String collect2 = names.stream().collect(Collectors.joining("," ,"[{*","*}]"));
        System.out.println("\njoin String : " + collect2);

//        🔥 9️⃣ Find Longest String
        List<String> newWords = List.of("hi", "hello", "world Tour");
        String s = newWords.stream()
                .max((w1, w2) -> w1.length() - w2.length())
                .orElse(null);
        System.out.println("s : " + s);


//        🔥 🔟 Partition Numbers (Even/Odd)
        List<Integer> numbers2 = List.of(1, 2, 3, 4);
        Map<Boolean, List<Integer>> collect3 = numbers2.stream().collect(Collectors.partitioningBy(
                n -> n % 2 == 0
        ));
        System.out.println("collect3 : " + collect3);

        List<String> words2 = List.of("eat", "tea", "tan", "ate", "nat", "bat");

        Map<String, List<String>> result =
                words2.stream()
                        .collect(Collectors.groupingBy(word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }));

        System.out.println("result : " + result);

    }
}

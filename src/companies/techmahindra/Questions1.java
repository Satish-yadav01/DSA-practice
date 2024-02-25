package companies.techmahindra;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Questions1 {
    public static void main(String[] args) {
        List<String> list1 = new LinkedList<>();
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("ab");

        // Filter out the even numbers
        List<String> evenNumbers = list1.stream()
                .filter(s -> isNumeric(s) && Integer.parseInt(s) % 2 == 0)
                .collect(Collectors.toList());

        // Print the result
        System.out.println("Even Numbers: " + evenNumbers);
    }

    // Helper method to check if a string is numeric



    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

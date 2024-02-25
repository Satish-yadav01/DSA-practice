package interviewBasics.codingQuestions;

import java.util.LinkedHashSet;

//remove duplicates from a string
public class Question2 {
    public static void main(String[] args) {
        String str = "sandeep";
        System.out.println(revomeDuplicates(str));
    }

    private static String revomeDuplicates(String str) {
        StringBuffer result = new StringBuffer();
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            linkedHashSet.add(c);
        }
        System.out.println(linkedHashSet);
        for (char c: linkedHashSet) {
            result.append(c);
        }
        return result.toString();
    }
}

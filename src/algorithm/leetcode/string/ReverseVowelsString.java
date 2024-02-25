package algorithm.leetcode.string;

import java.util.Stack;

public class ReverseVowelsString {
    public static void main(String[] args) {
        String s = reverseVowels("hello");
        System.out.println(s);

    }

    public static String reverseVowels(String s) {
        StringBuilder vowel = new StringBuilder();

        for (int i = 0; i <= s.length() - 1; i++) {
            if(isVowel(s.charAt(i))){
                vowel.append(s.charAt(i));
            }
        }

        String reverseVowel = vowel.toString();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <=reverseVowel.length()-1 ; i++) {
            stack.push(reverseVowel.charAt(i));
        }
//        System.out.println(stack);

        StringBuilder sbr = new StringBuilder();
        for(int i=0; i<=s.length()-1; i++){

            if(isVowel(s.charAt(i))){
                sbr.append(stack.pop());
                continue;
            }
            sbr.append(s.charAt(i));
        }


        return sbr.toString();
    }

    public static boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

}

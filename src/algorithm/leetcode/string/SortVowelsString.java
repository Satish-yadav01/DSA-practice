package algorithm.leetcode.string;

import java.util.Arrays;
import java.util.Stack;

public class SortVowelsString {
    public static void main(String[] args) {
        String s = sortVowels("lYmpH");
        System.out.println(s);
    }

    public static String sortVowels(String s) {
        StringBuilder vowel = new StringBuilder();
        //extract vowel
        for (int i = 0; i <=s.length()-1; i++) {
            if(isVowel(s.charAt(i))){
                vowel.append(s.charAt(i));
            }

        }
        if(vowel.length() <=0){
            return s;
        }
        System.out.println("without sorted : " + vowel);

        //sort vowel
        char[] charArray = vowel.toString().toCharArray();
        Arrays.sort(charArray);

        System.out.println("sorted : "+String.valueOf(charArray));

        //put sorted vowel into stack after reversing charArray
        Stack<Character> stack = new Stack<>();

        //reverse
        for (int i = 0; i <= (charArray.length-1)/2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = temp;
        }

        for (int i = 0; i <= charArray.length-1; i++) {
            stack.push(charArray[i]);
        }

        //merge sorted vowel and consotant
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i <= s.length()-1; i++) {
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

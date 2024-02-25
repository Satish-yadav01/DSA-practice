package interviewBasics.string;

import java.util.Locale;

//Q. Question: Determine whether a given string is a palindrome (reads the same forwards and backwards).
public class PalindromeExample {

    public static String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(String str){
        System.out.println("str : " + str);
        String s = str.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        System.out.println("s : "+ s);
        String reverseString = reverse(s);
        System.out.println("reverse string : " + reverseString);
        if(reverseString.equals(s)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "@#s-nA-an-s#@";
        if(isPalindrome(str)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

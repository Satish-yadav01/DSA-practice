package interviewBasics.hackerEarth;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean isPalindrome = true;
        String lowStr = s.toLowerCase();
        for (int i = 0; i < lowStr.length() - 1; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }
    }
}

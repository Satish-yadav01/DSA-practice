package algorithm.leetcode.twopointers;

/*
* Is Palindrome -Easy
Solved
Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

Example 1:

Input: s = "Was it a car or a cat I saw?"

Output: true
Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.

Example 2:

Input: s = "tab a cat"

Output: false
Explanation: "tabacat" is not a palindrome.

Constraints:

1 <= s.length <= 1000
s is made up of only printable ASCII characters.
*
* */
import java.util.Arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("Was it a car or a cat I saw?");
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (isSymbol(leftChar)) {
                left++;
                continue;
            } else if (isSymbol(rightChar)){
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) !=
                    Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isSymbol(char ch) {
        return !Character.isLetter(ch) && !Character.isDigit(ch);
    }
}

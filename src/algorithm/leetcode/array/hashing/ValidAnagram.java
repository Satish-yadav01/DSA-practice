package algorithm.leetcode.array.hashing;

/*
*Is Anagram  - Easy
Solved
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
Example 2:

Input: s = "jar", t = "jam"

Output: false
Constraints:

s and t consist of lowercase English letters.

*
* */

public class ValidAnagram {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] dp = new int[26];

        for(int i=0; i<=s.length()-1; i++){
            dp[s.charAt(i) - 'a']++;
            dp[t.charAt(i) - 'a']--;
        }

        for(int element : dp){
            if(element !=0 ) return false;
        }

        return true;
    }
}

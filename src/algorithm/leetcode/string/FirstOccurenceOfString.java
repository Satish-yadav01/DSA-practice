package algorithm.leetcode.string;
/*
Find the Index of the First Occurrence in a String
Q. Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

 */


public class FirstOccurenceOfString {
    public static void main(String[] args) {
        strStr("sadbutsad","sad");

    }

    public static int strStr(String haystack, String needle) {
        int index=0;
        boolean match= false;

        for (int i = 0; i <needle.length()-1; i++) {
            for (int j=0; j<=haystack.length()-1; j++){
                if(haystack.charAt(i) == needle.charAt(i)){
                    match = true;
                }
            }
        }
        return 0;
    }
}

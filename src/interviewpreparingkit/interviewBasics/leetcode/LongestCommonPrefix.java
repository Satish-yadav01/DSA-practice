package interviewBasics.leetcode;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


 */


public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;

        // Find the minimum length of strings in the array
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        StringBuilder commonPrefix = new StringBuilder();

        // Check each character at the same position in all strings
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);

            // Compare with the same position in other strings
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    // If characters don't match, return the current common prefix
                    return commonPrefix.toString();
                }
            }

            // If all characters at the current position match, add to the common prefix
            commonPrefix.append(currentChar);
        }

        return commonPrefix.toString();
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
//        String strs = ["dog","racecar","car"];

        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
}

package algorithm.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "AAABABB";
        int min=Integer.MAX_VALUE;
        int characteredReplacement = characterReplacement(s, 2);
        System.out.println("ans : "+ characteredReplacement);

    }

    public static int characterReplacement(String s, int k) {
        // Frequency array for counting the occurrences of each letter
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        // Sliding window, right pointer expands the window
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

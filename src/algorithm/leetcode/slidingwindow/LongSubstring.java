package algorithm.leetcode.slidingwindow;

import java.util.Arrays;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class LongSubstring {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("dvdf");
        System.out.println("length of longest substring: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] dp = new int[128];
        Arrays.fill(dp, -1);
        int maxLength=0;

        int left=0;
        for(int right=0; right<=s.length()-1; right++){
            if(dp[s.charAt(right)] >=left ){
                left = dp[s.charAt(right)] + 1;
            }
            dp[s.charAt(right)] = right;
            maxLength = Math.max(right-left + 1,maxLength);

        }

        return maxLength;
    }
}

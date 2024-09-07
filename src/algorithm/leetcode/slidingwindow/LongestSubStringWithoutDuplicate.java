package algorithm.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutDuplicate {
    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("bbbbb");
        System.out.println("length: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength=0;
        int length=0;
        for(char c : s.toCharArray()){
            if(set.add(c)){
                length++;
            }else{
                set.clear();
                length=1;
            }

            maxLength = Math.max(length,maxLength);
        }
        return maxLength;
    }
}

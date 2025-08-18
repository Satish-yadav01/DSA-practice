package mockInterview;

/*
* Given a string, find the length of the longest substring without repeating characters.
*
* s = "abcabcbb"
* 3   // "abc" is the longest substring without repeating characters
*
*
* Intuition:
* 1. generate All substring with uniqueness using HashMap and keep track of maxLength
* 2. using set
* 3. using map
* 4. using array constant Space.
*
*/


import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        String s = "abcabbcbb";
        System.out.println("brute force : " + getMaxSubString(s));
        System.out.println("better Approach Using Set: " + getMaxSubString2(s));
        System.out.println("better Approach Using Map: " + getMaxSubString3(s));
        System.out.println("better Approach Using Map: " + lengthOfLongestSubstring(s));
    }

    private static int getMaxSubString(String s) {
        int maxLen=0;
        for(int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<s.length(); j++){
                if(set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i+1);
            }
        }
        return maxLen;
    }

    private static int getMaxSubString2(String s) {
        int l=0, r=0, maxlen=0;
        Set<Character> set = new HashSet<>();

        while(r < s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            set.add(s.charAt(r));
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }

        return maxlen;
    }

    //using map
    private static int getMaxSubString3(String s){
        Map<Character,Integer> map = new HashMap<>();
        int l=0, r=0, maxlen=0;

        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                l = map.get(s.charAt(r))+1;
            }

            map.put(s.charAt(r),r);
            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }

        return maxlen;
    }

    //using constant space
    public static int lengthOfLongestSubstring(String s) {
        int l=0, r=0, maxLen=0;
        int []dp = new int[256];
        Arrays.fill(dp,-1);

        while (r < s.length()){
            if(dp[s.charAt(r)] >= l){
                l = 1 + dp[s.charAt(r)];
            }
            dp[s.charAt(r)] = r;
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }

}

package algorithm.leetcode.string;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".



Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0


Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.


 */

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    public static void main(String[] args) {
        int count = numJewelsInStones("aA", "aAAbbbb");
        System.out.println("count: "+count);

        StringBuilder sbr = new StringBuilder();
//        sbr.delete(0,sbr.length()-1);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0; i<=stones.length()-1; i++){
            if(!map.containsKey(stones.charAt(i))){
                map.put(stones.charAt(i),1);
            }
            else{
                map.put(stones.charAt(i),map.get(stones.charAt(i))+1);
            }
        }

        for(int i=0; i<= jewels.length()-1; i++){
            if(map.containsKey(jewels.charAt(i))){
                // System.out.println("key :"+map.getKey)
                count = count + map.get(jewels.charAt(i));
            }
        }

        return count;
    }
}

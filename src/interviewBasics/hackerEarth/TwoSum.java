package interviewBasics.hackerEarth;

import java.util.HashMap;


public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; //7
            if (hash.containsKey(complement)) {
                return new int[]{hash.get(complement), i};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No match found");
    }
}

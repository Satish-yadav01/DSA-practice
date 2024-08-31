package algorithm.leetcode.array.hashing;

import java.util.*;


/*
* Top K Elements in List  - Medium
Solved
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]
Example 2:

Input: nums = [7,7], k = 1

Output: [7]
Constraints:

1 <= nums.length <= 10^4.
-1000 <= nums[i] <= 1000
1 <= k <= number of distinct elements in nums.

*
*
* */



public class TopKElementv2 {
    public static void main(String[] args) {
        int[] topKFrequent = topKFrequent(new int[]{7,7}, 1);
        System.out.println(Arrays.toString(topKFrequent));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for(int i=0; i<=bucket.length-1; i++){
            bucket[i] = new ArrayList<>();
        }

        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int index=0;
        int[] res = new int[k];
        for(int i=bucket.length-1; i>0 && index<k; i--){
            if(bucket[i] != null){
                for(int element : bucket[i]){
                    res[index++] = element;
                    if(index == k) return res;
                }

            }
        }

        return res;

    }
}

package algorithm.leetcode.array.hashing;

/*
* Products of Array Discluding Self - Medium
Solved
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in
O
(
n
)
O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]
Example 2:

Input: nums = [-1,0,1,2,3]

Output: [0,-6,0,0,0]
Constraints:

2 <= nums.length <= 1000
-20 <= nums[i] <= 20
*
*
* */


import java.util.Arrays;

public class ProdArrayExceptItself {
    public static void main(String[] args) {
        int[] produced = productExceptSelf(new int[]{1,2,4,6});
        System.out.println(Arrays.toString(produced));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] product = new int[nums.length];

        left[0]=1;
        for(int i=1; i<=nums.length-1; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[right.length-1] = 1;
        for(int i = right.length-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        for(int i=0; i<=product.length-1; i++){
            product[i] = left[i] * right[i];
        }

        return product;
    }
}

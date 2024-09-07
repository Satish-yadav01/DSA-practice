package algorithm.leetcode.twopointers;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int trap = trap(new int[]{4,2,0,3,2,5});
        System.out.println("trap: " + trap);
    }

    public static int trap(int[] height) {
        int[] leftSum = new int[height.length];
        int[] rightSum = new int[height.length];
        int sum = 0;
        leftSum[0] = height[0];
        rightSum[height.length-1] = height[height.length-1];

        for(int i=1; i<=leftSum.length-1; i++){
            leftSum[i] = Math.max(leftSum[i-1], height[i]);
        }
        System.out.println("leftSum : " + Arrays.toString(leftSum));

        for(int i=rightSum.length-2; i>=0; i--){
            rightSum[i] = Math.max(rightSum[i+1], height[i]);
        }
        System.out.println("rightSUm : "+Arrays.toString(rightSum));

        for(int i=0; i<=height.length-1; i++){
            if(height[i] <= leftSum[i] && height[i] <= rightSum[i]){
                sum += Math.min(leftSum[i],rightSum[i]) - height[i];
            }
        }
        System.out.println("sum : "+sum);

        return sum;
    }
}

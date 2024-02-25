package algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MinimumNumberGame {
    public static void main(String[] args) {
        int[] numberGame = numberGame(new int[]{2,5});


        for (int i = 0; i <= numberGame.length-1; i++) {
            System.out.print(numberGame[i]+" ");
        }
    }

    public static int[] numberGame(int []nums){
        Arrays.sort(nums); //2,3,4,5
        int result[] = new int[nums.length];
        int index=0;
        int k=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<= nums.length-1; i++){
            stack.add(nums[i]);
            System.out.println("stack: "+stack.get(index));
            index++;

            if(index == 2){
                result[k] = stack.pop();
                System.out.println("result "+ result[k]);
                k++;
                result[k] = stack.pop();
                System.out.println("result "+ result[k]);
                k++;
                index=0;
            }

        }

        return result;
    }
}

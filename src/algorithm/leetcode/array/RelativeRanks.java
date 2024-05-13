package algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

public class RelativeRanks {
    public static void main(String[] args) {
        String[] relativeRanks = findRelativeRanks(new int[]{10,3,8,9,4,5});

        for (int i = 0; i < relativeRanks.length; i++) {
            System.out.print(relativeRanks[i]+",");

        }
    }

    private static String[] findRelativeRanks(int[] score) {
        int []temp = score;
        String []result = new String[score.length];
        Stack<String> stack = new Stack<>();
        stack.push("Bronze Medal");
        stack.push("Silver Medal");
        stack.push("Gold Medal");

        int[] sortedArr = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedArr);
        int[] reverse = reverse(sortedArr);

        for(int i=0; i<=score.length-1; i++){
            if(i < 3){
                result[i] = stack.pop();
            }else{
                result[i] = String.valueOf(i+1);
            }
        }

        return rearrange(score,reverse,result);
    }


    private static int[] reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        int endIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            reversedArray[endIndex - i] = arr[i];
        }

        return reversedArray;
    }

    private static String[] rearrange(int []score, int []reverse, String []result){
        String []finalResult = new String[result.length];

        for(int i=0; i<=reverse.length-1; i++){
            for(int j=0; j<=score.length-1; j++){
                if(reverse[i] == score[j]){
                    finalResult[j] = result[i];
                    break;
                }
            }
        }

        return finalResult;
    }
}

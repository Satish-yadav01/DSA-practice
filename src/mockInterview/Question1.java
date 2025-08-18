package mockInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/*
*
* 1. Question
Given a sorted array of integers and a target value, find the indices of the two numbers such that they add up to the target.
* arr = [2, 7, 11, 15], target = 9
* Indices: (0, 1)  // because arr[0] + arr[1] = 2 + 7 = 9
*/

/*
 * Intuition :
 * 1. go with the 2 for loop and this is a bruteforce Approach => Tc : O(n^2) SC : O(1)
 * 2. Use the better Approach using HashMap =>Tc: O(n)  + SC : O(n)
 * 3. 2 pointer Approach => TC: O(n) and SC: O(1)
 * */

public class Question1 {
    public static void main(String[] args) {

        int []arr = {2,7,11,15};
        int target = 19;
        System.out.println("bruteForce algorithm : " + Arrays.toString(worstAlgorithm(arr, target)));
        System.out.println("Better algorithm : " + Arrays.toString(betterApproach(arr, target)));
        System.out.println("best algorithm : " + Arrays.toString(bestApproach(arr, target)));
    }

    private static int[] worstAlgorithm(int []arr,int target){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(i !=j && arr[i] + arr[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    private static int[] betterApproach(int []arr, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++){
            int peek = target - arr[i];
            if(map.containsKey(peek)){
                return new int[]{map.get(peek),i};
            }
            map.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }

    private static int[] bestApproach(int []arr, int target){
        int l = 0, r = arr.length-1;
        while(l < r){
            int sum = arr[l] + arr[r];
            if(sum == target){
                return new int[]{l,r};
            } else if (sum > target) {
                r--;
            }else l++;
        }

        return new int[]{-1,-1};
    }

}



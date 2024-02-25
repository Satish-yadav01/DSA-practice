package algorithm.leetcode.twopointers;

import java.util.Collections;
import java.util.List;

public class CountPairsWhoseSumisLessthanTarget {
    public static void main(String[] args) {
//        int countPairs = countPairs(List.of(-1, 1, 2, 3, 1), 2);
        System.out.println(List.of(-1, 1, 2, 3, 1));
//        System.out.println("Count pairs : " + countPairs);
    }

    public static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);  //O(nlogn)
        int count = 0;
        int left = 0;
        int right = nums.size()-1;

        while(left < right){
            if((nums.get(left) + nums.get(right) < target)){
                count = count + (right-left);
                left++;
            }else{
                right--;
            }
        }

        return count;
    }
}

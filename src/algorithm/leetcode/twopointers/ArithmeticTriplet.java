package algorithm.leetcode.twopointers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArithmeticTriplet {
    public static void main(String[] args) {
        int triplets = arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3);
        System.out.println(triplets);
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> seen = new HashSet<>();
        int cnt = 0;
        for(int num : nums) {
            seen.add(num);
            if(seen.contains(num-diff) && seen.contains(num-2*diff))
                cnt++;
        }
        StringBuilder sbr = new StringBuilder();
        LinkedList<Object> list = new LinkedList<>();
        List<List<Integer>> list1 = new LinkedList<>();
        return cnt;
    }
}

package algorithm.leetcode.twopointers;

import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<Integer> list = new LinkedList<>();
        List<List<Integer>> listResult = new LinkedList<>(new LinkedList<>());

        for(int i=0; i<=nums.length-3; i++){
            for(int j=i+1; j<=nums.length-2; j++){
                for(int k=j+1; k<=nums.length-1; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){

                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        System.out.println("list: " + list);

                    }

                }
            }
        }
        int count =0;
        List<Integer> objects = new LinkedList<>();
        for(int i=0; i<=list.size()-1; i++){
            if(count < 3){
                objects.add(list.get(i));
                count++;
            }
            if(count == 3){
                count=0;
            }
        }
        return listResult;
    }
}

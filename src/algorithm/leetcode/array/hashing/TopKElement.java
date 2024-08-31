package algorithm.leetcode.array.hashing;

import java.util.Arrays;

public class TopKElement {
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println("ints = " + Arrays.toString(ints));
        for(int i=0; i<=ints.length-1; i++){
            System.out.print(ints[i]+" ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k){
        int []matcher = new int[nums.length];

        Arrays.fill(matcher,-1);

        Arrays.sort(nums);
        int count=1;

        for(int i=0; i<=nums.length-2; i++){

            if(matcher[nums[i]] == -1 && count ==k){
                matcher[nums[i]] = nums[i];

            }
            System.out.println();
            System.out.print("i : " + i+" count: "+count);
            System.out.println();
            System.out.print("matcher[nums["+i+"]] " + matcher[nums[i]] + " nums["+i+"] : "+nums[i]);

            if(nums[i] == nums[i+1]){
                count++;
            }else{
                count=0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=matcher.length-1; i++){
            if(matcher[i] != -1){
                sb.append(matcher[i]+",");
            }
        }

        String[] split = sb.toString().split(",");
        System.out.println("split:");
        for(int i=0; i<=split.length-1; i++){
            System.out.print(split[i] + " ");
        }

        int[] integers = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            integers[i] = Integer.parseInt(split[i].trim());
        }

        return integers;
    }
}

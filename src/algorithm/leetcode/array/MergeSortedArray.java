package algorithm.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int []nums1 = new int[]{1,2,3,0,0,0};
        int m=3;
        int []nums2 = new int[]{2,5,6};
        int n=3;

        merge(nums1,m,nums2,n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int []nums3 = new int[m+n];
        for(int i=0; i<=m-1; i++){
            nums3[i] = nums1[i];
        }

        for(int i=0; i<= n-1; i++){
            nums3[m+i] = nums2[i];
        }

        Arrays.sort(nums3);
        Arrays.stream(nums3).forEach(e->System.out.print(e+" "));
    }
}

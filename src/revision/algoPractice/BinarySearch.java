package revision.algoPractice;

import java.util.Arrays;
import java.util.PrimitiveIterator;

public class BinarySearch {
    public static void main(String[] args) {
        int k = 10;
        int a[] = {2,3,1,4,5,6,8,7};
        boolean b = binarySearch(a, k);
        if (b){
            System.out.println("found");
        }else {
            System.out.println("not found");
        }
    }

    private static boolean binarySearch(int a[],int k) {
        Arrays.sort(a); //O(nlogn)  =>quick sort
        Arrays.stream(a).forEach(System.out::println);
        int left = 0;
        int right = a.length-1;

        while (left <= right){
            int mid = (left + right)/2;
            if(a[mid]==k){
                return true;
            }else if(a[mid]<k){
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}

package array;

public class KadenseAlgo {
    public static void main(String[] args) {
        int a[] = {-5,4,6,-3,4,-1};
        System.out.println(maxSumArray(a));
    }

    private static int maxSumArray(int[] a) {
        int maxSum=0,curSum=0;
        for (int i = 0; i < a.length; i++) {
            curSum = curSum + a[i];
            if(curSum>maxSum){
                maxSum = curSum;
            }
            if(curSum<0){
                curSum = 0;
            }
        }
        return maxSum;
    }
}

package InterviewCoadingQuestionPractice;

public class BimarySearch {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7,8,9};
        boolean search = search(a, 5);
        System.out.println(search);
    }

    public static boolean search(int [] a,int k){
        int left = 0;
        int right = a.length-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(a[mid] == k){
                return true;
            } else if (a[mid]<k) {
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

}

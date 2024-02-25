package interviewBasics.hackerEarth;

import java.util.Scanner;

public class SwapSum {
    public static void main(String[] args) {
        // Write your code here
        System.out.println("Enter test case: ");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t!=0){
            int sum = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();

            int a[] = new int[n];
            int b[] = new int[n];

            for(int i=0; i<= n-1; i++){
                a[i] = sc.nextInt();
            }

            for(int i=0; i<= n-1; i++){
                b[i] = sc.nextInt();
            }

            //to find max

            while(k!=0){
                int index = findMaxIndex(b);
                int temp = b[index];
                b[index] = a[index];
                a[index] = temp;
                k--;
            }

            //to find maximum sum
            for(int i=0; i<=a.length-1; i++){
                sum = sum + a[i];
            }
            System.out.println(sum);
            t--;
        }
    }

    public static int findMaxIndex(int b[]){
        int max=b[0],index=0;
        //logic
        for(int i=0; i<=b.length-1; i++){
            if(max<b[i]){
                max = b[i];
                index=i;
            }
        }
        return index;
    }

}

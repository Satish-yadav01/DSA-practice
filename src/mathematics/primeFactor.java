package mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class primeFactor {
    public static void main(String[] args) {
        System.out.println("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] factors = factors(n);
        for (int i=1;i<factors.length;i++){
            if(factors[i] == true){
                System.out.println(i);

            }
//            System.out.println(i+" "+factors[i]);
        }
    }
    public static boolean[] factors(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i=2; i*i<=n; i++){
            for(int j=2*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}

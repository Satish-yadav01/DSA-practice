package gfg.maths;

public class GCD {
    public static void main(String[] args) {
        int ans = gcd(10,15);
        System.out.println("ans : " + ans);
    }

    //naive approach
    public static int gcd(int a,int b){
        int min = Math.min(a, b);
        for(int i=2; i<=min; i++){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return -1;
    }
}

package gfg.maths;

public class Factorial {
    public static void main(String[] args) {
        long fact = fact(5);
        System.out.println("fact : " + fact);

        System.out.println("factorial with recursion");
        System.out.println(factWithRecursion(5));
    }

    private static int factWithRecursion(int n) {
        if(n==0) return 1;
        return n * factWithRecursion(n-1);
    }

    public static long fact(int n) {
        long fact=1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }
}

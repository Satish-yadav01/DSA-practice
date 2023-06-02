package revision.algoPractice;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int ans=1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        System.out.println(ans);

        int fact = fact(n);
        System.out.println(fact);
    }

    private static int fact(int n) {
        if(n==0) return 1;

        return n* fact(n-1);

    }
}

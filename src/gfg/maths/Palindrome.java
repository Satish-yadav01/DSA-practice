package gfg.maths;

public class Palindrome {
    public static void main(String[] args) {
        int n = 78909872;
        if(checkPalindrome(n)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    private static boolean checkPalindrome(int n) {
        int p=n;
        int mod=0;
        int rev=0;

        for(int i=0; i<=n-1;i++){
            mod=n%10;
            rev = rev*10 + mod;
            n = n/10;
        }
        if(p==rev) return true;
        return false;
    }
}

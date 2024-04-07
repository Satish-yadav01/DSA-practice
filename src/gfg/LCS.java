package gfg;

//longest common subsequence without dp (dynamic programming)

public class LCS {
    public static void main(String[] args) {
        System.out.println("---Find longest common subsequence---");
        String s1 = "ABC";
        String s2 = "XYC";
        int lcs = findLCS(s1, s2, s1.length(), s2.length());
        System.out.println("lcs: "+ lcs);

    }

    public static int findLCS(String s1,String s2, int m, int n){
        //base case
        if(m==0 || n==0){
            return 0;
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + findLCS(s1,s2,m-1,n-1);
        }else {
            return Math.max(findLCS(s1,s2,m-1,n),findLCS(s1,s2,m,n-1));
        }
    }
}

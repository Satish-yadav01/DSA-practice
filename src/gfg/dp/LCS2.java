package gfg.dp;

//longest common subsequence using dynamic programming of memoization

import java.util.Arrays;

public class LCS2 {
    public static void main(String[] args) {
        System.out.println("---Find longest common subsequence---");
        String s1 = "ABC";
        String s2 = "XYC";
        int lcs = findLCS(s1, s2, s1.length(), s2.length());
        System.out.println("lcs: "+ lcs);
    }

    public static int findLCS(String s1,String s2, int m, int n){

        int memo[][] = new int[m+1][n+1];

        for (int i = 0; i <=m; i++) {
            Arrays.fill(memo[i],-1);
        }

        if(memo[m][n] != -1){
            return memo[m][n];
        }


        //base case
        if(m==0 || n==0){
            memo[m][n] =0;
        }else{
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                memo[m][n]= 1 + findLCS(s1,s2,m-1,n-1);
            }else {
                memo[m][n]= Math.max(findLCS(s1,s2,m-1,n),findLCS(s1,s2,m,n-1));
            }
        }

        return memo[m][n];
    }
}

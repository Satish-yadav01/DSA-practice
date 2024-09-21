package algorithm.leetcode.statck;

import java.util.ArrayList;
import java.util.List;

/*
* Generate Parentheses
Solved
You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.

Example 1:

Input: n = 1

Output: ["()"]
Example 2:

Input: n = 3

Output: ["((()))","(()())","(())()","()(())","()()()"]
You may return the answer in any order.

Constraints:

1 <= n <= 7
*
* */

public class GenerateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(2);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve("",0,0,n,ans);
        return ans;
    }

    private static void solve(String cur,int open, int close, int total, List<String> ans){
        if(cur.length() == 2*total){
            ans.add(cur);
            return;
        }
        if(open < total){
            solve(cur+"(",open+1,close,total,ans);
        }
        if(close < open ){
            solve(cur+")", open, close+1, total, ans);
        }
    }
}

package interviewBasics.hackerEarth;

import java.util.Scanner;

/*

Problem
This is the easiest question of the entire set. :D

Just find 6n and print last two digits.

Note : Suppose if your answer is 06 then print just 6.

Input

The first line of the input contains a single integer T (1 ≤ T≤ 10^5) — the number of test cases.

Each test case contains a single line containing single number n. ( 1 <= n <= 10^50 )

Output

Print T lines. In each line print the desired output

AUTHOR : spaul100

Sample Input
2
1
3
Sample Output
6
16
Time Limit: 1
Memory Limit: 256
Source Limit:
Explanation
Case 1 : n = 1, 6^1 = 6, So answer is 6
 */
public class SquareProblem {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t!=0){
            int ans=1;
            String s = sc.next();
            for(int i=1;i<=s.length();i++){
                ans = ans*6;
            }

            System.out.println("s: "+s);
            if(s.length()>1){
                s = s.charAt(s.length()-2)+""+s.charAt(s.length()-1);
                ans = Integer.parseInt(s);
                System.out.println(ans);
            }else{
                ans = Integer.parseInt(s);
                System.out.println(ans);
            }


            t--;
        }
    }
}

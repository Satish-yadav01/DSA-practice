package interviewBasics.hackerEarth;
/*


Problem
You are required to enter a word that consists of
 and
 that denote the number of Zs and Os respectively. The input word is considered similar to word zoo if
.

Determine if the entered word is similar to word zoo.

For example, words such as zzoooo and zzzoooooo are similar to word zoo but not the words such as zzooo and zzzooooo.

Input format

First line: A word that starts with several Zs and continues by several Os.
Note: The maximum length of this word must be
.
Output format

Print Yes if the input word can be considered as the string zoo otherwise, print No.

Sample Input
zzzoooooo
Sample Output
Yes
Time Limit: 0.5
Memory Limit: 256
Source Limit:
 */


import java.util.HashMap;
import java.util.Scanner;

public class Zoos {
    public static void main(String[] args) {
        System.out.println("Enter input:\n");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String lowStr = s.toLowerCase();
        //using map
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<= s.length()-1; i++){
            if(!map.containsKey(lowStr.charAt(i))){
                map.put(lowStr.charAt(i),1);
                System.out.println(map);
            }else{
                map.put(lowStr.charAt(i),map.get(lowStr.charAt(i)) + 1);
//                map.replace(s.charAt(i),map.get(s.charAt(i)),map.get(s.charAt(i)+1));
            }

        }

        int x = map.get('z');
        int y = 2 * x;
//        System.out.println(map);
//        map.entrySet().
        System.out.println("testing");
        if(map.get('o') == y){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

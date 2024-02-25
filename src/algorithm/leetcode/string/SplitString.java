package algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SplitString {
    public static void main(String[] args) {
        String s = "LLLLRLLRRLLRLRLRLRLRRLLRRLLRLRRRRLLRRLLLRLRRRLRRLLRLRRRRLLRLRLRLRRLRLRLLLRLLRRLRLRRRRRLLRRRLRRLLRLLRLLLRLRLLLLLRLLLLLLRRLLLRRRRRRLRRLRLRRLLRLRRRRRRLRRRRRLLRRLLRRLRLLRRRRLRRRRLRLRLLRRRLLLLRRLLLLRRLRRRLLRRRRRRLRLLLRLRRLRLLLRRRLRLLRRLRLRLLLRRLLLLRRLRLRRLRLRRRRLRLRLRLRRLLRRLRLRLLLRLRRRLRRRLRRLRLLLRLLRRRRRLRLLLLRRLLRLLLRRLLRRLLLLLLRLLRRRRRRLRRLLLRRLLLLRRLRRLLLLLRRRRLRLRRLRLLRLLLRLLRLLLRLLRLRLRLLLRLLLLL";

        int subStringCount = balancedStringSplit(s);
        System.out.println("subStringCount: "+subStringCount);
    }

    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sbr = new StringBuilder();
        int subStringCount=0;

        for(int i=s.length()-1; i>=0; i--){
            stack.push(s.charAt(i));
        }

        for(int i=0; i<= s.length()-1; i++){
            sbr.append(String.valueOf(stack.pop()));
            if(isBalancedString(sbr.toString())){
                subStringCount++;
                sbr.delete(0,sbr.length());
            }
        }
        return subStringCount;
    }


    public static boolean isBalancedString(String s){
        Map<Character,Integer> map = new HashMap<>();

        if(s.length() == 1){
            return false;
        }

        if((s.contains("R") && s.contains("L"))){

            for(int i=0; i<=s.length()-1; i++){
                if(!map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),1);
                }else{
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }
            }

            if(map.get('R') == map.get('L')){
                return true;
            }
        }



        return false;
    }
}

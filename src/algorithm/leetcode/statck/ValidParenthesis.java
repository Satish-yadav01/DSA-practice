package algorithm.leetcode.statck;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        boolean valid = isValid("((())){}[]");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        if(s.length() < 2) return false;
        if(s.startsWith(")") || s.startsWith("]") || s.startsWith("}")) return false;
        if(s.length() %2 !=0 ) return false;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c== '{'){
                stack.push(c);
            }else if(c == ')' && (!stack.isEmpty() && stack.peek() == '(')){
                stack.pop();
            }else if(c == ']' && (!stack.isEmpty() && stack.peek() == '[')){
                stack.pop();
            }else if(c == '}' && (!stack.isEmpty() && stack.peek() == '{')){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}

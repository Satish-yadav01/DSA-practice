package interviewBasics.hackerEarth;


import java.util.Stack;

public class Parenthesis {

    public static boolean isParenthesisValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                System.out.println(c);
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                System.out.println(c);
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                System.out.println(c);
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                System.out.println(c);
                stack.pop();
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{(([[]))}";
        boolean isValid = isParenthesisValid(s);
        if(isValid){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
    }
}

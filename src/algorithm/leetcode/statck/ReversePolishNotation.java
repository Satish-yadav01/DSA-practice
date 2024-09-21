package algorithm.leetcode.statck;

import java.util.Stack;

/*
*Evaluate Reverse Polish Notation
Solved
You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.

Return the integer that represents the evaluation of the expression.

The operands may be integers or the results of other operations.
The operators include '+', '-', '*', and '/'.
Assume that division between integers always truncates toward zero.
Example 1:

Input: tokens = ["1","2","+","3","*","4","-"]

Output: 5

Explanation: ((1 + 2) * 3) - 4 = 5
Constraints:

1 <= tokens.length <= 1000.
tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].

*
* */



public class ReversePolishNotation {
    public static void main(String[] args) {
        int evalRPN = evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println(evalRPN);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String ch : tokens){
            String operation = match(ch);
            if(operation.equalsIgnoreCase("0")){
                stack.push(Integer.valueOf(ch));
            }else{
                int val1 = stack.pop();
                int val2 = stack.pop();
                switch(operation){
                    case "+":
                        stack.push(val1 + val2);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val1 * val2);
                        break;
                    case "/":
                        stack.push(Math.round(val2/val1));
                        break;
                }
            }
        }

        return stack.pop();
    }

    private static String match(String ch){
        return "+-*/".contains(ch) ? ch : "0";
    }
}

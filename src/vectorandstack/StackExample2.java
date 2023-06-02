package vectorandstack;

import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.add(3);
        stack.push(5);
        System.out.println(stack.empty());
        System.out.println(stack);
    }
}

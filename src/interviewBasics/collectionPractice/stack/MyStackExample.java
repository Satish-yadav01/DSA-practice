package interviewBasics.collectionPractice.stack;

public class MyStackExample {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.print();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.print();
        System.out.println();
        System.out.println(stack.peek());
        stack.print();
    }
}

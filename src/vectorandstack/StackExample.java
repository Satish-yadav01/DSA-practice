package vectorandstack;

import linkedlist.EmptyLinkedList;

public class StackExample {


    public static void main(String[] args) throws EmptyLinkedList {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 1; i <=10; i++) {
            stack.push(i);
        }
//        System.out.println(stack);
        stack.print();
    }
}

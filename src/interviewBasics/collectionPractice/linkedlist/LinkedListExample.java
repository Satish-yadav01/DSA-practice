package interviewBasics.collectionPractice.linkedlist;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        list.addLast(30);
//        list.removeFirst();
//        list.removeFirst();
        list.print();
        System.out.println();
        list.removeFirst();
        list.removeFirst();
        list.removeLast();
        list.print();
    }
}

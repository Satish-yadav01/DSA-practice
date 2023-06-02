package revision.LinkedList;

import linkedlist.EmptyLinkedList;

public class MyLinkedListExample {
    public static void main(String[] args) throws EmptyLinkedList {
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.add(1);
        for (int i = 0; i < 5; i++) {
            ll.add(i);
        }

        ll.print();
        System.out.println();
        System.out.println(ll.getLast());
        System.out.println(ll.remove());
        ll.print();

    }
}

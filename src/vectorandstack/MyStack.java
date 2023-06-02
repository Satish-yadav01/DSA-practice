package vectorandstack;

import linkedlist.EmptyLinkedList;
import linkedlist.MyLinkedList;

public class MyStack<E> {
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void push(E data) throws EmptyLinkedList {
        ll.addLast(data);
    }

    public E pop() throws EmptyLinkedList {
        if(ll.isEmpty()){
            throw new EmptyLinkedList("ll is empty");
        }

        return ll.removeLast();
    }
    public E peek() throws EmptyLinkedList {
        if(ll.isEmpty()){
            throw new EmptyLinkedList("ll is empty");
        }
        return ll.getLast();
    }

    public void print() throws EmptyLinkedList {
        ll.print();
    }
}

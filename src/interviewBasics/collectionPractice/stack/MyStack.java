package interviewBasics.collectionPractice.stack;

import interviewBasics.collectionPractice.linkedlist.MyLinkedList;

public class MyStack<E> {
    MyLinkedList<E> ll = new MyLinkedList();

    public void push(E data){
        ll.addLast(data);
    }

    public E pop(){
        return ll.removeLast();
    }

    public E peek(){
        return ll.getLast();
    }

    public void print(){
        ll.print();
    }
}

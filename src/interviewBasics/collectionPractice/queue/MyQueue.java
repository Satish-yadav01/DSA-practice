package interviewBasics.collectionPractice.queue;

import interviewBasics.collectionPractice.linkedlist.MyLinkedList;

public class MyQueue<E> {
    MyLinkedList<E> ll = new MyLinkedList<>();

    public void enqueue(E data){
        ll.addLast(data);
    }

    public void dequeue(){
        ll.removeFirst();
    }

    public void print(){
        ll.print();
    }
}

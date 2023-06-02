package revision.LinkedList;

import linkedlist.EmptyLinkedList;

public class MyLinkedList<E>{

    Node head;
    static class Node<E>{

        E data;
        Node next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    public void add(E data){
        Node<E> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public E remove() throws EmptyLinkedList {
        Node<E> removeNode;
        if(head == null){
            throw new EmptyLinkedList("LL is empty");
        }

        Node<E> temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        removeNode = temp.next;
        temp.next = null;
        return removeNode.data;
    }

    public E remove(int x) throws EmptyLinkedList {
        Node<E> removeNode = head;
        if(head == null){
            throw new EmptyLinkedList("LL is empty");
        }

        Node<E> temp = head;
        head = temp.next;
        return removeNode.data;
    }

    public void print() throws EmptyLinkedList {
        if(head == null ){
            throw new EmptyLinkedList("can not print from Empty LL");
        }

        Node<E> temp = head;
        while (temp.next != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public E getLast() throws EmptyLinkedList {
        if(head == null){
            throw new EmptyLinkedList("LL is empty");
        }

        Node<E> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp.data;
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
}

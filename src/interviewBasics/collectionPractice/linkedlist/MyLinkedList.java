package interviewBasics.collectionPractice.linkedlist;

interface Collection<E>{
    public void addFirst(E data);
    public void addLast(E data);
    E removeLast();
    E removeFirst();
    E getFirst();
    E getLast();
    boolean isEmpty();
    void print();

}

public class MyLinkedList<E> implements Collection<E> {

    Node<E> head;

    public static class Node<E>{
        E data;
        Node next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    @Override
    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    @Override
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node<E> temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
    }

    @Override
    public E removeLast() {
        Node<E> removeNode = head;
        try{
            if (head == null) {
                throw new Exception("LL should not be Empty to remove last");
            }
        }catch (Exception e){
            System.out.println("error : "+e.getMessage());
        }

        Node<E> temp = head;
        while(temp.next.next !=null){
            temp = temp.next;
        }

        removeNode = temp.next;
        temp.next = null;
        return removeNode.data;
    }

    @Override
    public E removeFirst() {
        Node<E> removeNode = head;
        try{
            if (head == null) {
                throw new Exception("LL should not be Empty to remove first");
            }
        }catch (Exception e){
            System.out.println("error : "+e.getMessage());
        }

        if(head.next == null){
            removeNode = head;
            head = null;
            return removeNode.data;
        }

        removeNode = head;
        head = head.next;


        return removeNode.data;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        Node<E> temp = head;
        while(temp.next!= null){
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        Node<E> temp = head;
        while (temp.next !=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.print(temp.data);
    }

}

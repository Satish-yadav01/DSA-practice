package algorithm.leetcode.linkedlist;

public class MergeLinkedList {
    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        initilizeList(list1,list2);

        MyLinkedList mergedLL = list1.merge(list1.head, list2.head);
        System.out.println("Merged LL: " + mergedLL.toString());
        mergedLL.print();
    }

    private static void initilizeList(MyLinkedList list1, MyLinkedList list2) {
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(7);
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list2.addLast(7);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(10);

        list1.print();
        list2.print();
    }
}

class MyLinkedList {

    Node head = null;

    static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            this.next = null;
        }
    }

    public void addLast(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void addFirst(int val) {
        if(head == null){
            head = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

    }

    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node removeFirst(){
        if(head == null){
            System.out.println("LL is empty");
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }

    public Node removeLast(){
        if(head == null){
            System.out.println("LL is empty");
            return null;
        }

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node removedNode = temp.next;
        temp.next = null;
        return removedNode;
    }

    public MyLinkedList merge(MyLinkedList.Node list1, MyLinkedList.Node list2){
        MyLinkedList linkedList = new MyLinkedList();
        MyLinkedList temp = linkedList;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                linkedList.addLast(list1.val);
                list1 = list1.next;
            }else {
                linkedList.addLast(list2.val);
                list2 = list2.next;
            }

        }

        while(list1 != null){
            linkedList.addLast(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            linkedList.addLast(list2.val);
            list2 = list2.next;
        }

        return temp;

    }

    public void print(Node list){
        if(list == null){
            System.out.println("LL is empty");
        }
        Node temp = list;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
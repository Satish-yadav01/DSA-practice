package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//Write a Java program to find the second largest element in an ArrayList of integers.
public class ListExample4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(13);

        for (int i : arrayList){
            System.out.print(i+" ");
        }
        System.out.println();
        Collections.sort(arrayList);  //O(nlogn)
        System.out.println(arrayList.get(arrayList.size()-2));


        //Write a Java program to reverse a LinkedList.
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(2);
        ll.add(3);
        ll.add(4);
//        Collections.sort(ll,Collections.reverseOrder());
        Collections.reverse(ll);
        System.out.println(ll);

        //Write a Java program to remove the first and last elements from a LinkedList.
        //[4,3,2]
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);

        //Finding the middle element of a LinkedList:
        ll.addAll(ll);
        ll.add(13);
        ll.add(14);
        ll.add(15);
        System.out.println("Question4\n list : "+ ll);
        Integer midElement = ll.get(ll.size() / 2);
        System.out.println(midElement);
    }

}

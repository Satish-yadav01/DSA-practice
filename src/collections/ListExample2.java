package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Write a Java program to sort an ArrayList of integers in ascending order
//Note : we can not sort arrayList without collections but we can after converting arrayList to array

public class ListExample2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);

//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add(5);
//        list2.add(6);
//        list2.add(7);
//        System.out.println(list);
//        System.out.println(list2);
//
//        list2.addAll(2,list);
//        System.out.println(list2);

        System.out.println("list : " + list);

        Collections.sort(list);
        System.out.println("sorted order : " + list);
        //reverse sort
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("reverse order : "+list);
    }



}

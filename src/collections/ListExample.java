package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//list
public class ListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        Set<Integer> list = new TreeSet<>();
        list.add(1);
        list.add(10);
        list.add(10);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);

        //arraylist into array
        Integer[] arr = new Integer[list.size()];
        arr = list.toArray(new Integer[0]);
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }


    }
}

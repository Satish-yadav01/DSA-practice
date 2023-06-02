package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

//Write a Java program to remove all elements from an ArrayList that are greater than a given value
public class ListExample3 {
    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7,8};
//        Scanner sc = new Scanner(System.in);
        int value = 7;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array){
            arrayList.add(i);
        }
        System.out.print(arrayList + " ");
        ArrayList<Integer> output = removeElementUsingIterator(arrayList,value);
        System.out.println(output);
    }

    private static ArrayList<Integer> removeElementUsingIterator(ArrayList<Integer> arrayList,int value) {
        Iterator<Integer> iterator = arrayList.iterator();
        System.out.println(iterator.next());
        while(iterator.hasNext()){
            int element = (Integer) iterator.next();
            if(element > value){
                iterator.remove();
            }
        }
        return arrayList;
    }

    private static ArrayList<Integer> removeElementUsingFor(ArrayList<Integer> arrayList,int value) {
        System.out.println("removeElementUsingFor");
        arrayList.removeIf((e)->e>value);
        return arrayList;
    }
}

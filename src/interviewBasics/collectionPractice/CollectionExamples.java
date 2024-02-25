package interviewBasics.collectionPractice;

import java.util.*;

public class CollectionExamples {
//    public static void print(int obj){
//        System.out.println("");
//    }

    public static void main(String[] args) {
        //1. ArrayList
//        List<Integer> list1 = new ArrayList<Integer>();
//
//        System.out.println(list1.isEmpty());
//        if(list1.isEmpty()){
//            for (int i = 1; i <=12; i++) {
//                list1.add(i*10);
//            }
//        }
//        System.out.println("size : "+ list1.size());
//        if(list1.size() >10){
//            while(list1.size() !=10){
//                list1.remove(0);
//            }
//
//        }
//        System.out.println("revised size : "+ list1.size());
//
//        // Get an iterator for the LinkedList
//        Iterator<Integer> iterator = list1.iterator();
//
//        while(iterator.hasNext()){
//            System.out.print(iterator.next()+" ");
//        }
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.addAll(list1);
//        Iterator<Integer> iterator1 = list2.iterator();
//        System.out.println("\nlist2");
//        while (iterator1.hasNext()){
//            System.out.print(iterator1.next()+" ");
//        }
//
//        LinkedList<Integer>  ll = new LinkedList<>();
//        ll.addAll(list2);
//        System.out.println("\nLinkedList");
//        for (int i = 0; i < ll.size() - 1; i++) {
//            System.out.print(ll.get(i)+" ");
//        }

        //vector
//        System.out.println("Vector");
//        Vector<Integer> vector = new Vector<>();
//        for (int i = 0; i <vector.size()-1; i++) {
//            vector.add(i);
//        }
//        System.out.println("Vector:"+ vector);
//
//        for (int i = 0; i < vector.size(); i++) {
//            System.out.println(vector.get(i));
//        }
//
//        for (int i: vector) {
//            System.out.print(i+" ");
//        }
//
//        Vector<String> vector2 = new Vector<>();
//        vector2.add("Apple");
//        vector2.add("Banana");
//        vector2.add("Cherry");
//
//        System.out.println("Vector: " + vector);
//        for (String i: vector2) {
//            System.out.print(i+" ");
//        }

        //stack
//        Stack<Integer> stack = new Stack<>();
//        stack.add(10);
//        stack.push(20);
//        stack.add(30);
//        stack.push(40);
//        stack.add(50);
//        stack.push(60);
//        stack.pop();
//        for (int i: stack) {
//            System.out.print(i+" ");
//        }

        //set  //hashset never maintains order
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(10);
//        hashSet.add(10);
//        hashSet.add(20);
//        hashSet.add(40);
//
//        Iterator<Integer> iterator = hashSet.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next()+" ");
//        }
//
//        //question : remove duplicate values of ArrayList
//        List<Integer> arrayList = new ArrayList<>();
//        arrayList.add(10);
//        arrayList.add(20);
//        arrayList.add(20);
//        arrayList.add(30);
//        System.out.println("\nArrayList\n");
//
//        //print ArrayList
//        for (int i = 0; i < arrayList.size() - 1; i++) {
//            System.out.println(arrayList.get(i));
//        }
//
//        LinkedHashSet<Integer> hashSet1 = new LinkedHashSet<>();
//        hashSet.addAll(arrayList);
////        System.out.println(hashSet1);
//
//        for (Integer i:hashSet1) {
//            System.out.print(i+" ");
//        }
//
//        Iterator<Integer> iterator1 = hashSet1.iterator();
//        while (iterator1.hasNext()){
//            System.out.print(iterator1.next()+" ");
//        }
//
//    }

//        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
//        for (int i = 0; i < 10; i++) {
//            arrayDeque.add(i);
//        }
//
//        for (Integer i : arrayDeque
//             ) {
//            System.out.print(i+" ");
//        }
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < 10; i++) {
//            priorityQueue.add(i);
//        }
//
//        for (Integer i : priorityQueue
//        ) {
//            System.out.print(i+" ");
//        }

        //map

        //map
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0,"satish");
        map.put(1,"abhishek");
        map.put(2,"chandu");
        map.put(3,"ravi");

        map.forEach((entry,value)-> System.out.print(entry+" "+value+" "));

        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        System.out.println(entries);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }

}

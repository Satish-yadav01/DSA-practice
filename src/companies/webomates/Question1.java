package companies.webomates;
/*
* collection have 5 items
a,b,c,d,e

insert new element middle of collection
* */


import java.util.LinkedList;

public class Question1 {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');


        //insert f element in the middle of collection
        LinkedList<Character> list1 = insertInMiddle(list);
        System.out.println(list1);
        for (int i = 0; i <= list1.size() - 1; i++) {
            System.out.print(list1.get(i)+" ");
        }

    }

    public static LinkedList<Character> insertInMiddle(LinkedList<Character> list){
        int middle = (int)list.size()/2;
        list.add(middle,'f');

        return list;
    }
}

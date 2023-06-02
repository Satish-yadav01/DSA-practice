package collections;

//Implement a method that takes two lists of integers as input and returns a new list
// that contains the union of the two lists. The output list should not contain any duplicate elements.

import java.util.*;


interface questions{
    void unionOfTwoList();
    void kthSmallestElement(List<Integer> list,int k);
    void isPalindrome(List<Integer> list);
    void removeDuplicate(List<Integer> list);
}

class Answers implements questions{

    @Override
    public void unionOfTwoList() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        list1.add(1);
        list1.add(1);
        list1.add(3);
        list1.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        combineList.addAll(list1);
        combineList.addAll(list2);
        set.addAll(combineList);

        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);
        System.out.println("set : " + set);
    }

    //Given a list of integers, implement a method to find the kth smallest element in the list. For example, given the list [5, 2, 7, 1, 8, 3] and k=3, the output should be 3.
    @Override
    public void kthSmallestElement(List list,int k) {
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(list.size()-k));
    }

    //Implement a method to check if a given list of strings is a palindrome. A palindrome list is a list that reads the same forwards and backwards.
    @Override
    public void isPalindrome(List list) {
        System.out.println(list);
        int j = list.size()-1;
        for (int i = 0; i <= list.size()-1; i++) {
            if(!(list.get(i) == list.get(j))){
                System.out.println("not palindrome");
                return;
            }
            j--;
        }
        System.out.println("palindrome");
    }

    //Implement a method to remove duplicates from a list of integers while preserving the original order of the elements. For example, given the list [1, 2, 3, 2, 4, 5, 4, 6], the output should be [1, 2, 3, 4, 5, 6].
    @Override
    public void removeDuplicate(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<>();
        for (Integer num : list) {
            set.add(num);
        }
        ArrayList<Integer> newList = new ArrayList<>(set);
        System.out.println(newList);
    }
}

public class ListExample5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Answers ans = new Answers();
//        ans.unionOfTwoList();

//        ans.kthSmallestElement(list,2);

//        ans.isPalindrome(list);

        ans.removeDuplicate(list);
    }
}

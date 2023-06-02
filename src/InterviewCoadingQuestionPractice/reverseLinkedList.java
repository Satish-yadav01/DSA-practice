package InterviewCoadingQuestionPractice;

import java.util.LinkedList;

public class reverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ll.add(i);
        }

        System.out.println(ll);
        LinkedList<Integer> integers = reverseLL(ll);
        System.out.println("reverse "+integers);
    }

    private static LinkedList<Integer> reverseLL(LinkedList<Integer> ll) {
        System.out.println("method called");
        LinkedList<Integer> reverseLL = new LinkedList<>();
        for (int i = 0; i < ll.size() ; i++) {
            System.out.println(ll.getLast());
            reverseLL.add(ll.removeLast());
        }

        return reverseLL;
    }
}

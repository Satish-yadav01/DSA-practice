package interviewBasics.collectionPractice.queue;

public class MyQueueExample {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}

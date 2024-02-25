package interviewBasics.Multithreading;

//using syncronized we make our code of execution as syncronization not asyncronous

class Counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}

public class ThreadSyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(()->{
                for (int i = 0; i < 1000; i++) {
                    c.increment();
                }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
        System.out.println("bye");
    }
}

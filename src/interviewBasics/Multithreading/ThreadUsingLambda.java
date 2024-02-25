package interviewBasics.Multithreading;

public class ThreadUsingLambda {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("thread1 "+ Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.setName("Thread1");
        t2.setName("Thread2");

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(t1.isAlive());
        System.out.println("Bye");
    }
}

package interviewBasics.Multithreading;

class Y implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Y");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Z implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Z");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadUsingInterface {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Z());
        Thread thread2 = new Thread(new Y());

        thread1.start();
        thread2.start();
    }
}

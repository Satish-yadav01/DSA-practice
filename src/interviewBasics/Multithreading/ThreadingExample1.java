package interviewBasics.Multithreading;

class A extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("class A");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class B extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("class B");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadingExample1 {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        B b = new B();

        a.start();
        b.start();
    }
}

package designpattern.coreJava.creationalPattern.singletonPattern;

class WaterContainer {
    private static int waterLevel = 100;
    private static volatile WaterContainer instance;

    public int removeWaterByUnit(int amount){
        System.out.println("removing water by current : " + Thread.currentThread().getName() + " units : " + amount);
        synchronized (this){  // to avoid race condition
            waterLevel = waterLevel-amount;
        }

        return waterLevel;
    }

    public static void setWaterLevel(int waterLevel) {
        WaterContainer.waterLevel = waterLevel;
    }

    public static int getWaterLevel() {
        return waterLevel;
    }

    private WaterContainer(){
        System.out.println("Constructor Called");
    }

    public static WaterContainer getInstance(){
        if (instance == null) {
            synchronized (WaterContainer.class) {
                if (instance == null) {
                    instance = new WaterContainer();
                }
            }
        }
        return instance;
    }
}

public class SingletonClassExample{
    public static void main(String[] args) throws InterruptedException {

        //if same hascode then it means for every time only one instance will create
//        for (int i = 0; i < 10; i++) {
//            WaterContainer instance = WaterContainer.getInstance();
//            System.out.println(instance.hashCode());
//        }


        //here to check the race condition of the waterLevel
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                new Thread(() -> {
                    WaterContainer instance = WaterContainer.getInstance();
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Instance HashCode : "
                                    + instance.hashCode()
                    );
                    System.out.println("Water level after removing 1 units: " + instance.removeWaterByUnit(1));
                },"thread-1-" + i).start();
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                new Thread(() -> {
                    WaterContainer instance = WaterContainer.getInstance();
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Instance HashCode : "
                                    + instance.hashCode()
                    );
                    System.out.println("Water level after removing 50 units: " + instance.removeWaterByUnit(1));
                },"thread-2-" + i).start();
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("water level : " + WaterContainer.getWaterLevel());
    }
}
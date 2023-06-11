package designPattern.creationalPattern.singletonPattern;

class SingletonClass {
    private static int waterLevel = 100;
    private static SingletonClass instance = null;

    public int getWaterLevel(int amount){
        return waterLevel-amount;
    }

    private SingletonClass(){

    }

    public static SingletonClass getInstance(){
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}

public class SingletonClassExample{
    public static void main(String[] args) {
        SingletonClass instance = SingletonClass.getInstance();
        int waterLevel = instance.getWaterLevel(50);
        System.out.println(waterLevel);

        SingletonClass instance1 = SingletonClass.getInstance();
        int waterLevel1 = instance1.getWaterLevel(20);
        System.out.println(waterLevel1);

//        SingletonClass sc = new SingletonClass();
    }
}
package lld.snakeandladder.data;

import java.util.Random;

/**
 * @author : Satish Yadav
 * @purpose : this should be also Singleton
 */
public class Dice {
    private int number;

    public int roll(){
        return new Random().nextInt(1,7);
    }
}

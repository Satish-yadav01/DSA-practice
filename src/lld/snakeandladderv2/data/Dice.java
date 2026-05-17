package lld.snakeandladderv2.data;

import java.util.Random;

public class Dice {
    private int number;

    public int rollDice(){
        number = new Random().nextInt(6) + 1;
        System.out.printf("\nDice rolled to %s", number);
        return number;
    }

    public int getNumber() {
        return number;
    }
}

package lld.snakeandladder;

import lld.snakeandladder.data.Dice;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Test {
    public static void main(String[] args) {
        Dice dice = new Dice();

        boolean loop = true;
        while(loop){
            int roll = dice.roll();
            if(roll == 6){
                loop = false;
            }
            System.out.println(roll);
        }
    }
}

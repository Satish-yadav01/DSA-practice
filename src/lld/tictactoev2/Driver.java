package lld.tictactoev2;

import lld.tictactoev2.data.Result;
import lld.tictactoev2.manager.TicTacToeManager;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        TicTacToeManager manager = new TicTacToeManager();
        Result result = manager.start();
        if(!result.isDraw()){
            System.out.println("winner is " + result.getWinner().getName());
        }else {
            System.out.println("Match is Draw");
        }
    }
}

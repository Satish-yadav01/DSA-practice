package lld.tictactoe;

import lld.tictactoe.data.Result;
import lld.tictactoe.manager.TicTacToeManager;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        TicTacToeManager ticTacToeManager = new TicTacToeManager();
        Result result = ticTacToeManager.start();
        if(!result.isDraw()){
            System.out.println("Winner is " + result.getWinner().getName());
        }else{
            System.out.println("Match is Draw");
        }
    }
}

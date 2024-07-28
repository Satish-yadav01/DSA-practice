package lld.tictactoe.manager;

import lld.tictactoe.data.Move;
import lld.tictactoe.data.Result;
import lld.tictactoe.model.GeneralBoard;
import lld.tictactoe.model.HumanPlayer;
import lld.tictactoe.repo.Board;
import lld.tictactoe.repo.Player;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class TicTacToeManager {
    Board board;

    public Result start(){
        System.out.println("-----------Game start-------");
        Player player1 = new HumanPlayer("Satish",'X');
        Player player2 = new HumanPlayer("Naman",'0');
        board = new GeneralBoard();
        Player currentPlayer = player1;
        while(!board.isEmpty()){
            Move move = currentPlayer.Play();
            board.applyMoveOnBoard(move,currentPlayer.getSymbol());
            if(!board.hasWinningLine(currentPlayer.getSymbol())){
                board.printBoard();
            }else{
                board.printBoard();
                return new Result(currentPlayer,false);
            }

            if(currentPlayer == player1){
                currentPlayer = player2;
            }else {
                currentPlayer = player1;
            }

        }
        return new Result(null,true);
    }
}

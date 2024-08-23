package lld.tictactoev2.manager;

import lld.tictactoev2.constant.Constants;
import lld.tictactoev2.data.Move;
import lld.tictactoev2.data.Result;
import lld.tictactoev2.model.GeneralBoard;
import lld.tictactoev2.model.HumanPlayer;
import lld.tictactoev2.service.Board;
import lld.tictactoev2.service.Player;

import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class TicTacToeManager {
    private Player player1 = new HumanPlayer();
    private Player player2 = new HumanPlayer();
    private Board board = new GeneralBoard();
    private Scanner scanner;

    public TicTacToeManager() {
        this.scanner = new Scanner(System.in);
    }

    public Result start(){
        System.out.println("Game is Starting...");
        boolean innerLoop = true;
        boolean outerLoop = true;
        initializePlayersDetails();
        Player currentPlayer = player1;

        while (outerLoop) {

            //apply Move on board
            while(innerLoop){
                Move move = currentPlayer.play();
                String appliedResponse = this.board.applyMoveOnBoard(move, currentPlayer.getSymbol());
                if(appliedResponse.equals(Constants.MOVE_SUCCESS)){
                    this.board.printBoard();
                    innerLoop = false;
                }
            }
            innerLoop = true;

            //check for draw match
            if(this.board.isDraw()){
                outerLoop = false;
            }

            //check for the winning line
            if(this.board.hasWinningLine(currentPlayer.getSymbol())){
                return new Result(false,currentPlayer);
            }

            //logic for switching player
            if(currentPlayer == player1) {
                currentPlayer = player2;
            }else {
                currentPlayer = player1;
            }
        }

        return new Result(true,null);
    }

    private void initializePlayersDetails() {
        System.out.println("Please Enter the Player1 details.");
        System.out.println("please enter name : ");
        String player1Name = this.scanner.next();
        System.out.println("Please Enter symbol which you wanted to use : ");
        char player1Symbol = this.scanner.next().charAt(0);
        player1.setId(1);
        player1.setName(player1Name);
        player1.setSymbol(player1Symbol);

        System.out.println("Please Enter the Player2 details.");
        System.out.println("please enter name : ");
        String player2Name = this.scanner.next();
        System.out.println("Please Enter symbol which you wanted to use : ");
        char player2Symbol = this.scanner.next().charAt(0);
        player2.setId(2);
        player2.setName(player2Name);
        player2.setSymbol(player2Symbol);

        System.out.println("Your Board");
        this.board.printBoard();
    }
}

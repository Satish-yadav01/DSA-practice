package lld.tictactoev2.manager;

import lld.tictactoev2.constant.Constants;
import lld.tictactoev2.data.Move;
import lld.tictactoev2.data.Result;
import lld.tictactoev2.model.GeneralBoard;
import lld.tictactoev2.model.HumanPlayer;
import lld.tictactoev2.service.Board;
import lld.tictactoev2.service.Player;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class TicTacToeManager {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private final Scanner scanner;
    private final Set<Character> Symbols;

    public TicTacToeManager() {
        Symbols = new HashSet<>();
        player1 = new HumanPlayer();
        player2 = new HumanPlayer();
        board = new GeneralBoard();
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
                    innerLoop = false;
                } else if (appliedResponse.equalsIgnoreCase("Invalid Move")) {
                    System.out.println("Invalid Move. Please try again");
                }
                this.board.printBoard();
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
        Player[] players = {player1, player2};

        for (int i = 0; i < players.length; i++) {
            int playerId = i + 1;
            System.out.println("Please Enter the Player" + playerId + " details.");

            System.out.println("please enter name : ");
            String playerName = this.scanner.next();

            System.out.println("Please Enter symbol which you wanted to use : ");
            char playerSymbol = this.scanner.next().charAt(0);

            setPlayerValues(playerId, playerName, playerSymbol, players[i]);
        }

        System.out.println("Your Board");
        this.board.printBoard();
    }

    private static void setPlayerValues(int playerId, String playerName, char playerSymbol, Player players) {
        players.setId(playerId);
        players.setName(playerName);
        players.setSymbol(playerSymbol);
    }
}

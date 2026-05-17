package lld.tictactoev3.manager;

import lld.tictactoev3.constant.Constants;
import lld.tictactoev3.data.Move;
import lld.tictactoev3.model.Player;
import lld.tictactoev3.service.BoardService;
import lld.tictactoev3.service.PlayerService;
import lld.tictactoev3.service.impl.PlayerServiceImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeManager {
    private final Queue<Player> players;
    private final PlayerService playerService;
    private final BoardService boardService;
    private final int playerSize;
    private final Scanner scanner;


    public TicTacToeManager(BoardService boardService, int playerSize) {
        this.players = new LinkedList<>();
        this.playerSize = playerSize;
        this.scanner = new Scanner(System.in);

        initializePlayers();
        this.playerService = new PlayerServiceImpl(players);
        this.boardService = boardService;

    }

    public void start(){
//        Player currentPlayer = checkToss();
        System.out.println("Game is starting to Play!!!");
        boardService.printBoard();

        while(true){
            Player currentPlayer = playerService.getCurrentPlayer();
            boolean innerLoop = true;

            while (innerLoop) {
                System.out.println("\nCurrent Player : " + currentPlayer);
                Move move = playerService.play();
                Constants status = boardService.applyMoveOnBoard(move, currentPlayer.getSymbol());
                innerLoop = handleMoveOnBoard(status, innerLoop);
            }

            boolean isWinner = boardService.hasWinningLine(currentPlayer.getSymbol());
            if (isWinner) {
                System.out.printf("Winner is %s with symbol %s", currentPlayer.getName(), currentPlayer.getSymbol());
                boardService.printBoard();
                return;
            }

            boardService.printBoard();
            if (boardService.isDraw()) {
                System.out.println("Match is Draw");
                break;
            }
            playerService.switchPlayer();

        }

    }

    private boolean handleMoveOnBoard(Constants status, boolean innerLoop) {
        switch (status) {
            case INVALID_MOVE -> {
                System.out.println("INVALID MOVE");
                int gridSize = boardService.getGridSize();
                System.out.printf("Grid dimension is %sx%s, Please enter coordinate in between Grid", gridSize, gridSize);
            }
            case SUCCESS_MESSAGE -> {
                System.out.println("SUCCESS MOVE");
                innerLoop = false;
            }
            case FAILED_MESSAGE -> {
                System.out.println("FAILED MOVE");
                System.out.println("Please try again later");
            }
            default -> System.out.println("UNKNOWN type");
        }
        return innerLoop;
    }

    private Player checkToss() {
        Random random = new Random();
        int value = random.nextInt(2) + 1;
        Player player = playerService.getPlayerById(value)
                .orElseThrow(()-> new RuntimeException("Player not found with id : %s".formatted(value)));
        System.out.printf("Player %s (%s) with symbol (%s) has won the toss : ",value,player.getName(),player.getSymbol());
        return player;
    }

    private void initializePlayers() {
        System.out.println("Initialize the Players to Play TicTacToe");

        for(int i = 0; i < playerSize; i++){
            int playerId = i+1;
            System.out.printf("Enter Player name for Player %s : ",playerId);
            String playerName = scanner.next();
            System.out.print("Enter Player symbol : ");
            char playerSymbol = scanner.next().charAt(0);
            Player player = new Player(playerId, playerName, playerSymbol);
            players.offer(player);
        }
    }

}

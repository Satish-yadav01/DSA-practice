package lld.snakeandladderv2.service;

import lld.snakeandladderv2.model.Board;
import lld.snakeandladderv2.model.Player;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class GameService {
    private final Board board;
    private final Queue<Player> players;
    private final Scanner scanner;

    public GameService(Board board, Queue<Player> players) {
        this.board = board;
        this.players = players;
        this.scanner =  new Scanner(System.in);
    }


    public GameService(int boardSize) {
        scanner = new Scanner(System.in);
        this.board = new Board(boardSize);
        this.players = new ArrayDeque<>();

        initializePlayers();
    }

    // Replace existing start() method in GameService.java with:
    public void start() {
        System.out.println("Game is About to Start!!!");

        while (!players.isEmpty()) {
            Player currentPlayer = players.poll();
            if (currentPlayer == null) break;

            int diceNumber = currentPlayer.play();
            int currentPosition = board.updatePosition(currentPlayer, diceNumber);

            System.out.printf("\nnow current position of player:%s is %s", currentPlayer.getName(), currentPosition);
            currentPlayer.setPosition(currentPosition);

            int maxPos = board.getBoardSize() * board.getBoardSize();
            if (currentPlayer.getPosition() == maxPos) {
                System.out.printf("\n\n!!!!! Player : %s has passed the Snake and Ladder game !!!!\n", currentPlayer.getName());
            } else {
                players.offer(currentPlayer);
            }
        }
    }

    private void initializePlayers() {
        System.out.println("Enter the Number of Players wants to Play : ");
        int noOfPlayers = scanner.nextInt();

        for (int i = 0; i < noOfPlayers; i++) {
            int playerId = i+1;
            System.out.printf("Enter the Name for Player %s : ",playerId);
            String playerName = scanner.next();
            Player player = new Player(playerId, playerName);
            players.add(player);
        }
    }

}

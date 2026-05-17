package lld.snakeandladderv2.model;

import lld.snakeandladderv2.data.Ladder;
import lld.snakeandladderv2.data.Snake;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final int boardSize;
    private final int[][]board;
    private final Scanner scanner;

    public Board(List<Snake> snakes, List<Ladder> ladders, int boardSize) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
        this.scanner = new Scanner(System.in);;
    }

    public Board(int boardSize) {
        this.snakes = new LinkedList<>();
        this.ladders = new LinkedList<>();
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
        this.scanner = new Scanner(System.in);

        initializeBoard();
    }

    private void initializeBoard() {
        int num=0;
        for(int i=0; i<boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                num++;
                board[i][j] = num;
            }
        }

        printBoard();

        System.out.print("\nEnter the number of Snake you want : ");
        int noOfSnakes = scanner.nextInt();
        System.out.print("Enter the Number of Ladder you want : ");
        int noOfLadder = scanner.nextInt();

        for(int i=0; i<noOfSnakes; i++){
            int snakeNumber = i+1;
            System.out.printf("Provide the head and tail for snake %s : ",snakeNumber);
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            Snake snake = new Snake(head, tail);
            snakes.add(snake);
        }

        for (int i = 0; i < noOfLadder; i++) {
            int ladderNumber = i+1;
            System.out.printf("Provide the Start and End of Ladder %s : ",ladderNumber);
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Ladder ladder = new Ladder(start, end);
            ladders.add(ladder);
        }
    }

    public void printBoard(){
        System.out.println("Your Board\n");
        for(int i = 0; i<boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                System.out.print("|  " + board[i][j]+" ");
            }
            System.out.println();
        }
    }

    // Replace existing updatePosition(...) in Board.java with:
    public int updatePosition(Player player, int diceNumber) {
        int max = boardSize * boardSize;
        int tentative = player.getPosition() + diceNumber;
        if (tentative > max) {
            // ignore move if overshoots final square
            return player.getPosition();
        }

        // check for snake head
        for (Snake snake : snakes) {
            if (snake.head() == tentative) {
                return snake.tail();
            }
        }

        // check for ladder start
        for (Ladder ladder : ladders) {
            if (ladder.start() == tentative) {
                return ladder.end();
            }
        }

        return tentative;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int[][] getBoard() {
        return board;
    }
}

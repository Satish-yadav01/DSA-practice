package lld.snakeandladder.service.impl;

import lld.snakeandladder.constant.Constant;
import lld.snakeandladder.data.Dice;
import lld.snakeandladder.model.Board;
import lld.snakeandladder.model.Ladder;
import lld.snakeandladder.model.Player;
import lld.snakeandladder.model.Snake;
import lld.snakeandladder.service.GameService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class GameServiceImpl implements GameService {

    private Board board;
    private Queue<Player> players;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public GameServiceImpl() {
        this.snakes = new LinkedList<>();
        this.ladders = new LinkedList<>();
        this.players = new LinkedList<>();

        //initialize Snakes, ladders and players
        init();
    }

    public void startGame() {
        System.out.println("Game is starting...");

        //creating board
        board = this.createBoard();
        System.out.println(board.toString());
        Dice dice = new Dice();
        boolean loop = true;

        while (loop){
            Player currentPlayer = players.poll();
            int updatedPosition = this.play(currentPlayer, dice);
            if(updatedPosition <= 100){
                currentPlayer.setPosition(updatedPosition);
            }else {
                System.out.println(Constant.TRY_LATER);
            }

            System.out.println(currentPlayer.getName() + " updated position : " + currentPlayer.getPosition());

            if(currentPlayer.getPosition() == 100) {
                System.out.println(currentPlayer.getName() + " win");
                players.remove(currentPlayer);
                currentPlayer = players.poll();
            }

            //logic switching players
            players.offer(currentPlayer);

            if(players.size() < 2){
                System.out.println(Constant.NO_PLAYER);
                loop = false;
            }
        }

    }

    @Override
    public Queue<Player> getPlayers() {
        return players;
    }

    @Override
    public List<Snake> getSnakes() {
        return this.board.getSnakes();
    }

    @Override
    public List<Ladder> getLadders() {
        return this.board.getLadders();
    }

    @Override
    public Board createBoard() {
        return Board.getInstance(snakes, ladders);
    }

    @Override
    public int play(Player currentPlayer, Dice dice) {
        System.out.println(currentPlayer.getName() + " playing...");
        int roll = dice.roll();
        System.out.println(currentPlayer.getName() + " roll: " + roll);
        return updatePosition(currentPlayer, roll);
    }

    private int updatePosition(Player currentPlayer, int diceNumber) {
        int currentPlayerPosition = currentPlayer.getPosition();
        int updatedPosition = currentPlayerPosition + diceNumber;

        //check is there any snake head or ladder start
        for (int i = 0; i < snakes.size(); i++) {
            if(snakes.get(i).getHead() == updatedPosition) {
                updatedPosition = snakes.get(i).getTail();
                System.out.println("Found snake : updating position to " + updatedPosition);
                return updatedPosition;
            }
        }

        for (int i = 0; i < ladders.size(); i++) {
            if(ladders.get(i).getStart() == updatedPosition) {
                updatedPosition = ladders.get(i).getEnd();
                System.out.println("Found Ladder : updating position to " + updatedPosition);
                return updatedPosition;
            }
        }
        return updatedPosition;
    }


    private void init() {
        //create Snakes
        System.out.println("Enter the no of Snakes");
        Scanner sc = new Scanner(System.in);
        int noOfSnakes = sc.nextInt();
        for (int i = 0; i <= noOfSnakes-1; i++) {
            System.out.println("Please Enter "+(i+1) +" snake Detail ==>");
            System.out.println("Enter head: ");
            int head = sc.nextInt();
            System.out.println("Enter tail: ");
            int tail = sc.nextInt();
            snakes.add(new Snake(head,tail));
        }

        //create ladders
        System.out.println("Enter the no of Ladder");
        int noOfLadder = sc.nextInt();
        for (int i = 0; i <= noOfLadder-1; i++) {
            System.out.println("Please Enter "+(i+1) +" ladder Detail ==>");
            System.out.println("Enter start: ");
            int start = sc.nextInt();
            System.out.println("Enter end: ");
            int end = sc.nextInt();
            ladders.add(new Ladder(start,end));
        }

        //create players
        System.out.println("Enter the no of Player");
        int noOfPlayers = sc.nextInt();
        for (int i = 0; i <= noOfPlayers-1; i++) {
            System.out.println("Please Enter "+(i+1) +" Player Detail ==>");
            System.out.println("Enter Player name: ");
            String name = sc.next();
            players.add(new Player(name));
        }

    }
}

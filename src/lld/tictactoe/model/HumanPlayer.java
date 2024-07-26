package lld.tictactoe.model;

import tictactoe.data.Move;
import tictactoe.repo.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class HumanPlayer implements Player {
    private String playerName;
    private char symbol;

    public HumanPlayer(String playerName, char symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    @Override
    public Move Play() {
        System.out.println(playerName + " is playing with symbol "+symbol);
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new Move(x,y);
    }

    private static int getRandomNumber() {
        return new Random().nextInt(3) + 1;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String getName() {
        return playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

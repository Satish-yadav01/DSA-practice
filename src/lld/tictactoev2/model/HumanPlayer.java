package lld.tictactoev2.model;

import lld.tictactoev2.data.Move;
import lld.tictactoev2.service.Player;

import java.util.Scanner;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class HumanPlayer implements Player {
    private int id;
    private String name;
    private char symbol;
    private Scanner scanner;

    public HumanPlayer() {
        this.scanner = new Scanner(System.in);
    }

    public HumanPlayer(int id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move play() {
        System.out.println("""
                Player %s is Playing with symbol %s
                """.formatted(this.name,this.symbol));

        System.out.println("Please enter x-y place : ");
        System.out.println("x-position : ");
        int x = scanner.nextInt();

        System.out.println("y-position : ");
        int y = scanner.nextInt();

        System.out.printf("x: %s & y: %s\n",x,y);
        return new Move(x,y);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

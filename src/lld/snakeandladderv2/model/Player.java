package lld.snakeandladderv2.model;

import lld.snakeandladderv2.data.Dice;

public class Player {
    private final int id;
    private final String name;
    private final Dice dice;
    private int position;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.dice = new Dice();
        this.position = 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int play(){
        System.out.printf("\nPlayer %s is playing",name);
        return dice.rollDice();
    }
}

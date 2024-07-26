package lld.tictactoe.model;

import tictactoe.data.Move;
import tictactoe.repo.Player;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ComputerPlayer implements Player {
    private String playerName="COMPUTER";

    @Override
    public Move Play() {
        return null;
    }

    @Override
    public char getSymbol() {
        return 0;
    }

    @Override
    public String getName() {
        return playerName;
    }
}

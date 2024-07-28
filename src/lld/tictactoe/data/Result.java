package lld.tictactoe.data;

import lld.tictactoe.repo.Player;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Result {
    private Player winner;
    boolean isDraw;

    public Result(Player winner, boolean isDraw) {
        this.winner = winner;
        this.isDraw = isDraw;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean isDraw() {
        return isDraw;
    }
}

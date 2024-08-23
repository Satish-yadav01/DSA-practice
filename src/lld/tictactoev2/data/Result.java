package lld.tictactoev2.data;

import lld.tictactoev2.service.Player;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Result {
    private final boolean isDraw;
    private final Player winner;

    public Result(boolean isDraw, Player winner) {
        this.isDraw = isDraw;
        this.winner = winner;
    }
    public boolean isDraw() {
        return isDraw;
    }

    public Player getWinner() {
        return winner;
    }
}

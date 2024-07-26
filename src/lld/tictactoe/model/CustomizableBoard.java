package lld.tictactoe.model;

import tictactoe.data.Move;
import tictactoe.repo.Board;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class CustomizableBoard implements Board {
    @Override
    public void printBoard() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String applyMoveOnBoard(Move move, char symbol) {
        return "";
    }

    @Override
    public int getDimension() {
        return 0;
    }

    @Override
    public boolean hasWinningLine(char symbol) {
        return false;
    }
}

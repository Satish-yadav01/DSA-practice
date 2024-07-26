package lld.tictactoe.repo;

import tictactoe.data.Move;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface Board {
    void printBoard();
    boolean isEmpty();
    String applyMoveOnBoard(Move move, char symbol);
    int getDimension();
    boolean hasWinningLine(char symbol);
}

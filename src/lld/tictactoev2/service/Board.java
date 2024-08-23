package lld.tictactoev2.service;

import lld.tictactoev2.data.Move;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface Board {

    int getGridSize();

    boolean hasWinningLine(char symbol);

    String applyMoveOnBoard(Move move,char symbol);

    void printBoard();

    boolean isDraw();

}

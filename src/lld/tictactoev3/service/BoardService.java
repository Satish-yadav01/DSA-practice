package lld.tictactoev3.service;

import lld.tictactoev3.constant.Constants;
import lld.tictactoev3.data.Move;

public interface BoardService {
    int getGridSize();
    Constants applyMoveOnBoard(Move move, char symbol);
    void printBoard();
    boolean hasWinningLine(char symbol);
    boolean isDraw();
}

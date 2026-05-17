package lld.tictactoev3.model;

import java.util.Arrays;

public class Board {
    private final int boardGrid;
    private final char[][] board;

    public Board(int boardGrid) {
        this.boardGrid = boardGrid;
        this.board = new char[boardGrid][boardGrid];

        for (int i = 0; i < boardGrid; i++) {
            for (int j = 0; j < boardGrid; j++) {
                board[i][j] = '.';
            }
        }
    }

    public int getBoardGrid() {
        return boardGrid;
    }

    public char[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardGrid=" + boardGrid +
                ", board=" + Arrays.toString(board) +
                '}';
    }
}

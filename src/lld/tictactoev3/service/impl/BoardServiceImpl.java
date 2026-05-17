package lld.tictactoev3.service.impl;

import lld.tictactoev3.constant.Constants;
import lld.tictactoev3.data.Move;
import lld.tictactoev3.model.Board;
import lld.tictactoev3.service.BoardService;

public class BoardServiceImpl implements BoardService {
    private final Board board;
    private final int BOARD_SIZE;

    public BoardServiceImpl(Board board) {
        this.board = board;
        this.BOARD_SIZE = board.getBoardGrid();
    }

    @Override
    public int getGridSize() {
        return BOARD_SIZE;
    }

    @Override
    public Constants applyMoveOnBoard(Move move, char symbol) {
        try {
            if (move.x() < 0 || move.x() >= BOARD_SIZE ||
                    move.y() < 0 || move.y() >= BOARD_SIZE) {
                return Constants.INVALID_MOVE;
            }

            char[][] finalBoard = board.getBoard();
            if (finalBoard[move.x()][move.y()] != '.') {
                System.out.println("Position Already covered,Please try again");
                return Constants.FAILED_MESSAGE;
            }

            finalBoard[move.x()][move.y()] = symbol;
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return Constants.FAILED_MESSAGE;
        }
        return Constants.SUCCESS_MESSAGE;
    }

    @Override
    public void printBoard() {
        System.out.println();
        for(int i=0; i<BOARD_SIZE; i++){
            for (int j=0; j<BOARD_SIZE; j++){
                System.out.print(" | " + board.getBoard()[i][j]);
            }
            System.out.print(" | \n");
        }
    }

    @Override
    public boolean hasWinningLine(char symbol) {
        return isHorizontal(symbol) || isVertical(symbol) || isDiagonal(symbol);
    }

    private boolean isDiagonal(char symbol) {
        char[][] finalBoard = board.getBoard();

        // Check main diagonal (top-left to bottom-right)
        boolean mainDiagonal = true;
        for (int i = 0; i <finalBoard.length; i++) {
            if (finalBoard[i][i] != symbol) {
                mainDiagonal = false;
                break;
            }
        }
        if (mainDiagonal) return true;

        // Check anti-diagonal (top-right to bottom-left)
        boolean antiDiagonal = true;
        for (int i = 0; i <finalBoard.length; i++) {
            if (finalBoard[i][finalBoard.length - 1 - i] != symbol) {
                antiDiagonal = false;
                break;
            }
        }
        return antiDiagonal;
    }

    private boolean isVertical(char symbol) {
        char[][] finalBoard = board.getBoard();

        for (int col = 0; col < finalBoard.length; col++) {
            boolean colMatch = true;

            for (int row = 0; row < finalBoard.length; row++) {
                if (finalBoard[row][col] != symbol) {
                    colMatch = false;
                    break;
                }
            }

            if (colMatch) return true;
        }
        return false;
    }

    private boolean isHorizontal(char symbol) {
        char[][] finalBoard = board.getBoard();
        for (char[] row : finalBoard){
            boolean rowMatch = true;
            for(int i=0; i < row.length; i++){
                if(row[i] != symbol){
                    rowMatch = false;
                    break;
                }
            }
            if(rowMatch) return true;
        }

        return false;
    }

    @Override
    public boolean isDraw() {
        for(int i=0; i<BOARD_SIZE; i++){
            for (int j=0; j<BOARD_SIZE; j++){
                if(board.getBoard()[i][j] != '.') return false;
            }
        }
        return true;
    }
}

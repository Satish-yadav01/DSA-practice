package lld.tictactoev2.model;

import lld.tictactoev2.constant.Constants;
import lld.tictactoev2.data.Move;
import lld.tictactoev2.service.Board;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class GeneralBoard implements Board {
    private final int boardGrid;
    private final char[][] board;

    public GeneralBoard() {
        this.boardGrid = Constants.GENERAL_BOARD_SIZE;
        this.board = new char[boardGrid][boardGrid];
        init();
    }

    @Override
    public String applyMoveOnBoard(Move move, char symbol) {

//        if (move.getX() < 0 || move.getY() < 0 || move.getX() >= boardGrid || move.getY() >= boardGrid) {
//            return "Invalid Move";
//        }

        try {
            if (this.board[move.getX()][move.getY()] != '.') {
                System.out.println("Position Already covered,Please try again");
                return Constants.MOVE_FAILURE;
            }
            this.board[move.getX()][move.getY()] = symbol;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Constants.MOVE_SUCCESS;
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(this.board[i][j] + "  |");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isDraw() {
        boolean isDraw = false;
        for (int i = 0; i <= this.board.length - 1; i++) {
            for (int j = 0; j <= this.board.length - 1; j++) {
                if (this.board[i][j] != '.') {
                    isDraw = true;
                    break;
                }
            }
        }
        return isDraw;
    }

    @Override
    public int getGridSize() {
        return this.boardGrid;
    }

    @Override
    public boolean hasWinningLine(char symbol) {
        return isVerticalLine(symbol) || isHorizontalLine(symbol) || isDiagonalLine(symbol);
    }

    private void init() {
        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board.length - 1; j++) {
                this.board[i][j] = '.';
            }
        }
//        IntStream.range(0, board.length)
//                .forEach(y -> this.board[y][y] = '.');

    }

    private boolean isDiagonalLine(char symbol) {
        for (int i = 0; i <= this.board.length - 1; i++) {
            for (int j = 0; j <= this.board.length - 1; j++) {
                if (this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol) {
                    return true;
                } else if (this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isHorizontalLine(char symbol) {
        for (int i = 0; i <= this.board.length - 1; i++) {
            for (int j = 0; j <= this.board.length - 1; j++) {
                if (this.board[i][0] == symbol && this.board[i][1] == symbol && this.board[i][2] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isVerticalLine(char symbol) {
        for (int i = 0; i <= this.board.length - 1; i++) {
            for (int j = 0; j <= this.board.length - 1; j++) {
                if (this.board[0][i] == symbol && this.board[1][i] == symbol && this.board[2][i] == symbol) {
                    return true;
                }
            }
        }
        return false;
    }

}

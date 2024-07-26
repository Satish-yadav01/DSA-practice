package lld.tictactoe.model;

import tictactoe.data.Move;
import tictactoe.repo.Board;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class GeneralBoard implements Board {
    private char[][] board;

    public GeneralBoard() {
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = '.';
            }
        }
    }

    @Override
    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+"| ");
            }
            System.out.println("");
        }
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') return false;
            }
        }
        return true;
    }

    @Override
    public String applyMoveOnBoard(Move move, char symbol) {
        if(this.board[move.getX()][move.getY()]=='.'){
            this.board[move.getX()][move.getY()] = symbol;
            return "move applied";
        }
        return "Please use empty field only";
    }

    @Override
    public int getDimension() {
        return board.length;
    }

    @Override
    public boolean hasWinningLine(char symbol) {
        return isVerticalLine(symbol) || isHorizontalLine(symbol) || isDiagonalLine(symbol);
    }

    private boolean isVerticalLine(char symbol) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[0][i]==symbol && board[1][i]==symbol && board[2][i]==symbol){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isHorizontalLine(char symbol) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][0]==symbol && board[i][1]==symbol && board[i][2]==symbol){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isDiagonalLine(char symbol) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol){
                    return true;
                }
            }
        }
        return false;
    }

}

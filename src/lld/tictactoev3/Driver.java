package lld.tictactoev3;

import lld.tictactoev3.manager.TicTacToeManager;
import lld.tictactoev3.model.Board;
import lld.tictactoev3.service.impl.BoardServiceImpl;

public class Driver {
    public static void main(String[] args) {
        BoardServiceImpl boardService = new BoardServiceImpl(new Board(4));
        TicTacToeManager ticTacToeManager = new TicTacToeManager(boardService,3);
        ticTacToeManager.start();
    }
}

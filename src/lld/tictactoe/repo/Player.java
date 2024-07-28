package lld.tictactoe.repo;

import lld.tictactoe.data.Move;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface Player {
    Move Play();
    char getSymbol();
    String getName();
}

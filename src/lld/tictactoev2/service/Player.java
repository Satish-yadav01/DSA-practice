package lld.tictactoev2.service;

import lld.tictactoev2.data.Move;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface Player {

    Move play();

    String getName();

    int getId();

    char getSymbol();

    void setId(int id);

    void setSymbol(char symbol);

    void setName(String name);
}

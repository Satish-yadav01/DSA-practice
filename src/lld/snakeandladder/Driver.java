package lld.snakeandladder;

import lld.snakeandladder.service.impl.GameServiceImpl;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Driver {
    public static void main(String[] args) {
        GameServiceImpl gameService = new GameServiceImpl();
        gameService.startGame();
    }
}

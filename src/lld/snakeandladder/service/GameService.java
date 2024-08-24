package lld.snakeandladder.service;

import lld.snakeandladder.data.Dice;
import lld.snakeandladder.model.Board;
import lld.snakeandladder.model.Ladder;
import lld.snakeandladder.model.Player;
import lld.snakeandladder.model.Snake;

import java.util.List;
import java.util.Queue;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public interface GameService {

    Queue<Player> getPlayers();

    List<Snake> getSnakes();

    List<Ladder> getLadders();

    Board createBoard();

    int play(Player currentPlayer, Dice dice);
}

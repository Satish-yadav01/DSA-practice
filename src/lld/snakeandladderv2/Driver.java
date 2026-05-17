package lld.snakeandladderv2;

import lld.snakeandladderv2.data.Ladder;
import lld.snakeandladderv2.data.Snake;
import lld.snakeandladderv2.model.Board;
import lld.snakeandladderv2.model.Player;
import lld.snakeandladderv2.service.GameService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Driver {
    public static void main(String[] args) {
//        GameService gameService = new GameService(10);

        List<Snake> snakes = List.of(new Snake(95, 5), new Snake(60, 30));
        List<Ladder> ladders = List.of(new Ladder(4, 40), new Ladder(10, 98), new Ladder(20, 80));
        Queue<Player> players = new LinkedList<>(
                List.of(
                        new Player(1, "Satish"),
                        new Player(2, "Abhishek")
                )
        );
        GameService gameService = new GameService(new Board(snakes, ladders, 10), players);
        gameService.start();
    }
}

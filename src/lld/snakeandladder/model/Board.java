package lld.snakeandladder.model;

import lld.snakeandladder.constant.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author : Satish Yadav
 * @purpose : Board should be only one so making this Singleton class
 */
public class Board {
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final int size;
    private static Board instance;

    private Board(List<Snake> snakes, List<Ladder> ladders) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.size = Constant.BOARD_SIZE;
    }

    public static Board getInstance(List<Snake> snakes, List<Ladder> ladders) {
        if (instance == null) {
            instance = new Board(snakes, ladders);
        }
        return instance;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getBoardSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "snakes=" + snakes +
                ", ladders=" + ladders +
                ", size=" + size +
                '}';
    }
}

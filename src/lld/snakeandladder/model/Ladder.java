package lld.snakeandladder.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public record Ladder(int start, int end) {

    @Override
    public String toString() {
        return "Ladder{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

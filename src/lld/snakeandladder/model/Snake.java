package lld.snakeandladder.model;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public record Snake(int head, int tail) {

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}

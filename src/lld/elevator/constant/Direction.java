package lld.elevator.constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public enum Direction {
    UP("UP"),
    DOWN("DOWN"),
    IDLE("IDLE");

    private String val;
    Direction(String val) {
        this.val = val;
    }
    public String getVal() {
        return val;
    }
}

package lld.tictactoev3.constant;

public enum Constants {
    GENERAL_BOARD_SIZE("3"),
    SUCCESS_MESSAGE("SUCCESS"),
    FAILED_MESSAGE("FAILED"),
    INVALID_MOVE("INVALID MOVE");

    private final String name;

    Constants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

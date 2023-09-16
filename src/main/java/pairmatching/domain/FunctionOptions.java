package pairmatching.domain;

public enum FunctionOptions {
    PAIR_MATCHING("1"),
    READ_PAIR("2"),
    INIT_PAIR("3"),
    QUIT_PROGRAM("Q");

    private final String value;

    FunctionOptions(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}

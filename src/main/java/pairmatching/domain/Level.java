package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String label;

    Level(String name) {
        this.label = name;
    }

    public static Level getValueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(level -> level.label.equals(label))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("[ERROR] 해당 입력값과 일치하는 레벨이 없습니다."));
    }
}

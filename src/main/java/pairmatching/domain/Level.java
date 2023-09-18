package pairmatching.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    private static final Map<String, Level> LEVEL_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(level -> level.name, level -> level));

    public static Level getValueOf(String input) {
        return LEVEL_MAP.get(input);
    }
}

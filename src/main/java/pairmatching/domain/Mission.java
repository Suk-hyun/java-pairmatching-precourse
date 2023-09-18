package pairmatching.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Mission {
    RACING_GAME(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),
    SHOPPING_BAG(Level.LEVEL2, "장바구니"),
    PURCHASE(Level.LEVEL2, "결제"),
    SUBWAY_MAP(Level.LEVEL2, "지하철노선도"),
    PERFORMANCE_ENHANCEMENT(Level.LEVEL4, "성능개선"),
    DEPLOYMENT(Level.LEVEL4, "배포");


    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    private static final Map<String, Mission> MISSION_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(mission -> mission.name, mission -> mission));

    public static Mission getValueOf(String input) {
        return MISSION_MAP.get(input);
    }
}

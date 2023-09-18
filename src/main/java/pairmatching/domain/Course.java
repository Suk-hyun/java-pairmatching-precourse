package pairmatching.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    private static final Map<String, Course> COURSE_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(course -> course.name, course -> course));

    public static Course getValueOf(String input) {
        return COURSE_MAP.get(input);
    }
}

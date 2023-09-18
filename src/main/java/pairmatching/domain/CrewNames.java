package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewNames {
    private static final Map<Course, List<String>> crews = new HashMap<>();

    private static final CrewNames CREW_NAMES = new CrewNames();

    public static CrewNames of(List<String> backend, List<String> frontend) {
        crews.put(Course.BACKEND, backend);
        crews.put(Course.FRONTEND, frontend);
        return CREW_NAMES;
    }
    private CrewNames () {}

    public static CrewNames getInstance() {
        return CREW_NAMES;
    }

    public List<String> getNamesOf(Course course) {
        return crews.get(course);
    }
}

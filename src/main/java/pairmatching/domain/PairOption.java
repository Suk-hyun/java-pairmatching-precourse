package pairmatching.domain;

import java.util.Objects;

public class PairOption {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairOption(String input) {
        String[] split = input.split(",");

        String courseValue = split[0].trim();
        String levelValue = split[1].trim();
        String missionValue = split[2].trim();

        this.course = Course.getValueOf(courseValue);
        this.level = Level.getValueOf(levelValue);
        this.mission = Mission.getValueOf(missionValue);
    }

    public Course getCourse() {
        return this.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairOption that = (PairOption) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}

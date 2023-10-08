package pairmatching.domain;

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
        this.level = Level.getValueOfLabel(levelValue);
        this.mission = Mission.getValueByName(missionValue);
    }

    public Course getCourse() {
        return this.course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}

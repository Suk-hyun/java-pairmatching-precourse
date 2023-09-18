package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Crews {
    CrewNames crewNames = CrewNames.getInstance();
    private final List<Crew> crews;

    public Crews (Course course) {
        List<String> names = crewNames.getNamesOf(course);
        crews = new ArrayList<>();
        for (String name : names) {
            crews.add(new Crew(course, name));
        }
    }

    public List<Crew> getShuffledCrews() {
        return Randoms.shuffle(crews);
    }
}

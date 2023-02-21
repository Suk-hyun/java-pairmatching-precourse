package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

public class CrewNameRepository {

    private List<String> backEndCrewNameList = new ArrayList<>();
    private List<String> frontEndCrewNameList = new ArrayList<>();

    public void saveBackEndCrew(String crewName) {
        backEndCrewNameList.add(crewName);
    }

    public void saveFrontEndCrew(String crewName) {
        frontEndCrewNameList.add(crewName);
    }

}

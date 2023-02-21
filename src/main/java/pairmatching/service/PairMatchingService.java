package pairmatching.service;

import pairmatching.repository.CrewNameRepository;

public class PairMatchingService {
    CrewNameRepository repository = new CrewNameRepository();

    public void saveBackEndCrew(String crewName) {
        repository.saveBackEndCrew(crewName);
    }

    public void saveFrontEndCrew(String crewName) {
        repository.saveFrontEndCrew(crewName);
    }

}

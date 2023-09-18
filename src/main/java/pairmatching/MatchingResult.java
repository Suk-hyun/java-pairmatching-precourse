package pairmatching;

import pairmatching.domain.PairOption;
import pairmatching.domain.Pairs;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {

    private static final Map<PairOption, Pairs> store = new HashMap<>();

    private static final MatchingResult INSTANCE = new MatchingResult();

    public static MatchingResult getInstance() {
        return INSTANCE;
    }

    private MatchingResult() {}

    public void save(PairOption pairOption, Pairs pairs) {
        store.put(pairOption, pairs);
    }

    public boolean isPairOptionExist(PairOption pairOption) {
        return store.get(pairOption) != null;
    }

    public void deleteByPariOption(PairOption pairOption) {
        store.remove(pairOption);
    }
    public void clearStore() {
        store.clear();
    }

}

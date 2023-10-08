package pairmatching;

import pairmatching.domain.*;

import java.util.*;
import java.util.stream.Collectors;

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

    public Pairs findByPairOption(PairOption pairOption) {
        return store.get(pairOption);
    }

    public boolean hasPreviousMatching(PairOption pairOption) {
        return store.containsKey(pairOption);
    }

    public void deleteByPariOption(PairOption pairOption) {
        store.remove(pairOption);
    }
    public void clearStore() {
        store.clear();
    }

    public boolean hasDuplicatePairsInSameLevel(PairOption pairOption, Pairs pairs) {
        Set<Pair> pairsToCompare = new HashSet<>(getPairsToCompare(pairOption));
        HashSet<Pair> pairResult = new HashSet<>(pairs.getPairs());

        pairsToCompare.retainAll(pairResult);
        return pairsToCompare.size() != 0;
    }

    private List<Pair> getPairsToCompare(PairOption pairOption) {
        Level level = pairOption.getLevel();
        List<PairOption> optionsToCompare = getOptionsFromSameLevel(level);
        return getPairsInSameLevel(optionsToCompare);
    }

    private List<Pair> getPairsInSameLevel(List<PairOption> optionsToCompare) {
        return optionsToCompare.stream()
                .map(option -> store.get(option).getPairs())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<PairOption> getOptionsFromSameLevel(Level level) {
        return  store.keySet().stream()
                .filter(pairOption -> pairOption.getLevel() == level)
                .collect(Collectors.toList());
    }
}

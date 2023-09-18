package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {

    private final List<Pair> pairs = new ArrayList<>();

    public void add(Pair pair) {
        pairs.add(pair);
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}

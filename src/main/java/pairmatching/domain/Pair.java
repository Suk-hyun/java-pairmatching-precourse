package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private final List<Crew> pair = new ArrayList<>();

    public void add(Crew crew) {
        pair.add(crew);
    }

    public boolean isTwo() {
        return pair.size() == 2;
    }

    public boolean isThree() {
        return pair.size() == 3;
    }

    @Override
    public String toString() {
        if (pair.size() == 2) {
            return String.format("%s : %s", pair.get(0), pair.get(1));
        }
        if (pair.size() == 3) {
            return String.format("%s : %s : %s", pair.get(0), pair.get(1), pair.get(2));
        }
        return null;
    }
}
package pairmatching.view;

import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

import java.util.List;

public class OutputView {

    enum ConsoleMessage {
        PAIR_MATCHING_RESULT("페어 매칭 결과입니다.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printMatchingResult(Pairs pairs) {
        System.out.println(ConsoleMessage.PAIR_MATCHING_RESULT.message);
        List<Pair> pairsList = pairs.getPairs();
        for (Pair pair : pairsList) {
            System.out.println(pair);
        }
        System.out.println();
    }
}

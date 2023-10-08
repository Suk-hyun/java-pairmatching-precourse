package pairmatching.controller;

import pairmatching.MatchingResult;
import pairmatching.ProgramStatus;
import pairmatching.domain.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.*;

public class PairMatchingController implements Controller {

    private final InputView inputView;
    private final OutputView outputView;

    private final MatchingResult matchingResult = MatchingResult.getInstance();

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        String pairOptionInput = inputView.readPairOption();

        PairOption pairOption = new PairOption(pairOptionInput);

        if (matchingResult.hasPreviousMatching(pairOption)) {
            String rematchChoice = inputView.readRematchChoice();

            if (rematchChoice.equals("네")) {
                rematch(pairOption);
            }
            if (rematchChoice.equals("아니오")) {
                MainController.status = ProgramStatus.SELECT_FUNCTION;
            }
        }

        if (!matchingResult.hasPreviousMatching(pairOption)) {
            newPairMatching(pairOption);
        }
    }

    private void rematch(PairOption pairOption) {
        matchingResult.deleteByPariOption(pairOption);
        newPairMatching(pairOption);
    }

    private void newPairMatching(PairOption pairOption) {
        Pairs pairs;
        do {
            pairs = matchPairs(pairOption.getCourse());

            matchingResult.save(pairOption, pairs);

            outputView.printMatchingResult(pairs);

            MainController.status = ProgramStatus.SELECT_FUNCTION;

        } while (!matchingResult.hasDuplicatePairsInSameLevel(pairOption, pairs));

    }

    private Pairs matchPairs(Course course) {
        Pairs pairs = new Pairs();
        Crews crews = new Crews(course);
        List<Crew> shuffledCrews = crews.getShuffledCrews();

        Pair pair = new Pair();
        for (Crew crew : shuffledCrews) {
            pair.add(crew);

            if (isPairOfThree(shuffledCrews, crew)) {
                makePairOfThree(pairs, pair);
                continue;
            }
            pair = makePairOfTwo(pairs, pair);
        }
        return pairs;
    }

    private boolean isPairOfThree(List<Crew> shuffledCrews, Crew crew) {
        return isLastPair(shuffledCrews, crew) && isCrewNumberOdd(shuffledCrews);
    }

    private boolean isLastPair(List<Crew> shuffledCrews, Crew crew) {
        return shuffledCrews.indexOf(crew) >= shuffledCrews.size() - 3;
    }

    private boolean isCrewNumberOdd(List<Crew> shuffledCrews) {
        return shuffledCrews.size() % 2 != 0;
    }

    private void makePairOfThree(Pairs pairs, Pair pair) {
        if (pair.isThree()) {
            pairs.add(pair);
        }
    }

    private Pair makePairOfTwo(Pairs pairs, Pair pair) {
        if (pair.isTwo()) {
            pairs.add(pair);
            pair = new Pair();
        }
        return pair;
    }
}

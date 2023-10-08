package pairmatching.controller;

import pairmatching.MatchingResult;
import pairmatching.ProgramStatus;
import pairmatching.domain.PairOption;
import pairmatching.domain.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ReadPairController implements Controller{

    private final InputView inputView;
    private final OutputView outputView;

    private final MatchingResult matchingResult = MatchingResult.getInstance();

    public ReadPairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        String input = inputView.readPairOption();
        PairOption pairOption = new PairOption(input);

        if (matchingResult.hasPreviousMatching(pairOption)) {
            Pairs pairs = matchingResult.findByPairOption(pairOption);
            outputView.printMatchingResult(pairs);
            MainController.status = ProgramStatus.SELECT_FUNCTION;
        }

        if (!matchingResult.hasPreviousMatching(pairOption)) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            MainController.status = ProgramStatus.SELECT_FUNCTION;
        }
    }
}

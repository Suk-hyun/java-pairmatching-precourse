package pairmatching.controller;

import pairmatching.MatchingResult;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairInitializeController implements Controller{

    private final InputView inputView;
    private final OutputView outputView;

    public PairInitializeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        MatchingResult matchingResult = MatchingResult.getInstance();
        matchingResult.clearStore();
        outputView.printPairInit();
    }
}

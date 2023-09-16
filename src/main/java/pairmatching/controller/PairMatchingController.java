package pairmatching.controller;

import pairmatching.view.InputView;

public class PairMatchingController implements Controller {

    private final InputView inputView;

    public PairMatchingController(InputView inputView) {
        this.inputView = inputView;
    }
    @Override
    public void process() {
        String input = inputView.readCourseLevelMission();
    }

}

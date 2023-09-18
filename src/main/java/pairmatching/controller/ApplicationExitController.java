package pairmatching.controller;

import pairmatching.ProgramStatus;

public class ApplicationExitController implements Controller{
    @Override
    public void process() {
        MainController.status = ProgramStatus.QUIT;
    }
}

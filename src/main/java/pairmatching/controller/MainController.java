package pairmatching.controller;

import pairmatching.domain.FunctionOptions;
import pairmatching.utils.FileManager;
import pairmatching.view.InputView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {

    public static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    FileManager fileManager = new FileManager();
    InputView inputView = new InputView();

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public MainController() {
        this.controllerMap.put(FunctionOptions.PAIR_MATCHING.value(), new PairMatchingController(inputView));
    }

    public void run() {
        try {
            getCrewNames();
            String functionChoice = inputView.readFunctionChoice();

            Controller controller = controllerMap.get(functionChoice);

            controller.process();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void getCrewNames() throws IOException {
        List<String> backend = fileManager.toList(BACKEND_CREW_FILE_PATH);
        List<String> frontend = fileManager.toList(FRONTEND_CREW_FILE_PATH);
    }
}
package pairmatching.controller;

import pairmatching.ProgramStatus;
import pairmatching.domain.CrewNames;
import pairmatching.domain.FunctionOptions;
import pairmatching.utils.FileManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {

    public static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";
    public static ProgramStatus status;

    FileManager fileManager = new FileManager();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CrewNames crewNames;

    private final Map<String, Controller> controllerMap = new HashMap<>();

    public MainController() {
        status = ProgramStatus.PROGRAM_START;
        try {
            setCrewNames();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.controllerMap.put(FunctionOptions.PAIR_MATCHING.value(), new PairMatchingController(inputView, outputView));
        this.controllerMap.put(FunctionOptions.READ_PAIR.value(), new ReadPairController(inputView, outputView));
        this.controllerMap.put(FunctionOptions.INIT_PAIR.value(), new PairInitializeController(inputView, outputView));
        this.controllerMap.put(FunctionOptions.QUIT_PROGRAM.value(), new ApplicationExitController());
    }

    public void run() {
        while (!status.equals(ProgramStatus.QUIT)) {
            if (status.equals(ProgramStatus.PROGRAM_START) || status.equals(ProgramStatus.SELECT_FUNCTION)) {
                selectFunction();
            }
        }

    }

    private void selectFunction() {
        try {
            String functionChoice = inputView.readFunctionChoice();

            Controller controller = controllerMap.get(functionChoice);

            controller.process();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setCrewNames() throws IOException {
        List<String> backend = fileManager.toList(BACKEND_CREW_FILE_PATH);
        List<String> frontend = fileManager.toList(FRONTEND_CREW_FILE_PATH);
        crewNames = CrewNames.of(backend, frontend);
    }
}
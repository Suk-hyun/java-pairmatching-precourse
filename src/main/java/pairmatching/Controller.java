package pairmatching;

import pairmatching.utils.FileManager;

import java.io.IOException;
import java.util.List;

public class Controller {

    public static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    public static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    FileManager fileManager = new FileManager();

    public void run() {
        try {
            getCrewNames();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getCrewNames() throws IOException {
        List<String> backend = fileManager.toList(BACKEND_CREW_FILE_PATH);
        List<String> frontend = fileManager.toList(FRONTEND_CREW_FILE_PATH);
    }
}
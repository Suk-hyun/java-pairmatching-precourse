package pairmatching.controller;

import pairmatching.service.PairMatchingService;

import java.io.FileReader;
import java.io.IOException;

public class Controller {

    PairMatchingService service = new PairMatchingService();

    public void run() {

        try {
            FileReader reader = new FileReader("C:\\SpringStudy\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");

            int tmp = 0;
            while ((tmp = reader.read()) != -1) {
                char c = (char) tmp;
                service.saveBackEndCrew(String.valueOf(c));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader("C:\\SpringStudy\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");

            int tmp = 0;
            while ((tmp = reader.read()) != -1) {
                char c = (char) tmp;
                service.saveFrontEndCrew(String.valueOf(c));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

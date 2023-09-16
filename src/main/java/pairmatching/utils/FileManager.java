package pairmatching.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileManager {

    public List<String> toList(String filePath) throws IOException {
            List<String> result = new ArrayList<>();
            try (Stream<String> lines = Files.lines(Paths.get(filePath))){
                lines.forEach(result::add);
            }
            return result;
    }
}

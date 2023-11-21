package yandexPracticum.sprints.sprint2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileReader {
    ArrayList<String> readFileContents(String fileName) {
        String path = "./resources/" + fileName;
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом.\nВозможно, файл отсутствует в директории:");
            System.out.println(path);
            return new ArrayList<>();
        }
    }

}

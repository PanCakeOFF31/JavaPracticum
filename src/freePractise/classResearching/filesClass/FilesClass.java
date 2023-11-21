package freePractise.classResearching.filesClass;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static helpers.Helpers.*;

public class FilesClass {

    private static final String COMMON_DIRECTORY = "src\\freePractise\\classResearching\\filesClass";
    private static final String ABS_COMMON_DIRECTORY = "F:\\YandexDisk\\YandexDisk_mak.blinov.original\\YandexDisk\\0_Programming\\IntelliJavaProjects\\JavaYandexPracticum\\src\\freePractise\\classResearching\\filesClass";

    public static void filesClass() {
        printArticle("Files class, class researching");

//        part_1();

//            create(), delete()
        part_2();


        printArticleEnding();
    }

    private static void part_1() {
        printSection("Files.newDirectoryStream()");

        Path directory = Path.of(COMMON_DIRECTORY);

        try {
            if (Files.isDirectory(directory)) {
                System.out.println("Файлы в папке - " + directory.getFileName() + ": ");
                for (Path path : Files.newDirectoryStream(directory)) {
                    System.out.println("path.getFileName() = " + path.getFileName());
                }
            } else {
                System.out.println("Проверьте путь до - ..." + directory.subpath(directory.getNameCount() - 2, directory.getNameCount()));
            }
        } catch (IOException e) {
            System.out.println("Произошло исключение в процессе чтения файлов.");
        }

        printSectionEnding();
    }

    private static void part_2() {
        printSection("Методы: create(), delete()");

        Path directory = Path.of(COMMON_DIRECTORY).resolve("part_1");
        String fileName = "text.txt";
        Path file = directory.resolve(fileName);

        System.out.println("directory - ..." + directory.subpath(directory.getNameCount() - 4, directory.getNameCount()));
        System.out.println("file - ..." + file.subpath(file.getNameCount() - 4, file.getNameCount()));

        if (Files.exists(file)) {
            System.out.println(file.getFileName() + " уже существует, поэтому будет удален.");
            try {
                Files.delete(file);
                System.out.println(file.getFileName() + " успешно удален");
            } catch (IOException e) {
                System.out.println("Возникли проблемы в процессе удаления файла: " + file.getFileName());
            }
        }

        try {
            Files.createFile(file);
            System.out.println(file.getFileName() + " успешно создан");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе создания файла " + file.getFileName());
        }

        printSectionEnding();
    }

    private static void part_3() {
        printSection("");

        printSectionEnding();
    }

    private static void part_4() {
        printSection("");

        printSectionEnding();
    }

    private static void part_5() {
        printSection("");

        printSectionEnding();
    }

    private static void part_6() {
        printSection("");

        printSectionEnding();
    }

    private static void part_7() {
        printSection("");

        printSectionEnding();
    }

    private static void part_8() {
        printSection("");

        printSectionEnding();
    }

    private static void part_9() {
        printSection("");

        printSectionEnding();
    }
}

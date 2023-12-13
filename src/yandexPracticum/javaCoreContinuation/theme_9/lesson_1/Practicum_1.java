package yandexPracticum.javaCoreContinuation.theme_9.lesson_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

//        constructors
//        program_1();

//        isDirectory(), isFile()
//        program_2();

//        File.separator
//        program_3();

//        Paths
        program_4();

//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Files: constructors");

        File file = new File("C:/file/text.txt");

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Files: isDirectory(), isFile()");

        File main = new File("C:/Users/user/YandexDisk/0_Programming/IntelliJavaProjects/JavaYandexPracticum/src/files/YP_continuation_t9");
        File file = new File(main, "text1.txt");

        if (main.isDirectory()) {
            for (File item : main.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println("Папка - " + item.getName());
                }
                if (item.isFile()) {
                    System.out.println("Файл - " + item.getName());
                }

            }
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Files: separator");

        String main = "src/files/YP_continuation_t9";
        File origin = new File(main);
        File dir = new File(main + File.separator + "new directory");
        File renamed = new File(main + File.separator + "delete me later");

        for (File item : origin.listFiles()) {
            System.out.println(item.getName());
        }

        if (dir.exists()) {
            dir.delete();
        }

        if (dir.mkdir()) {
            System.out.println("Папка создана с именем" + dir.getName());
        }

        if (dir.renameTo(renamed)) {
            System.out.println("Папка переименована с " + dir.getName() + " на " + renamed.getName());
        }

        for (File item : origin.listFiles()) {
            System.out.println(item.getName());
        }

        if (renamed.delete()) {
            System.out.println("Папка удалена " + renamed.getName());
        }

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Path:");

//        Path filePath = Paths.get();
        Path path = Path.of("src/files/YP_continuation_t9");
        for (Path path1 : path) {
            System.out.println("path1 = " + path1);
        }

        try {
            for (Path path1 : Files.list(path).collect(Collectors.toList())) {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        path.resol

        printSectionEnding();
    }
}

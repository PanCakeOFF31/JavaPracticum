package yandexPracticum.javaCoreContinuation.theme_9.lesson_2;

import freePractise.logger_coloredString.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_2 {
    public static void practicum_2() {
        printSection("Practicum_2. I/O streams");

//        FileWriter, FileReader
//        program_1();

//        BufferedWriter, BufferedReader
//        program_2();

//
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();


        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. FileWriter, FileReader ");

        String base = "src/files/YP_continuation_t9/t9_p2";
        File file = new File(base + File.separator + "p1.txt");

        Logger.printMessage("Записываем данные");

        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("Очередная запись\n");
            System.out.println("Добавлено");
        } catch (IOException e) {
            System.out.println("Проблемы");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Проблемы при закрытии");
            }
        }

        Logger.printMessage("Считываем данные");

        try (Reader fileReader = new FileReader(file)) {
            for (; ; ) {
                int data = fileReader.read();
                if (data == -1)
                    break;
                System.out.print((char) data);

            }
        } catch (Exception e) {
            System.out.println("Проблемы");
        }
        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. BufferedWriter/Reader");

        String base = "src/files/YP_continuation_t9/t9_p2";
        File file = new File(base + File.separator + "p1.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());

            }
        } catch (Exception e) {
            System.out.println("Проблемы");
        }

        printSectionEnding();
    }
}























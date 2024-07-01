package yandexPracticum.javaFinalModule.theme_3;

import helpers.coloredString.Logger;

import static helpers.Helpers.printSection;

public class Free {

    private static int common = 10;
    private static String com = "asda";

    public static void main(String[] args) {
//        program_1();
                program_2();
        //        program_3();
        //        program_4();
        //        program_5();
        //        program_6();
        //        program_7();
        //        program_8();
        //        program_9();
    }

    private static void program_1() {
        printSection("Program_1. Тестирование ошибки");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(100);
                Logger.printMessage("thread поток" + common);
                Logger.printMessage("thread продолжит работу ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread.start();

        Logger.printMessage("main поток" + ++common);
        throw new RuntimeException();
//        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Тестирование ошибки");
        Object monitor = new Object();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10);
                synchronized (monitor) {
                    Logger.printMessage("thread поток " + com);
                    Logger.printMessage("thread продолжит работу ");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread.start();
        synchronized (monitor) {
            com = "akjsdlasjd";
            Logger.printMessage("main поток " + com);
            throw new RuntimeException();
        }
//        printSectionEnding();
    }
}

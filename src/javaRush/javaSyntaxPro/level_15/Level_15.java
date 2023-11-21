package javaRush.javaSyntaxPro.level_15;

import java.util.Arrays;

import static helpers.Helpers.*;

public class Level_15 {
    public static void level_15() {
        printSection("Level 15. Исключения");

//
//        program_1();

        program_2();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Исключения");

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println("stackTraceElement.getClassLoaderName() = " + stackTraceElement.getClassLoaderName());
                System.out.println("stackTraceElement.getFileName() = " + stackTraceElement.getFileName());
            }
        }

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program 2. StackTrace");

        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        StackTraceElement tempTraceElement = stackTraceElement[1];
        System.out.println(tempTraceElement.getClassName());
        System.out.println(tempTraceElement.getMethodName());
        System.out.println(tempTraceElement.getLineNumber());

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

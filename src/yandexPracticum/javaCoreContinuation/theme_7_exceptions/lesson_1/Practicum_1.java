package yandexPracticum.javaCoreContinuation.theme_7_exceptions.lesson_1;

import freePractise.logger_coloredString.Logger;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

//        printStackTrace()
//        program_1();

//        getMessage(), getStackTrace()
//        program_2();

//        StackTrace's methods
//        program_3();

//
        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Exceptions: printStackTrace()");

        try {
            int value = 10/0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Exceptions: getMessage(), getStackTrace()");

        try {
            int value = 10/0;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            Integer.valueOf(null);
        } catch (NumberFormatException e) {
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println("element = " + element.getMethodName() + "() " + element.getLineNumber());
            }
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. StackTrace's methods");

        try {
           throw new NullPointerException("Возникло исключение ёпта");
        } catch (NullPointerException e) {
            Logger.printMessage(e.getMessage());
            StackTraceElement temp = e.getStackTrace()[0];

            System.out.println("module - " + temp.getModuleName());
            System.out.println("file - " + temp.getFileName());
            System.out.println("class - " + temp.getClassName());
            System.out.println("method - " + temp.getMethodName());
            System.out.println("line - " + temp.getLineNumber());
            System.out.println("StackTraceElement - " + temp.toString());

        }
        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Exceptions: my exception");

        try {
            program_5();
        } catch (Exception e) {
            Logger.printCallingMethod();
            System.out.print("Я поймал ");
            System.out.println(e.getMessage());
        }

        printSectionEnding();
    }

    private static void program_5() throws Exception {
        printSection("Program_5. Exceptions: throws exception");

         throw new Exception("Не обработанное никем исключения");

//        printSectionEnding();
    }

}

class InputException extends Exception {
    public InputException(String message) {
        super(message);
    }
}

class LimitException extends RuntimeException {
    public LimitException() {
        super();
    }

    public LimitException(String message) {
        super(message);
    }
}































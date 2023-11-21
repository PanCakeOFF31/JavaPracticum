package gerbertShieldBook.chapter_10;

import java.io.IOException;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_10 {
    public static void chapter_10() {
        printArticle("Chapter 10. Обработка исключений");

//        program_1();

//        program_2();

//        program_3();

//        program_4();

        printArticleEnding();

    }

    static void program_1() {
        printSection("Program_1. try-catch");

        {
            printSubSection("Самостоятельная генерация исключения");
            try {
                throwing();
            } catch (Exception e) {
                System.out.println(e.getStackTrace()[0]);
                System.out.println(e.getMessage());
            }
            printSubSectionEnding();
        }

        {
            printSubSection("Примеры обработки исключений");
            Integer number = null;
//        number = 0;

            try {
                int a = 1 / number;
            } catch (ArithmeticException e) {
                System.out.println("Зафиксировано исключение:");
                System.out.println(e.getClass().getName());
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("Зафиксировано исключение:");
                System.out.println(e.getClass().getName());
                System.out.println(e);
            }
            printSectionEnding();
        }
        {
            printSubSection("Непроверяемое ислкючение, то есть RunTime");
            try {
                throwHandling(9);
            } catch (Exception e) {
                System.out.println(e.getClass());
            }
        }

    }

    private static void throwing() throws IOException {
        IOException exception = new IOException("");
        throw exception;
    }

    private static void throwHandling(int a) {
        Exception exception = new Exception("Uncheked exception - Runtime exception");
        if (a < 10) {
            throw new RuntimeException();
        }
    }


    static void program_2() {
        printSection("Program_2. finally");

        try {
            methodA();
        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            System.out.println("finally of program_2()");
        }

        methodB();

        printSectionEnding();
    }

    private static void methodA() {
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("finally of methodA");
        }
    }

    private static void methodB() {
        try {
            return;
        } finally {
            System.out.println("finally of methodB");
        }
    }

    static void program_3() throws MyException {
        printSection("Progmra_3. MyException");

        MyException exception = new MyException("My personal Exception");
        try {
            throw exception;
        } catch (Throwable exc) {
            System.out.println(exc.getMessage());
            System.out.println(exc.getClass().getName());
            System.out.println(exc);
        }

        MyExceptionRunTime myExceptionRunTime = new MyExceptionRunTime();
        throw myExceptionRunTime;

//        printSectionEnding();
    }

    static void program_4() {
        printSection("Program_4. Множественный перехват");
        int a = 20;
        try {
            if (a < 10)
                throw new ArithmeticException();
            else
                throw new ArrayIndexOutOfBoundsException();
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Выбрашено " + e);
        }

        a = 9;

        try {
            if (a < 10)
                throw new ArithmeticException();
            else
                throw new ArrayIndexOutOfBoundsException();
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Выбрашено " + e);
        }

        printSectionEnding();
    }

    /*static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

class MyException extends Throwable {
    public MyException(String message) {
        super(message);
    }
}

class MyExceptionRunTime extends RuntimeException {

}
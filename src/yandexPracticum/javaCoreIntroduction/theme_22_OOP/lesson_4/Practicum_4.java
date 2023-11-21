package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_4;

import static helpers.Helpers.*;

public class Practicum_4 {
    public static void practicum_4() {
        printSection("Practicum_4. ");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        Test test = new Test2();

        System.out.println(test.getA());

        Printer printer = new Printer();

        printer.print(10);
        printer.print("Привет!");
        printer.print(printer);
        printer.print(100L);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

class Test {
    private int a = 10;

    public int getA() {
        return a;
    }
}

class Test2 extends Test {

    @Override
    public int getA() {
        return super.getA();
    }
}

class Printer {

    public void print(int i) {
        System.out.println(i + " - это число.");
    }

    public void print(String s) {
        System.out.println(s + " - это строка.");
    }

    public void print(Object o) {
        System.out.println(o.toString() + " - это объект.");
    }

    @Override
    public String toString() {
        return "Я - объект принтера!";
    }
}
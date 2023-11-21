package yandexPracticum.javaCoreIntroduction.theme_21_modifiers.lesson_1;

import java.util.List;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        A a = new A();
        A.printMeow();
        a.printMeow();

        List<Integer> list = List.of(10,20,30);
        System.out.println(list);

        A a1 = new A();
        A b1 = new B();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/

    private void testFinalArgument(final String finalString) {
//        finalString = "asdasdasd"; // Не выполниться
    }
}

class A {

    static void printMeow() {
        System.out.println("MEOW AAAAAAAAAAAAAAAAA");
    }

    private void privateMethod() {
        System.out.println("Внутри А");
    }

}

class B extends A {
    static void printMeow() {
        System.out.println("MEOW BBBBBBBBBBBBBBBBBB");
    }

    private void privateMethod() {
        System.out.println("Внутри Б");
    }
}

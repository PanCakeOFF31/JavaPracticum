package yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6;

import yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.A.*;
import yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.B.B;

import static helpers.Helpers.*;

public class Practicum_6 {
    public static void practicum_6() {
        printSection("Practicum_6");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Наследование + модификаторы");

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.cheking();
        b.cheking();
        c.cheking();

        {
            int temp; // Для проверки доступа к полям класса

//         private class field - a
//        temp = a.a;

//         package-private class field - b
//        temp = a.b;

//         protected class filed - c
//        temp = a.c;

//         public class field - d
            temp = a.d;
        }

        {
            int temp;

//         private class field - a
//            temp = d.a;

//            package-private
            temp = d.b;

//            protected
            temp = d.c;

//            public
            temp = d.d;
        }

        printSubSectionEnding();
    }



     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

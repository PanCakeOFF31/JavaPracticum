package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_6;

import static helpers.Helpers.*;

public class Practicum_6 {
    public static void practicum_6() {
        printSection("Practicum_6. Классы обертки");

//      Проверка упаковок
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Тесты с классами-упаковками");

        Integer a = 100;
        Integer b = 200;

        System.out.println(a.compareTo(b));

        a = 200;
        System.out.println(a.compareTo(b));

        a = 300;
        System.out.println(a.compareTo(b));

        Double c = 100.0;

        System.out.println(c == 100.0);
        System.out.println(c.compareTo(100.0));
        System.out.println(c);

        Double d = null;

//        Так мы можем проверить на значение тип-обертка
        System.out.println(d == null);


        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

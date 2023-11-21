package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_8;

import static helpers.Helpers.*;

public class Practicum_8 {
    public static void practicum_8() {
        printSection("Practicum_8. Передача в метод по ссылке и значению ");

//
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Решаем проблему с передачей объекта-упаковки по ссылке");

        float f = 100.55f;
        Test F = new Test();

        System.out.println(f);
        System.out.println(F);

        floatInfo(f);
        floatInfo(F);

        System.out.println(f);
        System.out.println(F);

        printSubSectionEnding();
    }


     private static void floatInfo(Float a) {
         a+= 50;
         System.out.println(a);
     }

    private static void floatInfo(Test test) {
        test.test += 50;
        System.out.println(test);
    }
     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}
class Test {
    Float test = Float.valueOf(100.56f);

    @Override
    public String toString() {
        return this.test.toString();
    }
}


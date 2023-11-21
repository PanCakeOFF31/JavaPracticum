package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_6;

import static helpers.Helpers.*;
public class Lesson_6_1 {

    public static void lesson_6_1() {
        printSection("Верные параметры метода");

        System.out.println("Наибольшее из чисел 3 и 5 = " + findMax(3,5));
        System.out.println("Наибольшее из чисел 16 и 5 = " + findMax(16,5));
        System.out.println("Наибольшее из чисел -1 и -7 = " + findMax(-1,-7));

//      Использование стандартного класса Math
        System.out.println("Наибольшее из чисел 3 и 5 = " + Math.max(3,5));
        System.out.println("Наибольшее из чисел 16 и 5 = " + Math.max(16,5));
        System.out.println("Наибольшее из чисел -1 и -7 = " + Math.max(-1,-7));


        printSectionEnding();
    }

    private static int findMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

}

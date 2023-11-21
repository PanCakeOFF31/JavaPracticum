package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_6;

import static helpers.Helpers.*;

public class Lesson_6_2 {

    public static void lesson_6_2() {
        printSection("Аргменты метода");

        double[] expenses = {1772.5, 367.0, 120.6, 2150.2, 874.0, 1.0, 1459.4};
        double maxExpense = findMaxExpense(expenses);// Вызовите метод и присвойте maxExpense значение его результата
        System.out.println("Самая большая трата недели " + maxExpense);

        printSectionEnding();
    }


    public static double findMaxExpense(double[] array) {
        double result = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > result)
                result = array[i];
        }

        return result;
    }

}

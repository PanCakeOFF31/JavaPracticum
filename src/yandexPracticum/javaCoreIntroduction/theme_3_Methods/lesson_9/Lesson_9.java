package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_9;

import static helpers.Helpers.*;
public class Lesson_9 {
    public static void lesson_9() {
        printSection("Декомпозиция кода");

        // ------------------- PIXEL-------------------

        // System.out.println("Привет, Пиксель!"); // Cat
        sayHello("Пиксель");

        double[] feedExpensesCat = {100.50, 236.0, 510.6, 150.20, 80.0, 172.0, 135.4};

        double maxFeedExpenseCat = 0;

        /*
        for (int i = 0; i < feedExpensesCat.length; i++) {
            if (feedExpensesCat[i] > maxFeedExpenseCat) {
                maxFeedExpenseCat = feedExpensesCat[i];
            }
        }
        */

        maxFeedExpenseCat = findMaxExpense(feedExpensesCat);
        System.out.println("Твой самый дорогой корм стоил " + maxFeedExpenseCat);

        double sumFeedCat = 0;
        /*
        for (int i = 0; i < feedExpensesCat.length; i++) {
            sumFeedCat = sumFeedCat + feedExpensesCat[i];
        }
        */
        sumFeedCat = findExpensesSum(feedExpensesCat);
        System.out.println("Всего на корм было потрачено " + sumFeedCat);

        // System.out.println("Приятного аппетита, Пиксель!");
        sayEnjoyMeal("Пиксель");

        // ------------------- BYTE-------------------

        // System.out.println("Привет, Байт!"); // Hamster
        sayHello("Байт");

        double[] feedExpensesHamster = {70.50, 146.0, 710.6, 250.20, 83.0, 19.0, 55.4};

        double maxFeedExpenseHamster = 0;
        /*
        for (int i = 0; i < feedExpensesHamster.length; i++) {
            if (feedExpensesHamster[i] > maxFeedExpenseHamster) {
                maxFeedExpenseHamster = feedExpensesHamster[i];
            }
        }
        */
        maxFeedExpenseHamster = findMaxExpense(feedExpensesHamster);
        System.out.println("Твой самый дорогой корм стоил " + maxFeedExpenseHamster);

        double sumFeedHamster = 0;
        /*
        for (int i = 0; i < feedExpensesHamster.length; i++) {
            sumFeedHamster = sumFeedHamster + feedExpensesHamster[i];
        }
        */
        sumFeedHamster = findExpensesSum(feedExpensesHamster);
        System.out.println("Всего на корм было потрачено " + sumFeedHamster);

        // System.out.println("Приятного аппетита, Байт!");
        sayEnjoyMeal("Байт");

        printSectionEnding();
    }


    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static double findMaxExpense(double[] expenses) {
        double maxFeedExpense = 0;
        for (int i = 0; i < expenses.length; i++) {
            if (expenses[i] > maxFeedExpense) {
                maxFeedExpense = expenses[i];
            }
        }
        return maxFeedExpense;
    }

    public static double findExpensesSum(double[] expenses) {
        double sum = 0;
        for (int i = 0; i < expenses.length; i++) {
            sum += expenses[i];
        }
        return sum;
    }

    public static void sayEnjoyMeal(String name) {
        System.out.println("Приятного аппетита, " + name + "!");
    }
}


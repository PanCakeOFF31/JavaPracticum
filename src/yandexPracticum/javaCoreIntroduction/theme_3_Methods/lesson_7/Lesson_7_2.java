package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_7;

import static helpers.Helpers.*;
import java.util.Scanner;

public class Lesson_7_2 {

    public static void lesson_7_2() {
        printSection("");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую зарплату вы получите в этом месяце?");
        int salary = scanner.nextInt();
        System.out.println("Сколько планируете потратить на транспорт?");
        int transportMoney = scanner.nextInt();
        System.out.println("Сколько запланировано на супермаркеты?");
        int foodMoney = scanner.nextInt();
        System.out.println("Какую сумму хотите отложить?");
        int savings = scanner.nextInt();

        correctExpenses(salary,transportMoney,foodMoney,savings); // Вызовите метод correctExpenses с правильными аргументами

        // Напечатайте запланированные траты
        System.out.println("Вы планировали потратить: транспорт — " + transportMoney + ", "
                + "еда — " + foodMoney + ", "
                + "сбережения — " + savings + ".");
        printSectionEnding();
    }

    private static void correctExpenses(int salary, int transportMoney, int foodMoney, int savings) {

        int expensesSum = transportMoney + foodMoney + savings; // Считаем расходы
        int leftMoney = salary - expensesSum;
        if (expensesSum > salary) {
            int lackMoney = expensesSum - salary;

            while ((salary - foodMoney) < transportMoney) {
                foodMoney = foodMoney - 100;
            }

            //if (transportMoney + foodMoney + savings > salary) {
            //    savings = 0;
            //}

            savings = 0;

            // Печатаем рекомендации
            System.out.println("Придётся пересмотреть планы, вам не хватает " + lackMoney);
            System.out.println("Рекомендуемые траты: "
                    + "еда — " + foodMoney + ", "
                    + "сбережения — " + savings + ".");
        } else {
            System.out.println("В этом месяце дебет с кредитом сошлись!");
            System.out.println("Свободных средств " + leftMoney);
        }
    }
}

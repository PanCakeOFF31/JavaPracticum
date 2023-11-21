package yandexPracticum.basics.conditionStatemens;

import static helpers.Helpers.*;
import java.util.Scanner;
public class ConditionStatements {
    public static void conditionStatements() {
        printArticle("Условные операторы");

        // Работа класса Scanner
//         program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("class Scanner in java.util.Scanner");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пример использования объекта Scanner для считывания информации из консоли.");

        System.out.println("Введите слово!");
        String text_1 = scanner.next();

        System.out.println("Введите строку!");
        String text_2 = scanner.nextLine();

        System.out.println("Введите целое integer число!");
        int number_1 = scanner.nextInt();

        System.out.println("Введите целое float число!");
        float number_2 = scanner.nextFloat();

        System.out.println("Вы ввели: \"" + text_1 + "\"" );
        System.out.println("Вы ввели: \"" + text_2 + "\"" );
        System.out.println("Вы ввели: \"" + number_1 + "\"" );
        System.out.println("Вы ввели: \"" + number_2 + "\"" );

        printSectionEnding();
    }

    /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}

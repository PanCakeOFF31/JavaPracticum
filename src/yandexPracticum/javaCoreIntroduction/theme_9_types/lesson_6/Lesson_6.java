package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_6;

import java.util.Scanner;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_6 {
    public static void lesson_6() {
        printSection("Lesson_6. Классы обертки");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();
        PersonAccount user = new PersonAccount(name);

        System.out.println("Хотите открыть счёт в RUB?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        int command = scanner.nextInt();
        if (command == 1) {
            user.moneyRUB = 0.0;
        }

        System.out.println("Хотите открыть счёт в USD?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyUSD = 0.0;
        }

        System.out.println("Хотите открыть счёт в EUR?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
        command = scanner.nextInt();
        if (command == 1) {
            user.moneyEUR = 0.0;
        }

        System.out.println("Поздравляем, аккаунт для пользователя " + user.name + " создан.");
        System.out.println("Открытые счета:");
        if (user.moneyRUB != null) {
            System.out.println("- RUB");
        }
        if (user.moneyUSD != null) {
            System.out.println("- USD");
        }
        if (user.moneyEUR != null) {
            System.out.println("- EUR");
        }

        printSectionEnding();
    }
}

class PersonAccount {
    String name;      // Имя и фамилия
    Double moneyRUB;  // Счёт в рублях
    Double moneyUSD;  // Счёт в долларах
    Double moneyEUR;  // Счёт в евро


    PersonAccount(String userName) {
        name = userName;
    }
}
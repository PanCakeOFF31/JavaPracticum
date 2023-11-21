package yandexPracticum.javaCoreIntroduction.theme_10_primitive.lesson_4;

import java.util.Scanner;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_4 {
    public static void lesson_4() {
        printSection("Lesson_4. Логические выражения");

        Scanner scanner = new Scanner(System.in);
        int monthNumber;

        while (true) {
            System.out.println("Когда планируется путешествие? Введите номер месяца от 1 до 12.");
            monthNumber = scanner.nextInt();

            if (monthNumber <= 12 && monthNumber >= 1) { // Инвертируйте условие
                break;
            } else {
                System.out.println("Некорректный номер месяца. Введите ещё раз.");
            }
        }
        String season = getSeasonByNumber(monthNumber);

        if (season.equals("Лето")){
            /* Допишите ветвление, которое будет печатать строку:

              и завершать выполнение программы */
            System.out.println("Летом лучше остаться в Москве.");
            return;
        }

        System.out.println("Укажите стоимость прямых билетов из Москвы в Париж:");
        int ticketMoscowParis = scanner.nextInt();
        System.out.println("Укажите стоимость билетов из Москвы в Париж с пересадкой в Лондоне:");
        int ticketMoscowLondonParis = scanner.nextInt();
        System.out.println("У вас есть британская виза?");
        System.out.println("1 - да, виза есть");
        System.out.println("0 - визы нет");
        int britainVisa = scanner.nextInt();


        // В этом ветвлении что-то напутано с условиями - исправьте это

        if (ticketMoscowLondonParis <= ticketMoscowParis) {
            if ((britainVisa == 1)) { // Упростите это условие
                System.out.println("Летим через Лондон!");
            } else {
                System.out.println("Летим напрямую в Париж!");
            }
        } else {
            System.out.println("Летим напрямую в Париж!");
        }

        printSectionEnding();
    }


    private static String getSeasonByNumber(int monthNumber) {
        if (monthNumber >= 3 && monthNumber <= 5) {
            return "Весна";
        } else if (monthNumber >= 6 && monthNumber <= 8) {
            return "Лето";
        } else if (monthNumber >= 9 && monthNumber <= 11) {
            return "Осень";
        } else {
            return "Зима";
        }


    }
}

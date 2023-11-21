package freePractise.enumeration;

import java.util.Scanner;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Enumeration {
    static void enumeration() {
        printSection("Изучение перечислений");


        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            boolean isStill = false;

            System.out.println("Введите команду");

            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();
                if (!digitalMenu(command)) {
                    break;
                }
                scanner = new Scanner(System.in); // Боремся с подобным 1 2 3 1 25 63 2
                continue;
            }

            if (scanner.hasNext()) {
                String enter = scanner.next().trim();
                if (!lineMenu(enter)) {
                    break;
                }
                scanner = new Scanner(System.in); // Боремся с asd asd mclkjask ljdask
            }


        }

        scanner.close();
        printSectionEnding();

    }

    private static void printMenu() {
        System.out.println("Выберите возможную команду:");
        System.out.println("1 или read - считать данные");
        System.out.println("2 или write - записать данные");
        System.out.println("3 или copy - скопировать данные");
        System.out.println("4 или exit - покинуть программу");
    }

    private static MenuItem getMenuItemByOrdinal(int ordinal) {
        MenuItem[] menuItems = MenuItem.values();
        MenuItem terminator = menuItems[menuItems.length - 1];
//        Избегаем IndexOutOfBoundException
        if (ordinal < 0 || ordinal >= menuItems.length - 1)
            return terminator;

        return menuItems[ordinal];
    }

    private static MenuItem getMenuItemByValue(String value) {
        try {
            MenuItem menuItem = MenuItem.valueOf(value.toUpperCase());
            return menuItem;
        } catch (IllegalArgumentException e) {
            return MenuItem.TERMINATER;
        }
    }

    private static boolean digitalMenu(int command) {
        switch (getMenuItemByOrdinal(command - 1)) {
            case EXIT:
                System.out.println("Работа программы завершена");
                return false;
            case READ:
                System.out.println("Read command");
                break;
            case WRITE:
                System.out.println("Write command");
                break;
            case COPY:
                System.out.println("Copy command");
                break;
            case TERMINATER:
                System.out.println("Команда " + command + " выходит за допустимый диапазон!");
                break;
        }
        return true;
    }

    private static boolean lineMenu(String enter) {
        switch (getMenuItemByValue(enter)) {
            case EXIT:
                System.out.println("Работа программы завершена");
                return false;
            case READ:
                System.out.println("Read command");
                break;
            case WRITE:
                System.out.println("Write command");
                break;
            case COPY:
                System.out.println("Copy command");
                break;
            case TERMINATER:
                System.out.println("Команды " + enter + " нет!");
                break;
        }
        return true;
    }
}

enum MenuItem {
    READ, // команда на чтение
    WRITE, // команда на запись
    COPY,
    EXIT,
    TERMINATER;
}
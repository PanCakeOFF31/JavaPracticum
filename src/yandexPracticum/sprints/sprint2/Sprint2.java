package yandexPracticum.sprints.sprint2;

import java.util.ArrayList;
import java.util.Scanner;

public class Sprint2 {

    private final static String READ_MONTH_REPORTS = "1";
    private final static String READ_YEAR_REPORT = "2";
    private final static String COLLATE_REPORTS = "3";
    private final static String PRINT_MONTH_REPORTS = "4";
    private final static String PRINT_YEAR_REPORTS = "5";
    private final static String QUITE_THE_PROGRAM = "quite";
    private final static ArrayList<String> months = new ArrayList<>(3);
    private final static ArrayList<String> year = new ArrayList<>(1);

    public static void sprint2() {
        MonthReporter monthReporter = new MonthReporter();

        fillMonths();
        fillYear();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String menuOptionString;

                printMenu();
                menuOptionString = scanner.nextLine().trim();

                if (!isProcessingMenu(menuOptionString,monthReporter)) {
                    break;
                }

            }
        }
    }

    //        Обработать введенную команду пользователя
//        true - работаем, false - завершаем программу
    private static boolean isProcessingMenu(String menuOptionString, MonthReporter monthReporter) {

        if (menuOptionString.equalsIgnoreCase(QUITE_THE_PROGRAM)) {
            System.out.println("Работа программы завершена!");
            return false;
        } else if (menuOptionString.equals(READ_MONTH_REPORTS)) {
//            cashFlowReporter.readMonthReports(months);
                monthReporter.loadFile(months);
        } else if (menuOptionString.equals(READ_YEAR_REPORT)) {
//            cashFlowReporter.readYearReport(year);
        } else if (menuOptionString.equals(COLLATE_REPORTS)) {
//            cashFlowReporter.collateReports();
        } else if (menuOptionString.equals(PRINT_MONTH_REPORTS)) {
//            cashFlowReporter.printMonthReports();
        } else if (menuOptionString.equals(PRINT_YEAR_REPORTS)) {
//            cashFlowReporter.printYearReports();
        } else {
            System.out.println("Такой команды нет!");
        }
        return true;

    }

    //        Напечатать консольное меню
    private static void printMenu() {
        System.out.println("\nВыберите действие!");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("\"quite\" - Завершить работу программы\n");
    }

    //   Заполняет список именами файлов
    private static void fillMonths() {
        for (int i = 1; i <= 3; i++) {
            months.add("m.20210" + i + ".csv");
        }
    }

    //    Заполняет список именами файлов
    private static void fillYear() {
        year.add("y.2021.csv");
    }
}

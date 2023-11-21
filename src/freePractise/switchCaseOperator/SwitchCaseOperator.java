package freePractise.switchCaseOperator;

// Вспомогательный класс, для визуального оформления в консоль вывода

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class SwitchCaseOperator {
    public static void switchCaseOperator() {
        printArticle("Switch Case operator");

//        program_1();
//        program_2();
//        program_3();
//        program_4();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. a List of constants");

        int code = 50;
        int priority;

        switch (code) {
            case 100, 105:
                System.out.println("Сотый приоритет");
                priority = 4;
                break;
            case 50, 55:
                System.out.println("Пятидесятый приоритет");
                priority = 3;
                break;
            case 30, 35:
                System.out.println("Тридцатый приоритет");
                priority = 2;
            default:
                System.out.println("Обычный приоритет");
                priority = 1;
        }

        System.out.println("priority = " + priority);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_1. The yield statement");

        int code = 30;
        int priority = switch (code) {
            case 100, 105:
                System.out.println("Сотый приоритет");
                yield 4;
            case 50, 55:
                System.out.println("Пятидесятый приоритет");
                yield 3;
            case 30, 35:
                System.out.println("Тридцатый приоритет");
                yield 2;
            default:
                System.out.println("Обычный приоритет");
                yield 1;
        };

        System.out.println("priority = " + priority);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_1. An arrows");

        int code = 50;
        int priority;

        switch (code) {
            case 100, 105 -> {
                System.out.println("Сотый приоритет");
                priority = 4;
            }
            case 50, 55 -> {
                System.out.println("Пятидесятый приоритет");
                priority = 3;
            }
            case 30, 35 -> {
                System.out.println("Тридцатый приоритет");
                priority = 2;
            }
            default -> {
                System.out.println("Обычный приоритет");
                priority = 1;
            }
        }

        System.out.println("priority = " + priority);

        printSectionEnding();
    }
    private static void program_4() {
        printSection("Program_1. An arrows + list + expression");

        int code = 50;
        int a;
        int priority = switch (code) {
            case 100, 105 -> {
                System.out.println("Сотый приоритет");
                yield 4;
            }
            case 50, 55 -> {
                System.out.println("Пятидесятый приоритет");
                yield  3;
            }
            case 30, 35 -> {
                System.out.println("Тридцатый приоритет");
                yield  2;
            }
            case 20,21,22 ->
                0;
            case 10,11,15 -> a = 0;
            default -> {
                System.out.println("Обычный приоритет");
                yield  1;
            }
        };

        System.out.println("priority = " + priority);

        printSectionEnding();
    }
}
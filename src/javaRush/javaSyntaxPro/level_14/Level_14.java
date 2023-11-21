package javaRush.javaSyntaxPro.level_14;

import java.util.HashSet;
import java.util.Set;

import static helpers.Helpers.*;

public class Level_14 {
    public static void level_14() {
        printSection("Level 14. Функции");

//
//        program_1();
//        program_2();
//        program_3();
        program_4();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. HashSet");

/**/        Set<String> set = new HashSet<>();

        set.add("Maxim");
        set.add("Slavik");
        set.add("Kill real");

        System.out.println("set.toString() = " + set.toString());

        Set<String> set2 = new HashSet<>();
        set2.addAll(set);
        set2.addAll(set); // Set - множество уникальных элементов

        System.out.println("set2.toString() = " + set2.toString());

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program_2. Вспомогателный класс Collectinos");


        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. Enumeration");

        Test test = Test.TEST_1;
        test.printInfo();
        Test.TEST_2.printInfo();

        printSubSectionEnding();
    }

    private static void program_4() {
        printSubSection("Program 4. Switch + lambda syntax");

        Integer number = 20;
        switch (number) {
            case 10 -> System.out.println(number);
            case 20 -> System.out.println(number);
            default -> throw new IllegalArgumentException("Uknnown number - %d".formatted(number));
        }

        System.out.println(getStringByNumberV1(1));
        System.out.println(getStringByNumberV2(1));
        System.out.println(getStringByNumberV3(1));

        printSubSectionEnding();
    }

    private static String getStringByNumberV1(int number) {
        String result = null;

        switch (number) {
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            default:
                result = "Unkown number";
        }
        return result;
    }

    private static String getStringByNumberV2(int number) {
        String result = null;

        switch (number) {
            case 1 -> result = "One";
            case 2 -> result = "Two";
            default -> result = "Unkown number";
        }

        return result;
    }

    private static String getStringByNumberV3(int number) {
        String result;

        result = switch (number) {
            case 1 -> result = "One";
            case 2 -> result = "Two";
            default -> result = "Unkown number";
        };

        return result;
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

enum Test {
    TEST_1 {
        @Override
        public void printInfo() {
        }
    },
    TEST_2 {
        @Override
        public void printInfo() {
        }
    };

    abstract public void printInfo();

}
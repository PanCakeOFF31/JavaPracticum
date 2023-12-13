package yandexPracticum.javaCoreContinuation.theme_6.lesson_6;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_6 {
    public static void practicum_6() {
        printSection("Practicum_6");

//        program_1();
//        program_2();
//        join()
//        program_3();
//        conversion characters
//        program_4();
//        conversion characters
//        program_5();
//        conversion characters
//        program_6();
//        formatting a double value
//        program_7();

        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. String: split()");


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. String: split()");


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. String: join()");

        String[] arrayOfPets = new String[]{
                "Кот Батончик",
                "Хомяк Рафаэлка",
                "Попугай Картошка"
        };

        String joined = String.join(",", arrayOfPets);
        System.out.println("joined = " + joined);

        String joined1 = String.join(",", arrayOfPets[0], arrayOfPets[1], arrayOfPets[2]);
        System.out.println("joined1 = " + joined1);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. String: conversion characters");

        String str1 = "maxim";
        String str2 = "batman";
        String example1 = String.format("%s %S", str1, str2);
        System.out.println("example1 = " + example1);

        boolean b1 = true;
        boolean b2 = true;
        String example2 = String.format("%b or %B is a question!", b1, b2);
        System.out.println("example2 = " + example2);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. String: conversion characters min length");

//        - заполняет недостающими проблемы после строки - выравнивание по левому краю
//        + заполняет пробелами перед - выравнивание по правому краю
        String str1 = "maxim";
        String str2 = "batman";

        String example1 = String.format("%15s %15S", str1, str2);
        String example2 = String.format("%15s", str1);
        String example3 = String.format("%15s", str2);

        System.out.println("example1 = " + example1);
        System.out.println("example2 = " + example2);
        System.out.println("example3 = " + example3);

        String example4 = String.format("%-15s %-15S", str1, str2);
        String example5 = String.format("%-15s", str1);
        String example6 = String.format("%-15s", str2);

        System.out.println("example4 = " + example4);
        System.out.println("example5 = " + example5);
        System.out.println("example6 = " + example6);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. String: conversion characters, min and max");

        String str1 = "maxim";
        String str2 = "batman";

        String example1 = String.format("%1.15s %1.15S", str1, str2);
        String example2 = String.format("%1.5s", str1);
        String example3 = String.format("%1.3s", str2);

        System.out.println("example1 = " + example1);
        System.out.println("example2 = " + example2);
        System.out.println("example3 = " + example3);

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. String: double value");

        double value = 14232.51847281D;
        String str1 = String.format("value - %2.4f\n",value);
        System.out.println("value = " + value);
        System.out.println("str1 = " + str1);

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. String: advanced formatting");

        String str1 = "maxim";
        String str2 = "max";

        int maxLength = 10;

        String temp = "%" + -(maxLength + 10) + "s";
        System.out.println(temp.formatted(str1));
        System.out.println(temp.formatted(str2));

        printSectionEnding();
    }
}



















































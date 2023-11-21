package javaRush.javaSyntaxPro.level_2;

import java.util.Scanner;

import static helpers.Helpers.*;

public class Level_2 {
    public static void level_2() {
        printSection("Level 2. Знакомство с типами и ввод с клавиатуры");

//        toString() -> pars()
//        program_1();

//        Некоторые другие методы работы со строками
//        program_2();

//      Ввод с клавиатуры. Integer.nextInt() и Integer.parse() и т.п.
//        program_3();

//      Методы hastNext() у Scanner
//        program_4();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Преобразование числа в строку и строки в числе parsing");

        int a = 150;
        double b = 123.231D;

        String aStr = Integer.toString(a);
        String bStr = Double.toString(b);

        System.out.println(aStr);
        System.out.println(bStr);

        int aStrInt = Integer.parseInt(aStr, 10);
        double bStrDouble = Double.parseDouble(bStr);

        System.out.println(aStrInt);
        System.out.println(bStrDouble);


        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program_2. Некоторые другие методы работы со строками");

        String originText = "Lenght, width, height are parameters";
        String lowerCaseText = originText.toLowerCase();
        String upperCaseText = originText.toUpperCase();

        System.out.println(originText);
        System.out.println(lowerCaseText);
        System.out.println(upperCaseText);

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program_3. Scanner");

        Scanner scanner = new Scanner(System.in);

        int i;
        int a;
//        Считать данные и преобразовать их в тип int
        i = scanner.nextInt();
//        Считать данные и преобразовать их в тип int
        a = scanner.nextInt();

        String word;
        String word1;
//        Считать одно слово, слова разделяют пробелами.
//        Если ввести несколько слов, то он будет считывать по слову, штатная ситуация
        word = scanner.next();
        word1 = scanner.next();

        boolean b;
        boolean b1;
        b = scanner.nextBoolean();
        b1 = scanner.nextBoolean();

        String line;
//        line = scanner.nextLine();

        double d;
        long l;
        d = scanner.nextDouble();
        l = scanner.nextLong();

        System.out.println(i);
        System.out.println(a);
        System.out.println(word);
        System.out.println(word1);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(d);
        System.out.println(l);
//        System.out.println(line);

        scanner.close();

        printSubSectionEnding();
    }

    private static void program_4() {
        printSubSection("Program 4. scanner.hasNext() method.");

        String bigString = "Maxim 20 true Maxim end.";

//        try-with-resources - само закрывает поток
        try (Scanner scanner = new Scanner(bigString)) {
//            hasNext() проверяет, есть ли дальше слово
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int a = scanner.nextInt();
                    System.out.println(a + 10);
                } else {
                System.out.println(scanner.next());

                }

            }
        }

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

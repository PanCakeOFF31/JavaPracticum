package javaRush.javaSyntaxPro.level_3;

import static helpers.Helpers.*;

public class Level_3 {
    public static void level_3() {
        printSection("Level 3. Условный оператор");

//        Выражения, тернарный оператор
//        program_1();

//        Сравнение вещественных чисел + Math - class
//        program_2();

//        Строковые махинации
        program_3();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Выражения, тернарный оператор");
//        Тернарный оператор
        System.out.println((10 > 20 ? "Hi" : 10));

        int a;
        int b = a = 30; // a = 30 выражение, которое возвращает результат присвоения

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program 2. Сравнение вещественных чисел + Math - class");

        double a;
        double b;

        for (int i = 0; i < 5; i++) {
            a = (int) (Math.random() * 100);
            b = (int) (Math.random() * 50);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }

        a = 1.0000001;
        b = 1.0000001;
        System.out.println("a = " + a + "\nb = " + b);
        System.out.println("Math.abs(a-b) = " + Math.abs(a - b));

        if (Math.abs(a - b) < 0.0001) {
            System.out.println("Числа равны с точностью до 0,0001");
        } else {
            System.out.println("Числа не равны");
        }

        if (a == b) {
            System.out.println("a == b - " + true);
        }

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. Строковые махинации");

        String str1;
        String str2;
        str1 = "Text example! 123 123 432";
        str2 = str1;
        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("str1.equals(str2) = " + str1.equals(str2));

        printSubSection("Изменение str1");
        str1 = "Text example! V2.0";
        System.out.println("Изменяем str1");
        System.out.println("Выводим на экран str1: " + str1);
        System.out.println("Выводим на экран str2: " + str2);
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
        printSubSectionEnding();

        printSubSection("Изменение str2");
        str2 = "Text example! V3.0";
        System.out.println("Изменяем str2");
        System.out.println("Выводим на экран str1: " + str1);
        System.out.println("Выводим на экран str2: " + str2);
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
        printSubSectionEnding();

        printSubSection("Сравнение ссылок на идентичные строки");
        String str3 = "Maxim Blinov";
        String str4 = "Maxim Blinov";

        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);
        System.out.println("Здесь строки заданы строковыми литералами, поэтому существует одна" +
                " уникальная строка в пуле.");
        System.out.println("str3 == str4 - " + (str3 == str4));
        System.out.println("str3.equals(str4) - " + str3.equals(str4));
        printSubSectionEnding();

        printSubSection("Сравнение ссылок на идентичные изначально строки");
        String s3 = str3.toUpperCase();
        String s4 = str4.toUpperCase();

        System.out.println("s3: " + s3);
        System.out.println("s4: " + s4);
        System.out.println("Здесь методы приводят всегда к созданию строки, даже если уже существует идентичная.");
        System.out.println("s3 == s4 - " + (s3 == s4));
        System.out.println("s3.equals(s4) - " + s3.equals(s4));
        printSubSectionEnding();

        printSubSection("Сравнение идентичных строк через new String()");
        String str5 = "Maxim Blinov PanCakeOFF";
//        String str6 = new String("Maxim Blinov PanCakeOFF");
        String str6 = new String(str5); // Альтернативный вариант

        System.out.println("str5: " + str5);
        System.out.println("str6: " + str6);
        System.out.println("Здесь вторая строка задается через new String(\"Maxim Blinov PanCakeOFF\")");
        System.out.println("str5 == str6 - " + (str5 == str6));
        System.out.println("str5.equals(str6) - " + str5.equals(str6));
        printSubSectionEnding();

        printSubSection("Сравнение через equalsIgnoreCase()");
        String str7 = "Maxim Blinov Ignoring the case";
        String str8 = new String("mAXIM bliNOv ignoring the Case");

        System.out.println("str7: " + str7);
        System.out.println("str8: " + str8);
        System.out.println("Здесь вторая строка задается через new String(\"Maxim Blinov PanCakeOFF\")");
        System.out.println("str7 == str8 - " + (str7 == str8));
        System.out.println("str7.equalsIgnoreCase(str8) - " + str7.equalsIgnoreCase(str8));
        printSubSectionEnding();

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

package gerbertShieldBook.chapter_2;

import static helpers.Helpers.*;

// An overview of Java
public class Chapter_2 {
    public static void chapter_2() {
        printArticle("Chapter 2. An overview of Java");

//        Первая простая программа
//        program_1();

//        Вторая простая программа
//        program_2();

//        Демонстрация работы оператора if - condition statement
//        program_3();

//        Демонстрация работы цикла for - loop statement
//        program_4();

        printArticleEnding();
    }

    static void program_1() {
        printSection("Первая простая программа");

        System.out.println("Простая программа на языке Java");

        printSectionEnding();
    }

    static void program_2() {
        printSection("Вторая простая программа");

        int num;
        num = 100;
        System.out.println("Значение num: " + num);

        num = num * 2;
        System.out.print("Значение num * 2: ");
        System.out.println(num);

        printSectionEnding();
    }

    static void program_3() {
        printSection("Демонстрация работы оператора if");

        int x,y;
        x = 10;
        y = 20;
        if (x < y) System.out.println("Значение x меньше y");

        x = x * 2;
        if (x == y) System.out.println("Значение x равно y");

        x = x * 2;
        if (x > y) System.out.println("Значение x больше y");

        // Этот участок не отобразится, потому что условие ложно
        if (x == y) System.out.println("Этот вывод не отобразится");

        printSectionEnding();
    }

    static void program_4() {
        printSection("Демонстрация работы цикла for");

        for (int x = 0; x < 10; x = x + 1) {
            System.out.println("Значение x: " + x);
        }

        printSectionEnding();
    }

    /*static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/


}

package gerbertShieldBook.chapter_12;

import java.util.Arrays;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_12 {
    public static void chapter_12() {
        printArticle("Chapter 12. Enumerations, auto boxing/auto unboxing, annotations");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
        program_5();

        printArticleEnding();

    }

    private static void program_1() {
        printSection("Program_1. Creating an enumeration");

        Apple apple;

        apple = Apple.Cortland;

        System.out.println("apple = " + apple);
        System.out.println("apple.name() = " + apple.name());
        System.out.println("apple.toString() = " + apple.toString());
        System.out.println("apple == Apple.Cortland = " + (apple == Apple.Cortland));

        apple = Apple.RedDel;

        switch (apple) {
            case Jonathan:
                System.out.println("apple - " + apple);
                break;
            case GoldenDel:
                System.out.println("apple - " + apple);
                break;
            case RedDel:
                System.out.println("apple - " + apple);
                break;
            case Winesap:
                System.out.println("apple - " + apple);
                break;
            case Cortland:
                System.out.println("apple - " + apple);
                break;
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. The value() and valueOf() methods");

        Apple apple;
        Apple[] apples = Apple.values(); // Возвращает массив всех константных членов перечисления

        System.out.println("Arrays.toString(apples) = " + Arrays.toString(apples));

        apple = Apple.valueOf("Winesap");
        System.out.println("apple = " + apple);

        System.out.println("Apple.valueOf(apple.name().toString()) = " + Apple.valueOf(apple.name()));

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Enumeration constructors and methods");



        printSectionEnding();
    }

    static void program_4() {
        printSection("Program_4. Auto boxing/unboxing");

        int i = (byte) 1000;
        System.out.println(i);

        printSectionEnding();
    }

    static void program_5() {
        printSection("Program_5. Annotation");

        

        printSectionEnding();
    }

    /*static void program_*() {
        printSection("Program_. ");
        printSectionEnding();
    }*/

}

enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland;
}

enum ExtendedApple {
    Jonathan(10.5), GoldenDel(11.5), RedDel(12.5), Winesap(20.5), Cortland(300.5);
    private double price;

    ExtendedApple(double price) {
        this.price = price;
    }

    public double getPrice() {
            return price;
    }

}


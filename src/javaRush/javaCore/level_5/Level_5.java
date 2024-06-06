package javaRush.javaCore.level_5;

import javaRush.JavaRush;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Level_5 {
    public static void main(String[] args) {
//        program_1();
//        program_2();
        program_3();
    }

    public static void level_3() {
        printSection("Level 3.");

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Расширение доступа к методу");

        JavaRush.A a = new JavaRush.A();

        JavaRush.B b = new JavaRush.B();
        b.getValue();

        JavaRush.C c = new JavaRush().new C();
        "asd".length();

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. ");

        print("asd");
        print(10);
        print(null); // - ambiguous
//        print((String) null);
//        print((Integer) null);
//        print((Object) null);

        printSectionEnding();
    }

    private static void print(final String str) {
        System.out.println("String");
    }

//    private static void print(final Integer integer) {
//        System.out.println("Integer");
//    }

    private static void print(final Object obj) {
        System.out.println("Obj");
    }

    private static void program_3() {
        printSection("Program_3. ");

        Cycle cycle = new Cycle();
        System.out.println(cycle.getSum());
        System.out.println("cycle.getA() = " + cycle.getA());
        System.out.println("cycle.getB() = " + cycle.getB());
        System.out.println("cycle.getC() = " + cycle.getC());

        printSectionEnding();
    }

}

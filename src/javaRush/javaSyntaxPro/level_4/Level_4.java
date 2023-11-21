package javaRush.javaSyntaxPro.level_4;

import java.math.BigDecimal;
import java.util.Scanner;

import static helpers.Helpers.*;

public class Level_4 {
    public static void level_4() {
        printSection("Level 4. ");

//
//        program_1();

//        program_2();

//        program_3();

//        program_4();

//        program_5();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Тесты");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (scanner.hasNextInt(10)) {
            int x = scanner.nextInt(10);
            sum += x;
        }

        System.out.println("sum = " + sum);

        printSubSectionEnding();
    }

        private static void program_2() {
        printSubSection("Program 2. Подсчет чисел ввода");

        Scanner console = new Scanner(System.in);
        int count = 0;

        for (int i = 0; i < 2; i++)
        {
            if (console.hasNextInt())
                count++;
            console.next();
        }

        System.out.println(count);

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. Подсчет чисел через while");

        Scanner console = new Scanner(System.in);
        int count = 0;

        while (console.hasNextInt())
        {
                count++;
            console.next();
        }

        System.out.println(count);

        printSubSectionEnding();
    }

    private static void program_4() {
        printSubSection("Program 4. Double числа, округления");

        System.out.println(1.0*21/5);
        System.out.println((double)21/5*1);

        double a = 10.1;
        double b = 10.5;
        double c = 10.9;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("Math.round(a) = " + Math.round(a));
        System.out.println("Math.round(b) = " + Math.round(b));
        System.out.println("Math.round(c) = " + Math.round(c));

        System.out.println("Math.ceil(a) = " + Math.ceil(a));
        System.out.println("Math.ceil(b) = " + Math.ceil(b));
        System.out.println("Math.ceil(c) = " + Math.ceil(c));

        System.out.println("Math.floor(a) = " + Math.floor(a));
        System.out.println("Math.floor(b) = " + Math.floor(b));
        System.out.println("Math.floor(c) = " + Math.floor(c));

        a = -a;
        b = -b;
        c = -c;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("Math.round(a) = " + Math.round(a));
        System.out.println("Math.round(b) = " + Math.round(b));
        System.out.println("Math.round(c) = " + Math.round(c));

        System.out.println("Math.ceil(a) = " + Math.ceil(a));
        System.out.println("Math.ceil(b) = " + Math.ceil(b));
        System.out.println("Math.ceil(c) = " + Math.ceil(c));

        System.out.println("Math.floor(a) = " + Math.floor(a));
        System.out.println("Math.floor(b) = " + Math.floor(b));
        System.out.println("Math.floor(c) = " + Math.floor(c));

        double test_1 = 1E9D;
        double test_2 = 1E-9D;

        double test_3 = 1.00000000000000001D;
        double test_4 = 1.00000000000000002D;

        System.out.println(test_1-test_2);

        System.out.println(test_3 == test_4);

        printSubSectionEnding();
    }

    private static void program_5() {
        printSubSection("Program 5. ");

        BigDecimal a = new BigDecimal(0.101010010100023123032010312031235);
        BigDecimal b = new BigDecimal(0.000000000000000000000000000000001);
//        System.out.println(a.);

        for(int i = 0; i < 10; i++) {
            continue;
        }

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

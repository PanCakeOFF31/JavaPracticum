
package javaRush.javaSyntaxPro.level_9;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

import static helpers.Helpers.*;

public class Level_9 {
    public static void level_9() {
        printSection("Level 9. Полезные нюансы");

//
//        program_1();

//        program_2();

//        program_3();

//        program_4();

        program_5();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Свои математические опыты");

        System.out.println(Math.pow(10, 5));
        System.out.println(rootOf(Math.pow(10, 5), 5));

        System.out.println(logByBase(8, 2));

        printSubSectionEnding();
    }

    private static double rootOf(double a, double rootDegree) {
        return Math.pow(a, 1.0 / rootDegree);
    }

    private static double logByBase(double number, double base) {
        return Math.log(number) / Math.log(base);
    }

    private static void program_2() {
        printSubSection("Program 2. Случайные числа");

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextGaussian());
        }

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. printf() - method");
        System.out.println("Level_9.program_3");

        {
            int a = 10;
            double d = 20.0;
            String name = "maxim";

            System.out.printf("Hello, %s, your age is %d. You can do it as %f.\n", name, a, d);

        }

        {
            byte a = 10;
            short c = 10;
            int d = 10;
            long e = 10L;

            float f = 10.0213124F;
            double g = 10.12412520D;

            char h = 'A';

            String test = String.format("Все типы форматируемого значения:\n" +
                    "byte a - %d\nshort c - %d\nint d - %d\nlong e - %d\n" +
                    "float f - %.2f\ndouble g - %f\nchar h - %c", a, c, d, e, f, g, h);
            System.out.printf("%s\n", test);
        }

        System.out.println("%s - String variables");
        System.out.println("%d - integer numbers");
        System.out.println("%f - float point numbers");
        System.out.println("%b - boolean variables");
        System.out.println("%c - char variables");
        System.out.println("% -  variables");

        printSubSectionEnding();
    }

    private static void program_4() {
        printSubSection("Program 4. Операции с флагами");
        System.out.println("Level_9.program_4");

        int flags = 0b0001_0010;
        System.out.println(Integer.toBinaryString(flags));
        flags = setTheFlag(flags, 3);
        System.out.println(Integer.toBinaryString(flags));
        flags = setTheFlag(flags, 0);
        System.out.println(Integer.toBinaryString(flags));
        System.out.println(checkTheFlag(flags, 0));
        flags = resertTheFlag(flags, 0);
        System.out.println(Integer.toBinaryString(flags));
        System.out.println(checkTheFlag(flags, 0));

        printSubSectionEnding();
    }

    private static int setTheFlag(int flags, int position) {
        return flags | (0b1 << position);
    }

    private static int resertTheFlag(int flags, int position) {
        return flags & ~(0b1 << position);
    }

    private static boolean checkTheFlag(int flags, int position) {
        return ((flags & (1 << position)) == (1 << position));
    }

    private static void program_5() {
        printSubSection("Program 5. Проверка чужого примера");
        System.out.println("Level_9.program_5");

        int a = 3;
        int b = a++ + (a++ * ++a); // 3 + (4 * 6)
        System.out.println(b);
        a = 3;
        b = a++ + (--a * a++); // 3 + (3*3)
        System.out.println(b);
        a = 3;
        b = --a + (--a * ++a); //2 + (1 * 2)
        System.out.println(b);


        printSubSectionEnding();
    }
    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}


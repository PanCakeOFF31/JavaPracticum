package freePractise.classResearching.math;

import static helpers.Helpers.*;

public class Math {
    final static double PI = java.lang.Math.PI;
    final static double RADIANS_TO_DEGREES = java.lang.Math.toRadians(1);
    final static double DEGREES_TO_RADIANS = java.lang.Math.toDegrees(1);
    final static double EXP = java.lang.Math.exp(1);

    public static void mathClass() {
        printSection("Math class");
        printSubSection("All trigonometric static fields:");

        System.out.println("Math.PI = " + java.lang.Math.PI);
        System.out.println("Math.E = " + java.lang.Math.E);
        System.out.println("Math.TAU = " + java.lang.Math.TAU + "2 * PI");
        System.out.println("EXP = " + EXP);
        System.out.println("RADIANS_TO_DEGREES = " + RADIANS_TO_DEGREES);
        System.out.println("DEGREES_TO_RADIANS = " + DEGREES_TO_RADIANS);

        printSubSectionEnding();

        printSubSection("Variables:");

        double angleInRadian = 2.0;
        double angleInDegree = java.lang.Math.toDegrees(angleInRadian);

        System.out.println("1 радиан примерно равен 57.3 градусов");
        System.out.println("angleInRadian = " + angleInRadian);
        System.out.println("angleInDegree = " + angleInDegree);
        System.out.println("360 градусов в радианах = " + java.lang.Math.toRadians(360.0));
        System.out.println("360 градусов - 2 * PI = " + 2 * PI);

        printSubSectionEnding();

        printSubSection("Trigonometric methods:");

        System.out.println("Math.sin(Math.toRadians(90)) = " + java.lang.Math.sin(java.lang.Math.toRadians(90)));
        System.out.println("Math.cos(Math.toRadians(0)) = " + java.lang.Math.cos(java.lang.Math.toRadians(0)));
        System.out.println("Math.tan(Math.toRadians(45)) = " + java.lang.Math.tan(java.lang.Math.toRadians(45)));
        System.out.println("Math.tan(Math.toRadians(0)) = " + java.lang.Math.tan(java.lang.Math.toRadians(0)));

        printSubSectionEnding();

        printSubSection("Exponent");

        double positiveInfinity = 1 / 0.0;
        double negativeInfinity = -1 / 0.0;
        double NaN = positiveInfinity * negativeInfinity;

        System.out.println("EXP = " + EXP);
        System.out.println("Math.exp(0) = " + java.lang.Math.exp(0));
        System.out.println("Math.exp(1) = " + java.lang.Math.exp(1));
        System.out.println("Math.exp(positiveInfinity) = " + java.lang.Math.exp(positiveInfinity));
        System.out.println("Math.exp(negativeInfinity) = " + java.lang.Math.exp(negativeInfinity));
        System.out.println("Math.exp(NaN) = " + java.lang.Math.exp(NaN));

        printSubSectionEnding();

        printSubSection("Number rounding");

        {
            double a = 231.3;
            double b = 231.5;
            double c = 231.8;

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            System.out.println("Стандартное округление до целого:");
            System.out.println("Math.round(a) = " + java.lang.Math.round(a));
            System.out.println("Math.round(b) = " + java.lang.Math.round(b));
            System.out.println("Math.round(c) = " + java.lang.Math.round(c));

            System.out.println("Округление до потолка:");
            System.out.println("Math.ceil(a) = " + java.lang.Math.ceil(a));
            System.out.println("Math.ceil(b) = " + java.lang.Math.ceil(b));
            System.out.println("Math.ceil(c) = " + java.lang.Math.ceil(c));

            System.out.println("Округление до пола:");
            System.out.println("Math.floor(a) = " + java.lang.Math.floor(a));
            System.out.println("Math.floor(b) = " + java.lang.Math.floor(b));
            System.out.println("Math.floor(c) = " + java.lang.Math.floor(c));

        }

        {
            double a = -231.3;
            double b = -231.5;
            double c = -231.8;

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);

            System.out.println("Стандартное округление до целого:");
            System.out.println("Math.round(a) = " + java.lang.Math.round(a));
            System.out.println("Math.round(b) = " + java.lang.Math.round(b));
            System.out.println("Math.round(c) = " + java.lang.Math.round(c));

            System.out.println("Округление до потолка:");
            System.out.println("Math.ceil(a) = " + java.lang.Math.ceil(a));
            System.out.println("Math.ceil(b) = " + java.lang.Math.ceil(b));
            System.out.println("Math.ceil(c) = " + java.lang.Math.ceil(c));

            System.out.println("Округление до пола:");
            System.out.println("Math.floor(a) = " + java.lang.Math.floor(a));
            System.out.println("Math.floor(b) = " + java.lang.Math.floor(b));
            System.out.println("Math.floor(c) = " + java.lang.Math.floor(c));

        }

        printSubSectionEnding();

        printSubSection("Others");

        System.out.println("Math.log(EXP) = " + java.lang.Math.log(EXP));
        System.out.println("Math.log10(100) = " + java.lang.Math.log10(100));
        System.out.println("Math.pow(2,7) = " + java.lang.Math.pow(2, 7));
        System.out.println("Math.sqrt(44 * 44) = " + java.lang.Math.sqrt(java.lang.Math.pow(44,2)));
        System.out.println("Math.cbrt(8) = " + java.lang.Math.cbrt(8));
        System.out.println("Math.random() = " + java.lang.Math.random());
        System.out.println(java.lang.Math.max(40.4,23.3));
        System.out.println(java.lang.Math.min(40.4,23.3));

        printSubSectionEnding();

        printSubSection("Methods throwing an overload exception");

        System.out.println(java.lang.Math.addExact(13, 12L));
//        System.out.println(Math.);

        printSubSectionEnding();

        printSectionEnding();
    }
}

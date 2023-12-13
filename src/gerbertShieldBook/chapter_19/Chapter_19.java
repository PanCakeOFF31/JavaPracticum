package gerbertShieldBook.chapter_19;

import freePractise.logger_coloredString.Colors;
import freePractise.logger_coloredString.Logger;

import java.io.IOException;
import java.util.Arrays;

import static helpers.Helpers.*;

public class Chapter_19 {
    private final static String[] strings = {
            "away",
            "anger",
            "ecology",
            "eCoLogy",
            "document",
            "fold",
            "damp",
            "football",
            "cat",
            "bandit",
            "damper",
            "accept",
            "lower",
            "fanny",
            "center",
            "apple",
            "cup",
            "burger",
            "chess"
    };

    public static void chapter_19() {
        printArticle("Chapter_19. ");

//        Double/Float: valueOf(), hashCode()
//        program_1();

//        Number
//        program_2();

//      Wrapper's fields
//        program_3();

//        Integer
//        program_4();

//        Double/Float fields:
//        program_5();

//        Double/Float methods
//        program_6();

//        Long/Integer/Short/Byte
//        program_7();

//        Character: isMethods()
//        program_8();

//        Character:
//        program_9();

//        Boolean
//        program_10();

//        Runtime
//        program_11();
//        program_12();

//        Cloneable()
//        program_13();

//        System
//        program_14();

        program_15();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Double/Float wrapper: valueOf(), hashCode()");

        Double d1 = Double.valueOf("3.1415E+4");
        System.out.println("d1 = " + d1);

        Double d2 = Double.valueOf(3.1415);
        System.out.println("d2 = " + d2);

        System.out.println("d1.hashCode() = " + d1.hashCode());
        System.out.println("d2.hashCode() = " + d2.hashCode());

        Double d3 = 23.2 / 0.0;
        Double d4 = -23.2 / 0.0;
        Double d5 = 0.0 / 0.0;

        System.out.println("23.2/0 = " + (23.2 / 0));
        System.out.println("-23.2/0 = " + (-23.2 / 0));
        System.out.println("0.0/0.0 = " + (0.0 / 0.0));

        System.out.println(Double.isFinite(d3));
        System.out.println(Double.isInfinite(d3));
        System.out.println(Double.isInfinite(d4));
        System.out.println(Double.isNaN(d5));

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Abstract Class Number");

        Integer integer1 = Integer.valueOf(999);

        System.out.println("integer1 = " + integer1);

        Logger.printMessage("Все методы, которые определены в абстрактном классе Number");

        System.out.println("integer1.longValue() = " + integer1.longValue());
        System.out.println("integer1.intValue() = " + integer1.intValue());
        System.out.println("integer1.shortValue() = " + integer1.shortValue());
        System.out.println("integer1.byteValue() = " + integer1.byteValue());
        System.out.println("integer1.floatValue() = " + integer1.floatValue());
        System.out.println("integer1.doubleValue() = " + integer1.doubleValue());

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. final fields of Wrappers");

        Logger.printMessage("Byte");
        System.out.println("Byte.SIZE = " + Byte.SIZE);
        System.out.println("Byte.BYTES = " + Byte.BYTES);
        System.out.println("Byte.TYPE = " + Byte.TYPE);

        Logger.printMessage("Short");
        System.out.println("Short.SIZE = " + Short.SIZE);
        System.out.println("Short.BYTES = " + Short.BYTES);
        System.out.println("Short.TYPE = " + Short.TYPE);

        Logger.printMessage("Integer");
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        System.out.println("Integer.BYTES = " + Integer.BYTES);
        System.out.println("Integer.TYPE = " + Integer.TYPE);

        Logger.printMessage("Long");
        System.out.println("Long.SIZE = " + Long.SIZE);
        System.out.println("Long.BYTES = " + Long.BYTES);
        System.out.println("Long.TYPE = " + Long.TYPE);

        Logger.printMessage("Double");
        System.out.println("Double.SIZE = " + Double.SIZE);
        System.out.println("Double.BYTES = " + Double.BYTES);
        System.out.println("Double.TYPE = " + Double.TYPE);

        Logger.printMessage("Float");
        System.out.println("Float.SIZE = " + Float.SIZE);
        System.out.println("Float.BYTES = " + Float.BYTES);
        System.out.println("Float.TYPE = " + Float.TYPE);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Integer");

//        Целые числа имеют дополнительный статический метод для valueOf() с указанием radix
        Integer int1 = Integer.valueOf("FF", 16);
        System.out.println("int1 = " + int1);

        Integer int2 = Integer.parseInt("AF", 16);
        System.out.println("int2 = " + int2);

        Integer int3 = Integer.valueOf(1_000_000);
        Integer int4 = Integer.valueOf(-1_000_000);

        System.out.println("int3 = " + int3);
        System.out.println("int4 = " + int4);

        Long long1 = Integer.toUnsignedLong(int3);
        System.out.println("long1 = " + long1);

        Long long2 = Integer.toUnsignedLong(int4);
        System.out.println("long2 = " + long2);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Double/Float: final String fields");

        Logger.printMessage("Double wrapper");
        System.out.println("Double.BYTES = " + Double.BYTES);
        System.out.println("Double.SIZE = " + Double.SIZE);
        System.out.println("Double.TYPE = " + Double.TYPE);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_NORMAL = " + Double.MIN_NORMAL);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.MIN_EXPONENT = " + Double.MIN_EXPONENT);
        System.out.println("Double.MAX_EXPONENT = " + Double.MAX_EXPONENT);
        System.out.println("Double.PRECISION = " + Double.PRECISION);
        System.out.println("Double.POSITIVE_INFINITY = " + Double.POSITIVE_INFINITY);
        System.out.println("Double.NaN = " + Double.NaN);
        System.out.println("Double.NEGATIVE_INFINITY = " + Double.NEGATIVE_INFINITY);

        Logger.printMessage("Float wrapper");
        System.out.println("Float.BYTES = " + Float.BYTES);
        System.out.println("Float.SIZE = " + Float.SIZE);
        System.out.println("Float.TYPE = " + Float.TYPE);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
        System.out.println("Float.MIN_NORMAL = " + Float.MIN_NORMAL);
        System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("Float.MIN_EXPONENT = " + Float.MIN_EXPONENT);
        System.out.println("Float.MAX_EXPONENT = " + Float.MAX_EXPONENT);
        System.out.println("Float.PRECISION = " + Float.PRECISION);
        System.out.println("Float.POSITIVE_INFINITY = " + Float.POSITIVE_INFINITY);
        System.out.println("Float.NaN = " + Float.NaN);
        System.out.println("Float.NEGATIVE_INFINITY = " + Float.NEGATIVE_INFINITY);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Double/Float methods");

        Logger.printItalicMessage("Double", Colors.CYAN);

        Double double1 = Double.valueOf(123.45678900001);
        Double double2 = Double.valueOf("1.23456789E2");

        System.out.println("double1 = " + double1 + " as Double.valueOf(123.45678900001)");
        System.out.println("double2 = " + double2 + " as Double.valueOf(\"1.23456789E2\")");
        System.out.println("Difference  = " + (double1.doubleValue() - double2.doubleValue()));

        System.out.println("Double.compare(double1,double2) = " + Double.compare(double1, double2));
        System.out.println("double1.compareTo(double2) = " + double1.compareTo(double2));

        System.out.println("Double.min(double1,double2) = " + Double.min(double1, double2));
        System.out.println("Double.max(double1,double2) = " + Double.max(double1, double2));

        System.out.println("Double.hashCode(double1) = " + Double.hashCode(double1));
        System.out.println("double1.hashCode() = " + double1.hashCode());

        System.out.println("Double.valueOf(1.0/0.0).isInfinite() = " + Double.valueOf(1.0 / 0.0).isInfinite());
        System.out.println("Double.isInfinite(1.0/0.0) = " + Double.isInfinite(1.0 / 0.0));

        System.out.println("Double.toHexString(double1) = " + Double.toHexString(double1));

        Logger.printItalicMessage("Float", Colors.CYAN);

        Float float1 = Float.valueOf(123.4567891F);
        Float float2 = Float.valueOf("1.23456789E2F");

        System.out.println("float1 = " + float1 + " as Float.valueOf(123.4567891F)");
        System.out.println("float2 = " + float2 + " as Float.valueOf(\"1.23456789E2F\")");
        System.out.println("Difference  = " + (float1.floatValue() - float2.floatValue()));

        System.out.println("Float.compare(float1,float2) = " + Float.compare(float1, float2));
        System.out.println("float1.compareTo(float2) = " + float1.compareTo(float2));

        System.out.println("Float.min(float1,float2) = " + Float.min(float1, float2));
        System.out.println("Float.max(float1,float2) = " + Float.max(float1, float2));

        System.out.println("Float.hashCode(float1) = " + Float.hashCode(float1));
        System.out.println("float1.hashCode() = " + float1.hashCode());

        System.out.println("Float.valueOf(1.0/0.0).isInfinite() = " + Float.valueOf(1.0f / 0.0f).isInfinite());
        System.out.println("Float.isInfinite(1.0/0.0) = " + Float.isInfinite(1.0f / 0.0f));

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Long/Integer/Short/Byte");

        Logger.printBoldMessage("Integer");


        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Character isSomething()");

        Logger.printBoldMessage("Character");
        Logger.printItalicMessage("Character");
        Logger.printUnderlineMessage("Character");

        System.out.println("Character.getNumericValue('Я') = " + Character.getNumericValue('Я'));
        System.out.println(Character.valueOf((char) 600) + " - " + Character.getName(600));

        Character character1 = Character.valueOf('Я');
        System.out.println(character1);
        characterIdentifier(character1);

        Character character2 = Character.valueOf('\t');
        System.out.println(character2);
        characterIdentifier(character2);

        Character character3 = Character.valueOf(' ');
        System.out.println(character3);
        characterIdentifier(character3);

        Character character4 = Character.valueOf(';');
        System.out.println(character4);
        characterIdentifier(character4);

        Character character5 = Character.valueOf('\n');
        System.out.println(character5);
        characterIdentifier(character5);


        printSectionEnding();
    }

    private static void characterIdentifier(char c) {
        if (Character.isLetterOrDigit(c))
            System.out.println(c + " является буквой или цифрой");

        if (Character.isLetter(c))
            System.out.println(c + " является буквой");

        if (Character.isUpperCase(c))
            System.out.println(c + " является буквой в верхнем регистре");

        if (Character.isLowerCase(c))
            System.out.println(c + " является буквой в нижнем регистре");

        if (Character.isDigit(c))
            System.out.println(c + " является цифрой");

        if (Character.isSpaceChar(c))
            System.out.println(c + " является пробелом");

        if (Character.isWhitespace(c))
            System.out.println(c + " является white space");

        if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c))
            System.out.println(c + " является спец символом");
    }

    private static void program_9() {
        printSection("Program_9. Character: 4 byte characters");


        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. Boolean");

        System.out.println(Boolean.logicalAnd(true, true));
        System.out.println(Boolean.logicalOr(true, false));
        System.out.println(Boolean.logicalXor(true, false));

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Runtime");

        int[] ints = new int[268_000_000]; // 1GB

        long totalMemory = Runtime.getRuntime().totalMemory();
        long totalMemoryGB = totalMemory / 1024 / 1024 / 1024;
        long freeMemory = Runtime.getRuntime().freeMemory();
        long freeMemoryGB = freeMemory / 1024 / 1024;

        System.out.println("totalMemoryGB = " + totalMemoryGB);
        System.out.println("freeMemoryGB = " + freeMemoryGB);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. Runtime: exec()");

        try {
            Runtime.getRuntime().exec("notepad");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

    private static void program_13() {
        printSection("Program_13. Object clone()");

        class Test implements Cloneable {

            int a = 100;

            public Test(int a) {
                this.a = a;
            }

            //            При переопределении допустимо изменять модификатор доступа, тип возвращаемого значения
//            и выбрасывание исключения. Потому, что эти значения не входят в сигнатуру
            @Override
            public Test clone() {
                return new Test(this.a);
            }

            @Override
            public String toString() {
                return "{a: " + a + "}";
            }
        }

        Test test1 = new Test(100);
        Test test2;
        test2 = test1.clone();

        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);

        printSectionEnding();
    }

    private static void program_14() {
        printSection("Program_14. System");

        class Test {
            private int a;

            public Test(int a) {
                this.a = a;
            }

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            @Override
            public String toString() {
                return "{a: " + a + "}";
            }
        }

        Test[] test = new Test[] {
          new Test(100),
          new Test(200),
          new Test(300),
          new Test(400),
          new Test(500)
        };

        Test[] copy = new Test[5];

//        Выполнение поверхностного копирования
        System.arraycopy(test,0,copy,0,test.length);

        copy[1].setA(999);

        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(copy));

        printSectionEnding();
    }

    private static void program_15() {
        printSection("Program_15. Class");

         class A {

         }

         class B extends A {

         }

        System.out.println(new A().getClass().getName());
        System.out.println(new A().getClass().getSuperclass());

        System.out.println(new B().getClass().getName());
        System.out.println(new B().getClass().getSuperclass());



        printSectionEnding();
    }

}



















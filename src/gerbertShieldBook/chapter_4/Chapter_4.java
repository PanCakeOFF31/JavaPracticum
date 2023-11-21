package gerbertShieldBook.chapter_4;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_4 {
    public static void chapter_4() {
        printArticle("Chapter 4. Operators");

//        Арифметические операторы - Arithmetic operators
//        Операторы инкремента и декремента
//        program_1();

//        Побитовые операции отрицания, смещения, присвоения со смещением
//        program_2();

//      Побитовые операции и, или, исключающее или и их вариации
//        program_3();

//
        program_4();

        printArticleEnding();

    }

    static void program_1() {
        printSection("Program_1. Арифметические операторы. Инкремент и декремент");

        int a = 10;
        int b = 10;

        System.out.println("Пример иллюстрирующий разницу между префиксной и постфиксной формой записи");

        System.out.println("a = " + a + ", b = " + b);
        System.out.println("--a = " + --a + ", --b = " + --b);
        System.out.println("a-- = " + a-- + ", b-- = " + b--);
        System.out.println("a = " + a + ", b = " + b);

        printSectionEnding();
    }


    static void program_2() {
        printSection("Побитовые операции \"~, <<, >>, >>>\":");

        int a = 100;

        System.out.println("int a = " + a);
        System.out.println("Или в битовом представлении, a:");
        System.out.println(printAllZeroes(a, 32));

        System.out.println("1. Унарный оператор ~");
        System.out.println("Не а:");
        System.out.println(printAllZeroes(~a, 32));

        System.out.println("2. Выполним смещение влево << для a = " + a);
        a <<= 2;
        System.out.println("a << 2 = " + (a) + " или a:");
        System.out.println(printAllZeroes(a, 32));

        System.out.println("3. Выполним смещение вправо >>  для a = " + a);
        a >>= 2;
        System.out.println("a << 2 = " + (a) + " или a:");
        System.out.println(printAllZeroes(a, 32));

        int b = 0b0000_0000_1111_1111_0000_0000_0000_0000;

        System.out.println("int b = " + b);
        System.out.println("Или в битовом представлении, b:");
        System.out.println(printAllZeroes(b, 32));

        System.out.println("Выполним смещение вправо >> на 2 для b:");
        b >>= 2;
        System.out.println(printAllZeroes(b, 32));

        System.out.println("Выполним смещение влево << на 2 для b:");
        b <<= 2;
        System.out.println(printAllZeroes(b, 32));

        System.out.println("Выполним смещение влево << на 9 для b:");
        b <<= 9;
        System.out.println(printAllZeroes(b, 32));

        System.out.println("Выполним смещение вправо >> на 8 для b:");
        b >>= 8;
        System.out.println(printAllZeroes(b, 32));

        System.out.println("Выполним смещение влево << на 9 для b:");
        b <<= 9;
        System.out.println(printAllZeroes(b, 32));

        System.out.println("4.Выполним смещение вправо с заполнением нулями >>> на 8 для b:");
        b >>>= 8;
        System.out.println(printAllZeroes(b, 32));


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Демонстрация побитовых логических операций \"AND, OR, EXCLUSIVE OR\" и варианты с NOT\n");

        int c = 0b0000_0000_1111_1111_0000_0000_0000_0000;
        int d = 0b0100_1010_1001_0011_1100_0001_0110_0100;

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c AND d:");
        System.out.println("   " + printAllZeroes((c & d), 32) + "\n");

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c NOT AND d:");
        System.out.println("   " + printAllZeroes(~(c & d), 32) + "\n");

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c OR d:");
        System.out.println("   " + printAllZeroes((c | d), 32) + "\n");

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c NOT OR d:");
        System.out.println("   " + printAllZeroes(~(c | d), 32) + "\n");

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c EXCLUSIVE OR d:");
        System.out.println("   " + printAllZeroes((c ^ d), 32) + "\n");

        System.out.println("c: " + printAllZeroes(c, 32));
        System.out.println("d: " + printAllZeroes(d, 32));
        System.out.println("c NOT EXCLUSIVE OR d:");
        System.out.println("   " + printAllZeroes(~(c ^ d), 32) + "\n");

        printSectionEnding();
    }

    // Метод для заполнения битового представления числа до полного разряда
    private static String printAllZeroes(int number, int size) {
        String str = Integer.toBinaryString(number);
        while (str.length() < size) {
            str = "0" + str;
        }
        return str;
    }

    /*static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/

    private static void program_4() {
        printSection("");

        printSectionEnding();
    }
}

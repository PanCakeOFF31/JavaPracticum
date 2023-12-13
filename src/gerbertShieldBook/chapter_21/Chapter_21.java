package gerbertShieldBook.chapter_21;

import helpers.coloredString.Logger;

import java.util.*;

import static helpers.Helpers.*;

public class Chapter_21 {
    public static void chapter_21() {
        printArticle("Chapter_21. ");

//        StringTokenizer - устаревший вариант, современным является регулярные выражения
//        program_1();

//          BitSet
//        program_2();

//        Optional
//        program_3();

//        OptionalDouble
//        program_4();

//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. StringTokenizer");

        String original = "Java; C#, Python, Ruby, C++";

        Logger.printMessage("StringTokenizer:");
        {
//        В delimiter указывается список символов разделителей
            StringTokenizer tokenizer = new StringTokenizer(original, ":; ,");

            while (tokenizer.hasMoreTokens()) {
                System.out.println(tokenizer.nextToken());
            }

            StringTokenizer tokenizer1 = new StringTokenizer(original);
            System.out.println(tokenizer1.nextToken("a"));
            System.out.println(tokenizer1.nextToken("a"));
            System.out.println(tokenizer1.nextToken("C"));
        }

        Logger.printMessage("Enumeration<Object>:");
        {
            Enumeration<Object> tokenizer = new StringTokenizer(original);
            while (tokenizer.hasMoreElements())
                System.out.println(tokenizer.nextElement());
        }

        Logger.printMessage("Enumeration<Object> - Integer");
        {
            Enumeration<Object> tokenizer = new StringTokenizer("1, 15, 23, 44, 55", " ,");
            while (tokenizer.hasMoreElements())
                System.out.println(Integer.parseInt((String) tokenizer.nextElement()));
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. BitSet");

        {
            BitSet bits = new BitSet(65);

            System.out.println("bits = " + bits);
            System.out.println(bits.length());

            bits.set(12, 50, true);

            System.out.println("bits = " + bits);
            System.out.println(bits.length());
            System.out.println(bits.size());
            System.out.println(bits.cardinality());
        }

        {
            BitSet bits = new BitSet();

            bits.set(65);

            System.out.println("bits = " + bits);
            System.out.println("bits.length() = " + bits.length());
            System.out.println("bits.size() = " + bits.size());
            System.out.println("bits.cardinality() = " + bits.cardinality());
        }

        {
            BitSet bits = new BitSet();

            bits.set(4, 8, true);

            long[] longs = bits.toLongArray();
            for (long l : longs) {
                System.out.println(Long.toBinaryString(l));
            }

            BitSet bits1 = new BitSet();
            bits1.set(0, 3);

            BitSet temp = (BitSet) bits.clone();
            temp.or(bits1);

            long[] tempLong = temp.toLongArray();

            for (long l : tempLong) {
                System.out.println(Long.toBinaryString(l));
            }
        }


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Optional<T>");

        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.of("Some text");

        printSubSection("Инициализация Optional");
        System.out.println("optional1 = " + optional1);
        System.out.println("optional2 = " + optional2);

        printSubSection("isEmpty()");
        System.out.println("optional1.isEmpty() = " + optional1.isEmpty());
        System.out.println("optional2.isEmpty() = " + optional2.isEmpty());

        printSubSection("isPresent");
        System.out.println("optional1.isPresent() = " + optional1.isPresent());
        System.out.println("optional2.isPresent() = " + optional2.isPresent());

        printSubSection("get()");
        try {
            System.out.println("optional1.get() = " + optional1.get());
        } catch (Exception e) {
            Logger.printAlarmMessage("Попытка вызвать get для пустого Optional");
        }
        System.out.println("optional2.get() = " + optional2.get());

        printSubSection("orElse");
        System.out.println(optional1.orElse("empty text"));
        System.out.println(optional2.orElse("empty text"));

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. OptionalDouble");

        OptionalDouble optional = OptionalDouble.of(100.0);
        OptionalDouble optional1 = OptionalDouble.empty();

        System.out.println(optional);
        System.out.println(optional1);

        System.out.println("optional.getAsDouble() = " + optional.getAsDouble());
        System.out.println("optional1.getAsDouble() = " + optional1.orElse(0.0));

        printSectionEnding();
    }
}































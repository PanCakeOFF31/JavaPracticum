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

//        Random
//        program_5();

//        Timer and TimerTask
//        program_6();

//        Currency
//        program_7();

//        Formatter
        program_8();

//        Scanner
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

    private static void program_5() {
        printSection("Program_5. Random");

        Logger.printMessage("next methods");
        {
            Random random = new Random();

            System.out.println("random.nextBoolean() = " + random.nextBoolean());
            System.out.println("random.nextInt() = " + random.nextInt());
            System.out.println("random.nextLong() = " + random.nextLong());
            System.out.println("random.nextFloat() = " + random.nextFloat());
            System.out.println("random.nextDouble() = " + random.nextDouble());

            byte[] bytes = new byte[10];
            random.nextBytes(bytes);
            System.out.println(Arrays.toString(bytes));
        }

        Logger.printMessage("");
        {
            Random random = new Random();

            System.out.println(random.nextInt(100)); // [0;100)
            System.out.println(random.nextInt(0, 100)); // [0;100)
        }

        Logger.printMessage("random streams");
        {
            Random random = new Random();

            random.ints(5, -10, 10).forEach(System.out::println);
        }
        Logger.printMessage("random streams + collection");
        {
            List<Integer> ints = new ArrayList<>(new Random().ints(10, -100, 100).boxed().toList());
            System.out.println("ints = " + ints);
        }

        Logger.printMessage("Gaus");

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Timer");

        class MyTimer extends TimerTask {
            @Override
            public void run() {
                System.out.println("Таймер отработал");
            }
        }

        MyTimer task = new MyTimer();
        Timer timer = new Timer();
        timer.schedule(task, 0, 500);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.cancel();

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Currency");

        System.out.println(Currency.getAvailableCurrencies().size());

        Currency rubs = Currency.getInstance("RUB");
        System.out.println("rubs = " + rubs);

        Currency cads = Currency.getInstance(Locale.CANADA);
        System.out.println("cads = " + cads);

        Currency usds = Currency.getInstance("USD");
        System.out.println("usds = " + usds);

        Logger.printMessage("RUB");
        {
            System.out.println("rubs.getCurrencyCode() = " + rubs.getCurrencyCode());
            System.out.println("rubs.getDisplayName() = " + rubs.getDisplayName());
            System.out.println("rubs.getNumericCode() = " + rubs.getNumericCode());
            System.out.println("rubs.getSymbol() = " + rubs.getSymbol());
            System.out.println("rubs.getDefaultFractionDigits() = " + rubs.getDefaultFractionDigits());
        }

        Logger.printMessage("CAD");
        {
            System.out.println("cads.getCurrencyCode() = " + cads.getCurrencyCode());
            System.out.println("cads.getDisplayName() = " + cads.getDisplayName());
            System.out.println("cads.getNumericCode() = " + cads.getNumericCode());
            System.out.println("cads.getSymbol() = " + cads.getSymbol());
            System.out.println("cads.getDefaultFractionDigits() = " + cads.getDefaultFractionDigits());
        }

        Logger.printMessage("USD");
        {
            System.out.println("usds.getCurrencyCode() = " + usds.getCurrencyCode());
            System.out.println("usds.getDisplayName() = " + usds.getDisplayName());
            System.out.println("usds.getNumericCode() = " + usds.getNumericCode());
            System.out.println("usds.getSymbol() = " + usds.getSymbol());
            System.out.println("usds.getDefaultFractionDigits() = " + usds.getDefaultFractionDigits());
        }
        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Formatter");
        
        Logger.printMessage("");
        {
            StringBuilder builder = new StringBuilder(100);
            Formatter formatter = new Formatter(builder);

            formatter.format("maxim");
            System.out.println("builder = " + builder);
        }
        
        Logger.printMessage("");
        {
            Formatter formatter = new Formatter().format("%.5f", 10.0);
            System.out.println("formatter = " + formatter);

        }

        printSectionEnding();
    }
}































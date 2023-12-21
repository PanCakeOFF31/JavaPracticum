package yandexPracticum.webinars.webinar7;

import helpers.coloredString.Logger;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static helpers.Helpers.*;

public class Webinar7 {

    private static String maxim;

    public static void webinar7() {
        printArticle("Вебинар №7. Анонимные классы, лямбды, стримы");

//        lambda
//        program_1();

//        Stream
//        program_2();

//        Primitive stream
//        program_3();

//        Terminal operations
//        program_4();
//        Reduction
//        program_5();

//        Tests
        program_6();

//        program_7();
//        program_8();
//        program_9();

        printArticleEnding();
    }

    private static final Webinar7 webinar7 = new Webinar7();

    public void foo() {
        UnaryOperator<String> operator2 = (s -> {
//            Здесь будет this на экземпляр объемлющего класса - DeleteMeLater
            System.out.println(this);
            return s.toUpperCase();
        });

        System.out.println(operator2.apply("ivan"));

        UnaryOperator<String> operator1 = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
//                Здесь будет ссылка на экземпляр анонимного класса
                System.out.println("this = " + this);
                return s.toUpperCase();
            }
        };

        System.out.println(operator1.apply("maxim"));
    }

    private static void program_1() {
        printSection("Program_1. Разница между this");

        webinar7.foo();

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Stream");

        Logger.printMessage("Простые статические конструкторы");
        {
            Stream.of(10, 10.0, null, "wind")
                    .forEach(System.out::println);

            Stream.ofNullable(10.0)
                    .forEach(System.out::println);

            Stream.empty().forEach(System.out::println);
        }

        Logger.printMessage("Генератор, ограниченные limit");
        {
            Stream.generate(Math::random)
                    .map(n -> (int) (n * 10))
                    .limit(10)
                    .forEach(System.out::println);
        }

        Logger.printMessage("Stream.iterate()");
        {
            Stream.iterate(1, n -> ++n)
                    .limit(10)
                    .forEach(System.out::println);
        }

        Logger.printMessage("Stream.iterator() - вторая форма с предикатом");
        {
            Stream.iterate(10, n -> n < 100, n -> n += 10)
                    .forEach(System.out::println);
        }

        Logger.printMessage("Генераторы потоков примитивных типов");
        {
            Random random = new Random();

            IntStream ints = random.ints().limit(10);
            LongStream longs = random.longs().limit(10);
            DoubleStream doubles = random.doubles().limit(10);

            IntStream boundedInts = random.ints(100, 200).limit(10);

//            ints.forEach(System.out::println);
//            boundedInts.forEach(System.out::println);
        }

        Logger.printMessage("Потоковая строка");
        {
            String maxim = "maxim";
            maxim.chars().forEach(character -> System.out.println((char) character));
        }

        Logger.printMessage("Stream: flatMap()");
        {
            List<Integer> list1 = Stream.iterate(10, n -> n < 50, n -> n + 10).toList();
            List<Integer> list2 = Stream.iterate(100, n -> n < 150, n -> n + 10).toList();
            List<Integer> list3 = Stream.iterate(200, n -> n < 250, n -> n + 10).toList();

            List<List<Integer>> lists = new ArrayList<>(List.of(list1, list2, list3));
            List<List<Integer>> lists1 = new ArrayList<>(List.of(list1, list2, list3));
            List<List<Integer>> lists2 = new ArrayList<>(List.of(list1, list2, list3));

            List<List<List<Integer>>> superList = new ArrayList<>(List.of(lists, lists1, lists2));

            superList.stream()
                    .flatMap(sl -> sl.stream())
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);

            superList.stream()
                    .flatMap(Collection::stream)
                    .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                    .sorted()
                    .forEach(System.out::println);
        }
        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Primitive streams");

        int[] integers = IntStream.iterate(100, value -> value + 100).limit(10).toArray();

        Arrays.stream(integers).forEach(System.out::println);

        System.out.println("sum = " + Arrays.stream(integers).sum());
        System.out.println("sum = " + Arrays.stream(integers).average());
        System.out.println("sum = " + Arrays.stream(integers).summaryStatistics());

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Terminal operations");

        int[] integers = IntStream.iterate(100, value -> value + 100).limit(10).toArray();

        System.out.println(getStream(integers).findFirst().getAsInt());
        System.out.println(getStream(integers).count());


        printSectionEnding();
    }

    private static IntStream getStream(int[] ints) {
        return Arrays.stream(ints);
    }

    private static IntStream getInts() {
        return Arrays.stream(IntStream.iterate(100, value -> value + 100).limit(10).toArray());
    }

    private static void program_5() {
        printSection("Program_5. Reduction");

        getInts().forEach(n -> System.out.print(n + " "));
        System.out.println();

        getInts().reduce((accumulator, value) -> accumulator += value)
                .ifPresent(System.out::println);

        System.out.println(getInts().reduce(10000, (accumulator, value) -> accumulator += value));

//        System.out.println(getInts().boxed().
//                reduce(10000, (accumulator, value) -> accumulator += value, Integer::compareTo));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Tests");

        System.out.println("khjklhkj");

        printSectionEnding();
    }

}

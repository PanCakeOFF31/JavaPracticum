package gerbertShieldBook.chapter_30;

import gerbertShieldBook.chapter_14.auxiliaryClasses.IntegerGenericClass;
import helpers.coloredString.Logger;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

import static helpers.Helpers.*;

public class Chapter_30 {
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

    public static void chapter_30() {
        printArticle("Chapter_30. The Stream API");

//        The simple example from the book
//        program_1();

//        Reduction operations
//        program_2();

//        program_3();

//        Mapping
//        program_4();

//        Collection
//        program_5();

//        Primitive streams
//        program_6();

//        Map with strings
//        program_7();

//        Iterator
//        program_8();
//        Spliterator
//        program_9();

//        noneMatch(), allMatch(), anyMatch()
//        program_10();

//          of
//        program_11();
//        program_12();
//        program_13();
//        program_14();
//        program_15();
//        program_16();
//        program_17();
//        program_18();
//        program_19();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. The example from book");

        ArrayList<Integer> list = new ArrayList<>(List.of(7, 18, 10, 24, 17, 5));

        System.out.println("Original list: " + list);

        Stream<Integer> stream1 = list.stream();
        Optional<Integer> minValue = stream1.min(Integer::compareTo);
        minValue.ifPresent(n -> System.out.println("minValue = " + n));

        Stream<Integer> stream2 = list.stream();
        stream2.max(Integer::compareTo).ifPresent(n -> System.out.println("maxValue = " + n));

        System.out.print("Sorted list: [ ");
        list.stream().sorted().forEach(n -> System.out.print(n + " "));
        System.out.println("]");

        System.out.print("Sorted and filtered list: [ ");
        list.stream().sorted().filter(n -> n % 2 == 1).forEach(n -> System.out.print(n + " "));
        System.out.println("]");

        Logger.printMessage("Минимальный элемент с инвертированным компаратором - максимальный");
        var stream3 = list.stream();
        stream3.
                min(Comparator.<Integer>naturalOrder().reversed())
                .ifPresent(System.out::println);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Reduction Operations: count(), reduce()");

        Logger.printMessage("count()");
        {
            ArrayList<Integer> list = new ArrayList<>(List.of(7, 18, 10, 24, 17, 5));

            System.out.println("list = " + list);
            System.out.println("list.size() = " + list.size());

            long evenCount = list.stream().filter(n -> n % 2 == 0).count();
            System.out.println("evenCount = " + evenCount);

            long oddCount = list.size() - evenCount;
            System.out.println("oddCount = " + oddCount);
        }

        Logger.printMessage("reduce() - Version 1");
        {
            ArrayList<Integer> list = new ArrayList<>(List.of(7, 18, 10, 24, 17, 5));

            Optional<Integer> sum = list.stream().reduce(Integer::sum);
            System.out.println(sum.orElseThrow());
        }

        Logger.printMessage("reduce() - Version 2");
        {
            ArrayList<Integer> list = new ArrayList<>(List.of(7, 18, 10, 24, 17, 5));

            int sum = list.stream().reduce(100_000, Integer::sum);
            System.out.println(sum);
        }


        Logger.printMessage("reduce() - Version 3");
        {
            ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

            int sum = list.stream().reduce(1, (n1, n2) -> n1 * n2, Integer::sum);
            int sum1 = list.parallelStream().reduce(1, (n1, n2) -> n1 * n2, Integer::sum);
            System.out.println(sum);
            System.out.println(sum1);
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Functional test");

        var list1 = new ArrayList<Integer>(List.of(10, 5, 15, 20, 3, 4, 10, 17, 20, -10, -5, -1));
        list1.sort(Comparator.comparing((n1) -> n1));

        var list2 = new ArrayList<Integer>(List.of(10, 5, 15, 20, 3, 4, 10, 17, 20, -10, -5, -1));
        list2.sort(Integer::compareTo);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Mapping");

        var list = new ArrayList<>(List.of(10, 5, 15, 20, 3, 4, 10, 17, 20, -10, -5, -1));
        System.out.println("list = " + list);

        Stream<Double> stream = list.stream().map(n -> n * 1.5);

        var list1 = stream.toList();
        System.out.println("list1 = " + list1);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Collecting");

        var list = new ArrayList<>(List.of(10, 5, 15, 20, 3, 4, 10, 17, 20, -10, -5, -1));
        System.out.println("list = " + list);

        var set = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
        System.out.println("set = " + set);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Primitive streams");

        double[] doubles = {1.0, 2.0};
        long[] longs = {1L, 2L};
        int[] ints = {1, 2};

        DoubleStream stream1 = Arrays.stream(doubles);
        LongStream stream2 = Arrays.stream(longs);
        IntStream stream3 = Arrays.stream(ints);

        stream1.max().ifPresent(d -> System.out.println("Максимальный в DoubleStream = " + d));
        stream2.max().ifPresent(d -> System.out.println("Максимальный в LongStream = " + d));
        stream3.max().ifPresent(d -> System.out.println("Максимальный в IntStream = " + d));

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Map with strings");

        ArrayList<String> strings = new ArrayList<>() {{
            add("maxim");
            add("max");
            add("min");
            add("minim");
        }};

//        Удобный способ быстро отфильтровать с помощью регулярного выражения
        strings.stream().filter(str -> Pattern.matches("[mM].*", str)).forEach(System.out::println);

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Iterator<E>, iterator()");

        Logger.printMessage("Итератор в коллекции");
        {
            List<String> str = new ArrayList<>(Arrays.asList(strings));
            Iterator<String> iterator = str.iterator();
            int initialSize = str.size();

            for (int i = 0; i < initialSize - 3; i++) {
                iterator.next();
                iterator.remove();
            }

            Logger.printMessage("forEachRemaining()");
//        while (iterator.hasNext())
//            System.out.println(iterator.next());
            iterator.forEachRemaining(System.out::println);
        }

        Logger.printMessage("Итератор в stream");
        {
            List<String> str = new ArrayList<>(Arrays.asList(strings));
            str.stream()
                    .skip(str.size() - 3)
                    .iterator()
                    .forEachRemaining(System.out::println);
        }

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. Spliterator<E>, spliterator()");

        Logger.printMessage("Сплитератор в коллекции");
        {
            List<String> str = new ArrayList<>(Arrays.asList(strings));
            Spliterator<String> spliterator = str.spliterator();

            System.out.println("Исходный размер = " + spliterator.estimateSize());

            spliterator.tryAdvance(System.out::println);
            spliterator.tryAdvance(System.out::println);

            Logger.printMessage("Первая часть splitted spliterator");
            Spliterator<String> remainingPart = spliterator.trySplit();
            if (remainingPart != null)
                remainingPart.forEachRemaining(System.out::println);

            Logger.printMessage("Оставшаяся часть ");
            spliterator.forEachRemaining(System.out::println);
        }

        Logger.printMessage("Сплитератор в stream");
        {
            List<String> str = new ArrayList<>(Arrays.asList(strings));
            str.stream().spliterator().forEachRemaining(System.out::println);
        }

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. nonMatch");

        List<String> str = new ArrayList<>(Arrays.asList(strings));

        System.out.println(str.stream().anyMatch(s -> Pattern.matches("[aA].*", s)));
        System.out.println(str.stream().anyMatch(s -> Pattern.matches("[zZ].*", s)));
        System.out.println(str.stream().noneMatch(s -> Pattern.matches("[aA].*", s)));
        System.out.println(str.stream().noneMatch(s -> Pattern.matches("[zZ].*", s)));

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. of(), generate() ");

        Stream<Integer> intStream = Stream.of(10, 20, 30);
        intStream.max(Comparator.naturalOrder()).ifPresent(System.out::println);

        printSectionEnding();
    }
}

















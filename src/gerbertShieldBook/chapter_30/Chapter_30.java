package gerbertShieldBook.chapter_30;

import helpers.coloredString.Logger;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static helpers.Helpers.*;

public class Chapter_30 {
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
        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();
//        program_10();
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
}

















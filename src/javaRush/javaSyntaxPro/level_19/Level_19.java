package javaRush.javaSyntaxPro.level_19;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;
import yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.A.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Level_19 {
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

    private final static int[] ints = {-3, 32, 43, -9, 39, -34, 46, -26, -21, -3, -46, 48, 38, 23, 13, 2, -3, -40, 9, -14};
    private final static Integer[] integers = {-3, 32, 43, -9, 39, -34, 46, -26, -21, -3, -46, 48, 38, 23, 13, 2, -3, -40, 9, -14};

    private final static List<String> stringList = new ArrayList<>(Arrays.asList(strings));
    private final static List<Integer> intList = new ArrayList<>(Arrays.asList(integers));


    public static void level_19() {
        printSection("Level 19. Лямбда-выражений");

//        Comparator через анонимный класс
//        program_1();

//        Comparator через анонимный метод
//        program_2();

//                  Stream Interface java.util.stream.Stream
//        program_3();

//        Method References
//        program_4();

//        Stream: allMatch(), anyMatch(), filter()
//        program_5();

//        Stream: Stream.of(), Stream.concat(), Stream.generate()
        program_6();
//        program_7();
//        program_8();
//        program_9();


        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program 1. Lambda expressions: анонимный класс Comparator");

        String[] strs = new String[]{
                "abcdefg",
                "abcdef",
                "abcdef",
                "abdfed",
                "abcde",
                "abcd",
                "abc",
                "ab",
                "ab",
                "a"
        };

        LengthSorting comparator1 = new LengthSorting();

        Comparator<String> comparator2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };

        Arrays.sort(strs, comparator1);
        System.out.println(Arrays.toString(strs));

        Arrays.sort(strs, comparator2);
        System.out.println(Arrays.toString(strs));

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Lambda expressions: анонимный метод для Comparator");

        String[] strs = new String[]{
                "abcdefg",
                "abcdef",
                "abcdef",
                "abdfed",
                "abcde",
                "abcd",
                "abc",
                "ab",
                "ab",
                "a"
        };

        Comparator<String> comparator1 = (o1, o2) -> o1.length() - o2.length();
        Comparator<String> comparator2 = (o1, o2) -> o2.length() - o1.length();
        Comparator<String> comparator3 = Comparator.comparingInt(String::length);

        Arrays.sort(strs, comparator1);
        System.out.println(Arrays.toString(strs));

        Arrays.sort(strs, comparator2);
        System.out.println(Arrays.toString(strs));

        Arrays.sort(strs, comparator3);
        System.out.println(Arrays.toString(strs));

        Arrays.sort(strs, (o1, o2) -> (int) (Math.random() * 10 - Math.random() * 20));
        System.out.println(Arrays.toString(strs));

        printSectionEnding();
    }

    static class LengthSorting implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    private static void program_3() {
        printSection("Program_3. Stream - the simple example");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));

        Stream<String> stream1 = list.stream();
        System.out.println("stream1 = " + stream1);

        var set1 = list.stream()
                .filter(n -> n.length() <= 6)
                .filter(n -> Pattern.matches("[Aa].*", n))
                .collect(Collectors.toSet());

        System.out.println("set1 = " + set1);

        Logger.printMessage("Stream.of()");
        Stream<Integer> stream2 = Stream.of(10, 20, 30);
        System.out.println(stream2.collect(Collectors.toList()));


        Logger.printMessage("Stream.generate()");
        Stream<Double> stream3 = Stream.generate(Math::random);
        List<Double> list1 = stream3.limit(10).toList();
        System.out.println(list1);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Method References");
        class A {
            private int a;
            private boolean isInitialized;

            public A() {

            }

            public A(int a) {
                this.a = a;
                this.isInitialized = true;
            }

            public boolean isInitialized() {
                return isInitialized;
            }

            @Override
            public String toString() {
                return "A{a: " + a + ", isInitialized: " + isInitialized + "}";
            }
        }

        var list = new ArrayList<>(List.of(new A(), new A(), new A(10), new A(20)));

        Logger.printMessage("filteredList - через анонимный метод", Colors.RED);
        var filteredList1 = list.stream().filter(n -> n.isInitialized()).toList();
        System.out.println(filteredList1);

        Logger.printMessage("filteredList - через ссылку на метод экземпляра \n" +
                "произвольного объекта конкретного типа", Colors.BLUE);
        var filteredList2 = list.stream().filter(A::isInitialized).toList();
        System.out.println(filteredList2);

//        Logger.printMessage("filteredList - через ссылку на метод экземпляра");
//        A a1 = new A();
//        var filteredList3 = list.stream().filter(a1::isInitialized).toList();
//        System.out.println(filteredList3);
//
//        Logger.printMessage("filteredList - через ссылку на метод экземпляра", Colors.BLACK);
//        A a2 = new A();
//        var filteredList4 = list.stream().filter(a2::isInitializedPredicate).toList();
//        System.out.println(filteredList4);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Stream: allMatch(), anyMatch(), filter()");

        var list = new ArrayList<>(List.of(10,20,30));

        Logger.printMessage("Утверждение №1: все элементы списка больше нуля");
        System.out.println(intList);
        System.out.println(intList
                .stream().
                allMatch(n -> n > 0));

        Logger.printMessage("Утверждение №1: все элементы списка больше нуля");
        System.out.println(list);
        System.out.println(list.stream().allMatch(n -> n > 0));

        Logger.printMessage("Утверждение №2: хотя бы одно слово с длинной от 7 символов");
        System.out.println(stringList);
        System.out.println(stringList.stream().anyMatch(n -> n.length() > 6));
        System.out.println("Список этих слов:");
        System.out.println(stringList
                .stream()
                .filter(n -> n.length() > 6)
                .toList());

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Stream: Stream.of(), Stream.concat(), Stream.generate()");

        Stream<Integer> stream1 = Stream.of(10,20,30);

        printSectionEnding();
    }
}


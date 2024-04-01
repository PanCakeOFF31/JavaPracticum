package javaRush.javaSyntaxPro.level_19;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
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
//        program_6();


//        program_7();
//        program_8();
//        program_9();


        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program 1. Lambda expressions: анонимный класс Comparator");

        String[] strs = new String[]{
                "abcdefg",
                "abc",
                "abcdef",
                "abcde",
                "abcd",
                "ab",
                "abcdef",
                "ab",
                "a",
                "abdfed"
        };

//        Вложенный класс, который реализует компаратор
        Comparator<String> comparator1 = new LengthSorting();
//        Компаратор, через анонимный класс
        Comparator<String> comparator2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };

        Logger.printMessage("Исходный массив");
        System.out.println(Arrays.toString(strs));

        Logger.printMessage("Сортировка по количеству букв по возрастанию");
        Arrays.sort(strs, comparator1);
        System.out.println(Arrays.toString(strs));

        Logger.printMessage("Сортировка по количеству букв по убыванию");
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

    private static class LengthSorting implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    private static void program_3() {
        printSection("Program_3. Stream - the simple example");

        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));

        Stream<String> stream1 = list.stream();
        System.out.println("stream1:");
        stream1.forEach(System.out::println);

        var set1 = list.stream()
                .filter(n -> n.length() <= 6)
                .filter(n -> Pattern.matches("^[Aa].*", n))
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

        Logger.printMessage("Утверждение №1: все элементы списка больше нуля");
        System.out.println(intList);
        System.out.println(intList
                .stream().
                allMatch(n -> n > 0));

        var list = new ArrayList<>(List.of(10, 20, 30));
        Logger.printMessage("Утверждение №2: все элементы списка больше нуля");
        System.out.println(list);
        System.out.println(list.stream().allMatch(n -> n > 0));

        Logger.printMessage("Утверждение №3: хотя бы одно слово с длинной от 7 символов");
        System.out.println(stringList);
        System.out.println(stringList.stream().anyMatch(n -> n.length() > 6));
        System.out.println("Список этих слов:");
        System.out.println(stringList
                .stream()
                .filter(n -> n.length() > 6)
                .toList());

        Logger.printMessage("Утверждение №4: нет ни одного слова, длина которого больше 12");
        System.out.println(stringList);
        System.out.println(stringList.stream().noneMatch(n -> n.length() > 12));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Stream: Stream.of(), Stream.concat(), Stream.generate()");

        Stream<Integer> stream1 = Stream.of(10, 20, 30);

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Разница между Map и FlatMap при ::stream");

        Container container1 = new Container(new ArrayList<>(List.of(10, 20, 30)));
        Container container2 = new Container(new ArrayList<>(List.of(40, 45, 50)));
        Container container3 = new Container(new ArrayList<>(List.of(11, 22, 33)));

        List<Container> containers = List.of(container1, container2, container3);

        {
            var list = containers.stream()
                    .map(Container::getInts).toList();

            System.out.println(list.size());
            System.out.println(list);
        }

        {
            var list = containers.stream()
                    .map(Container::getInts)
                    .flatMap(Collection::stream)
                    .toList();

            System.out.println(list.size());
            System.out.println(list);
        }

        List<String> list = new ArrayList<String>();

        list.add("https://google.com");
        list.add("https://linkedin.com");
        list.add("https://yandex.com");

        Stream<URI> stream = list.stream().map(str -> {
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });

        stream.forEach(System.out::println);

        printSectionEnding();
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class Container {
        private ArrayList<Integer> ints;
    }
}


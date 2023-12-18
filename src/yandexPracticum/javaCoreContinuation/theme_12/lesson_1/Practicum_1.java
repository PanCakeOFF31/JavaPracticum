package yandexPracticum.javaCoreContinuation.theme_12.lesson_1;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_1 {
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

    public static void practicum_1() {
        printSection("Practicum_1");

//        The simple example, V1
//        program_1();

//        Capturing Variable
//        program_2();

//        The method reference
//        program_3();

//        program_4();

//        The simple example, V2
//        program_5();

//        Returning a function
//        program_6();

//        Annotation - @FunctionalInterface
//        program_7();

//        Stream: peek()
//        program_8();

//        Optional: orElseThrow()
//        program_9();
        
        program_10();

        
        

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. The Simple Example version 1");

        List<String> paths = new ArrayList<>();

        paths.add("/home/bigbrother/docs/hide.txt");
        paths.add("hide.txt");
        paths.add("file3.tmp");
        paths.add("/home/bigbrother/downloads/movie.mp4");
        paths.add("/home/bigbrother/downloads/java_book.pdf");

        System.out.println(paths.stream().map(path -> Paths.get(path).getFileName().toString()).toList());

        List<String> files = paths.stream()
                .filter(path -> !path.endsWith(".tmp"))
                .map(path -> Paths.get(path).getFileName().toString())
                .map(fileName -> {
                    if (fileName.startsWith("hide")) return "very_secret_file";
                    else return fileName;
                }).toList();

        System.out.println(files);


        printSectionEnding();
    }

    interface Capturing {
        void capture();
    }

    private static void program_2() {
        printSection("Program_2. Capturing Variable ");

        String myName = "PanCakeOFF";
        Capturing capturing = () -> System.out.println(myName);

        printLambda(capturing);

        String otherName = "Maxim";
        Capturing capturing1 = () -> System.out.println(otherName);

        printLambda(capturing1);
//        otherName = "max";

        printSectionEnding();
    }

    //    Метод просто инициирует выполнение переданного анонимного-метода
//    Лямбда выводит на экран значение переменной, определенной вне границ лямбды
    private static void printLambda(Capturing c) {
        c.capture();
    }

    private static void program_3() {
        printSection("Program_3. The Method reference");

        class Candy {
            final String name;
            final int price;

            public Candy(String name, int price) {
                this.name = name;
                this.price = price;
            }

            static int compareByName(Candy a1, Candy a2) {
                return a1.name.compareTo(a2.name);
            }

            static int compareByPrice(Candy a1, Candy a2) {
                return a1.price - a2.price;
            }

            void printInfo() {
                System.out.println(this.name + ":" + this.price);
            }

            void printInfo(Candy candy) {
                System.out.println(candy.name + ":" + candy.price);
            }

            @Override
            public String toString() {
                return this.name + ":" + this.price;
            }

            void derimo1() {
                System.out.println("Этот метод применяется к каждому элементу");
            }

            static void derimo2(Candy candy) {
                System.out.println("Этот метод используется как ссылка");
            }
        }

        List<Candy> list = new ArrayList<>(List.of(new Candy("candy 1", 10), new Candy("candy 2", 30),
                new Candy("candy 3", 30), new Candy("candy 4", 5), new Candy("candy 6", 15)));

        Logger.printMessage("Ссылка на метод экземпляра произвольного объекта конкретного класса");
        list.stream().sorted(Candy::compareByName).forEach(Candy::printInfo);

        Logger.printMessage("Ссылка на метод экземпляра");
        list.stream().sorted(Candy::compareByName).forEach(new Candy("", 0)::printInfo);

        Logger.printMessage("Ссылка на метод экземпляра");
        list.stream().sorted(Candy::compareByPrice).forEach(System.out::println);

        Logger.printMessage("derimo()", Colors.RED);
        list.stream().forEach(Candy::derimo1);

        Logger.printMessage("derimo(Candy candy)", Colors.RED);
        list.stream().forEach(Candy::derimo2);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Optional");

        Optional<String> optional1 = Optional.ofNullable(null);
        System.out.println("optional1 = " + optional1);
        System.out.println(optional1.orElse("Пустой optional"));

        optional1.ifPresentOrElse((str -> System.out.println("Внутри лежит - " + str)),
                () -> System.out.println("Внутри ничего нет"));

        Optional<String> optional2 = Optional.of("PanCakeOFf");
        optional2.ifPresentOrElse((str -> System.out.println("Внутри лежит - " + str)),
                () -> System.out.println("Внутри ничего нет"));

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. The simple example, version 2");

        List<String> paths = new ArrayList<>();

        paths.add("/home/bigbrother/docs/hide.txt");
        paths.add("hide.txt");
        paths.add("file3.tmp");
        paths.add("/home/bigbrother/downloads/movie.mp4");
        paths.add("/home/bigbrother/downloads/java_book.pdf");

        System.out.println(paths.stream().map(path -> Paths.get(path).getFileName().toString()).toList());

//        Отфильтровать по расширению
        Predicate<String> filter = path -> !path.endsWith(".tmp");
//        Трансформировать в названия файлов
        Function<String, String> map1 = path -> Paths.get(path).getFileName().toString();
//        Переименовать секретные файлы
        Function<String, String> map2 = fileName -> {
            if (fileName.startsWith("hide")) return "very_secret_file";
            else return fileName;
        };

        paths.stream()
                .filter(filter)
                .map(map1)
                .map(map2)
                .toList()
                .forEach(System.out::println);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Returning lambda-expression from method");

        String sign = "*";
        int result1 = getOperation(sign).applyAsInt(10, 15);
        System.out.println("result1 = " + result1);

        sign = "+";
        int result2 = getOperation(sign).applyAsInt(10, 15);
        System.out.println("result2 = " + result2);

        printSectionEnding();
    }

    private static IntBinaryOperator getOperation(String sign) {
        switch (sign) {
            case "+":
                return (value1, value2) -> value1 + value2;
            case "-":
                return (value1, value2) -> value1 - value2;
            case "*":
                return (value1, value2) -> value1 * value2;
            case "/":
                return (value1, value2) -> value1 / value2;
            default:
                throw new IllegalArgumentException("Неизвестная операция");
        }
    }

    private static void program_7() {
        printSection("Program_7. Annotation");

        @FunctionalInterface
        interface Function {
            void execute();
//            void execute1();
        }

        Function function = () -> System.out.println("Hi");
        function.execute();
        function.execute();

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Stream: peek()");

        System.out.println("stringList = " + stringList);

        stringList.stream()
                .peek(System.out::println)
                .collect(Collectors.toList());


        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. Optional: orElseThrow()");

        Optional<String> optional = Optional.of("maxim");
        Optional<String> optional1 = Optional.empty();

        optional.orElseThrow();
        optional1.orElseThrow(ArithmeticException::new);
//        optional1.orElseThrow();

        printSectionEnding();
    }
    
    private static void program_10() {
        printSection("Program_10. ");
    
        
                
        printSectionEnding();
    }
}



























































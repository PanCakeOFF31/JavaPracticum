package yandexPracticum.javaCoreContinuation.theme_12.lesson_1;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

//        program_1();
//        Capturing Variable
//        program_2();

//        The method reference
//        program_3();

        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. The Simple Example");

        List<String> paths = new ArrayList<>();

        paths.add("/home/bigbrother/docs/hide.txt");
        paths.add("hide.txt");
        paths.add("file3.tmp");
        paths.add("/home/bigbrother/downloads/movie.mp4");
        paths.add("/home/bigbrother/downloads/java_book.pdf");

        System.out.println(paths.stream().map(path -> Paths.get(path).getFileName().toString()).toList());

        List<String> files = paths.stream().filter(path -> !path.endsWith(".tmp")).map(path -> Paths.get(path).getFileName().toString()).map(fileName -> {
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

//        String otherName = "Maxim";
//        Capturing capturing1 = () -> System.out.println(otherName);
//
//        printLambda(capturing1);
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
        printSection("Program_5. ");

//        Comparator.
//                Optional.of(1).isPresent()
//        printSectionEnding();
    }
}



























































package freePractise.functional_interfaces;

import helpers.coloredString.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static helpers.Helpers.*;

public class Functions {
    public static void functions() {
        printArticle("Functional interfaces");

//        Function<T,R>
//        program_1();

//        UnaryOperator<T> extends Function<T,T>
//        program_2();

//        Разновидности функционального интерфейса, Function<R>, которые принимает примитивные типы
//        IntFunction<R>
//        program_3();
//        LongFunction
//        program_4();
//        DoubleFunction
//        program_5();

//        BiFunction
//        program_6();

//        BinaryOperator
//        program_7();

//        Некоторые разновидности функций, заточенные под примитивные типы
//        ToIntFunction<String>
//        program_8();
//        DoubleToIntFunction
//        program_9();

//        Consumer<T>
//        program_10();

//        Supplier<T>
//        program_11();

//        Predicate
//        program_12();

//        BiConsumer<T,U>
//        program_13();

//        BiPredicate<T,U>
//        program_14();

//        program_15();
//        program_16();
//        program_17();
//        program_18();

//        TripleFunction
//        program_19();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Function<T,R>");
//        Представляет собой функцию, которая принимает один аргумент - T и предоставляет результат - R
        Function<Integer, Double> function = Double::valueOf;

        Logger.printMessage("R apply(T t)");

        int value = 10;
        double result = function.apply(10);

        System.out.println("value = " + value);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. UnaryOperator<T>");
//        Представляет операцию над одним операндов, которая возвращает результат того же типа как и его операнд
//        Специализированная форма Function<T,R>
        UnaryOperator<String> unaryOperator = (n) -> n + " end.";

        Logger.printMessage("T apply(T t)");

        String original = "Original text";
        String result = unaryOperator.apply(original);

        System.out.println("original = " + original);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. IntFunction<R>");
//        Представляет функцию, которая принимает аргумент int-типа и предоставляет результат обобщенного типа - R

        IntFunction<Double> intFunction = (n) -> n / 3.0;

        Logger.printMessage("R apply(int t)");

        int value = 10;
        double result = intFunction.apply(value);

        System.out.println("value = " + value);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. LongFunction<R>");
//        Представляет функцию, которая принимает аргумент long-типа и предоставляет результат типа - R
        LongFunction<String> longFunction = String::valueOf;

        Logger.printMessage("R apply (long t)");

        long value = 1000;
        String result = longFunction.apply(value);

        System.out.println("value = " + value);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. DoubleFunction<R>");
//        Представляет функцию, которая принимает аргумент long-типа и предоставляет результат типа - R
        DoubleFunction<String> longFunction = String::valueOf;

        Logger.printMessage("R apply (double t)");

        double value = 1000.1516;
        String result = longFunction.apply(value);

        System.out.println("value = " + value);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. BiFunction<T,U,R>");
//        Представляет собой функцию, которая принимает два аргумента - T и U и предоставляет результат - R
        BiFunction<Integer, Double, String> biFunction = (n1, n2) -> String.valueOf(n1 + n2);

        Logger.printMessage("R apply(T t, U u)");

        int value1 = 10;
        double value2 = 30.5;
        String result = biFunction.apply(value1, value2);

        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. BinaryOperator<T>");
//        Представляет операцию над двумя операнда того же типа,
//        которая возвращает результат того же типа как типы у операндов.
//        Специализированная форма BiFunction<T,U,R>
        BinaryOperator<String> binaryOperator = (n1, n2) -> n1.concat(n2) + ". The end of raw.";

        Logger.printMessage("T apply(T t, T u)");

        String original1 = "Original text - 1.";
        String original2 = " Original text - 2";
        String result = binaryOperator.apply(original1, original2);

        System.out.println("original1 = " + original1);
        System.out.println("original2 = " + original2);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. ToIntFunction<T>");
//        Представляет функцию, которая принимает один аргумент типа - T и возвращает результат типа int
        ToIntFunction<String> toIntFunction = Integer::valueOf;

        Logger.printMessage("int applyAsInt(T value)");

        String original = "155";
        int result = toIntFunction.applyAsInt(original);

        System.out.println("original = " + original);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. DoubleToIntFunction");
//        Специализированная форма для примитивного типа
        DoubleToIntFunction function = n -> (int) Math.ceil(n);

        Logger.printMessage("int applyAsInt(double value) ");

        double value = 100.000001;
        int result = function.applyAsInt(value);

        System.out.println("value = " + value);
        System.out.println("result = " + result);

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. Consumer<T>");
//          Операция, которая принимает один аргумент и не возвращает никакого результат
        Consumer<List<Integer>> consumer = n -> n.set(1, 150);

        Logger.printMessage("void accept(T t)");

        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
        System.out.println("list = " + list);

        consumer.accept(list);
        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Supplier<T>");
//          Представляет собой поставщика данных. Ничего не принимает, но что-то возвращает
        Supplier<Integer> supplier = () -> 10;

        Logger.printMessage("T get()");

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(supplier.get());
        }

        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. Predicate<T>");
//          Представляет утверждение на основе одного аргумента, возвращает булево значение
        Predicate<Integer> predicate = n -> n > 10;

        Logger.printMessage("boolean test(T t)");

        List<Integer> list = new ArrayList<>(List.of(0, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50));
        System.out.println("list = " + list);

        for (Integer integer : list) {
            if (predicate.test(integer))
                System.out.println(integer);
        }

        printSectionEnding();
    }

    private static void program_13() {
        printSection("Program_13. BiConsumer");
//         Операция над двумя аргумента без возвращаемого значения
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        BiConsumer<Integer, List<Integer>> copy = (n1, n2) -> n2.add(n1);

        Logger.printMessage("void accept(T t, U u)");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            consumer.accept(list, Integer.valueOf(i * 10));
        }

        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void program_14() {
        printSection("Program_14. BiPredicate");
//        Представляет утверждение на основе двух аргументов, возвращает булево значение
        BiPredicate<Integer, Double> predicate = (n1, n2) -> n1 == Math.ceil(n2);

        Logger.printMessage("boolean test(T t, U u)");

        System.out.println(predicate.test(11, 10.0001));

        printSectionEnding();
    }

    private static void program_19() {
        printSection("Program_19. TripleFunction<T t, U u, P p>");

        interface TripleFunction<T, U, P, R> {
            R apply(T t, U u, P p);
        }

        int a = 10;
        char c = 'Я';
        double d = 44.5;

        TripleFunction<Integer, Character, Double, Double> function =
                (n1, n2, n3) -> n1 + n2 + n3;

        System.out.println(function.apply(a, c, d));

        printSectionEnding();
    }
}






































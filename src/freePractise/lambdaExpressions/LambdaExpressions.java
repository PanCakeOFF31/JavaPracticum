package freePractise.lambdaExpressions;

import freePractise.logger_coloredString.Colors;
import freePractise.logger_coloredString.Logger;

import static helpers.Helpers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.*;

public class LambdaExpressions {
    public static void lambdaExpressions() {
        printArticle("LambdaExpressions");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
        program_6();
        program_7();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Supplier<T>, Predicate<T>");

//        Supplier - снабженец
        Supplier<Integer> supplier = () -> 50;

        System.out.println(supplier.get());

//        Predicate - логическое утверждение
        Predicate<Integer> divideByTen = (n) -> n % 10 == 0;
        Predicate<Integer> divideByFive = n -> n % 5 == 0;

        ArrayList<Integer> list = new ArrayList<>() {{
            add(10);
            add(15);
            add(20);
            add(25);
            add(30);
            add(35);
        }};

        System.out.println("list = " + list);

        ArrayList<Integer> copy = new ArrayList<>(list);
        copy.removeIf(divideByTen);
        System.out.println("copy = " + copy);

        copy = new ArrayList<>(list);
        copy.removeIf(n -> n % 10 == 0);
        System.out.println("copy = " + copy);

//        copy = new ArrayList<>(list);
//        copy.removeIf(divideByFive);
//        System.out.println("copy = " + copy);

        copy = new ArrayList<>(list);
        copy.removeIf(divideByTen.negate());
        System.out.println("copy = " + copy);

//        copy = new ArrayList<>(list);
//        removeIfNot(copy,divideByTen);
//        System.out.println("copy = " + copy);

        printSectionEnding();
    }

    private static <T> void removeIfNot(ArrayList<T> list, Predicate<T> filter) {
        filter = filter.negate();

        for (int i = 0; i < list.size(); i++) {
            if (filter.test(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
    }

    private static void program_2() {
        printSection("Program_2. Iterator");

        ArrayList<Integer> list = new ArrayList<>() {{
            add(10);
            add(15);
            add(20);
            add(25);
            add(30);
            add(35);
        }};

        ArrayList<Integer> copy = new ArrayList<>(list);
        System.out.println("copy = " + copy);

        Iterator<Integer> iterator = copy.iterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            iterator.remove();
            System.out.println("iterator.next() = " + temp);
        }

        System.out.println("copy = " + copy);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Function, UnaryOperator, BinaryOperator, Consumer");

        Integer a = 100;

        java.util.function.Function<Integer, Double> function = x -> x * 2.0;
        System.out.println(function.apply(a));

        UnaryOperator<Integer> operator = n -> n * 2;
        System.out.println(operator.apply(a));

        BinaryOperator<Integer> operator1 = (j, k) -> j * k;
        System.out.println(operator1.apply(10, 20));

        Consumer<Integer> consumer = z -> System.out.println(2 * z);
        consumer.accept(a);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Static method references");

        ArrayList<Integer> list = new ArrayList<>() {{
            add(10);
            add(15);
            add(20);
            add(25);
            add(30);
            add(35);
        }};

        stringOperation(System.out::println, "asdasd");
        list.forEach(System.out::println);

        ArrayList<Integer> copy = new ArrayList<>();
        list.forEach(n -> copy.add(n));
        copy.forEach(System.out::println);

        printSectionEnding();
    }

    private static void stringOperation(Consumer<String> consumer, String str) {
        consumer.accept(str);
    }

    private static void program_5() {
        printSection("Program_5. Non static method references");

        Test<Integer> test = new Test<>();

        ArrayList<Integer> list = new ArrayList<>() {{
            add(10);
            add(15);
            add(20);
            add(25);
            add(30);
            add(35);
        }};

        list.forEach(test::testfoo);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Constructor references");

        Logger.printMessage("Сигнатуры абстрактного метода, конструктора и класса совпадают", Colors.CYAN);
        MyFunctionInterface getNewObject;

        printSubSection("Ссылка на конструктор");
        getNewObject = MyClass::new;

        MyClass obj1 = getNewObject.execute(400);
        MyClass obj2 = getNewObject.execute(500);

        System.out.println("obj1 = " + obj1);
        System.out.println("obj2 = " + obj2);

        printSubSection("Ссылка на метод, который возвращает новый объект");
        getNewObject = obj1::createMyClass;

        MyClass obj3 = getNewObject.execute(2500);
        MyClass obj4 = getNewObject.execute(3500);

        System.out.println("obj3 = " + obj3);
        System.out.println("obj4 = " + obj4);

        printSubSection("Использую интерфейс Function из java.util.function.Function");
        Function<Integer, MyClass> getMyClassObject;
        getMyClassObject = MyClass::new;

        MyClass obj5 = getMyClassObject.apply(777);
        System.out.println("obj5 = " + obj5);

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. lambda + list: replaceAll(), removeIf(), forEach()");
        Logger.printMessage("Все методы с functional interface", Colors.PURPLE);

        ArrayList<Integer> list = new ArrayList<>() {{
            add(15);
            add(35);
            add(25);
            add(10);
            add(30);
            add(20);
        }};

        System.out.println("list = " + list);
        list.replaceAll(n -> n * 100);
        list.removeIf(n -> n > 3000);
        list.forEach(System.out::println);

        Collections.sort(list);
        System.out.println("list = " + list);

        printSectionEnding();
    }
}

class ReverseMyClassList implements Comparator<MyClass> {
    @Override
    public int compare(MyClass o1, MyClass o2) {
        return -1 * (o1.compareTo(o2));
    }
}

class Test<T> {
    //    Данный метод совместим с абстрактным методом в интерфейсе Consumer<T>
    public void testfoo(T t) {
        System.out.println(t);
    }
}

@FunctionalInterface
interface MyFunctionInterface {
    MyClass execute(int value);
}

class MyClass implements Comparable<MyClass> {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public MyClass createMyClass(int value) {
        return new MyClass(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(MyClass o) {
        return this.value - o.value;
    }

    public int getValue() {
        return value;
    }
}























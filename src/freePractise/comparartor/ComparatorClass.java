package freePractise.comparartor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static helpers.Helpers.*;

public class ComparatorClass {
    public static void comparatorClass() {
        printArticle("Comparator Class");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        Comparator<MyClass> reverseIntegerList = new Comparator<>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return -1 * (o1.compareTo(o2));
            }
        };

        ArrayList<MyClass> tempList = new ArrayList<>() {{
            add(new MyClass(10));
            add(new MyClass(40));
            add(new MyClass(20));
            add(new MyClass(5));
            add(new MyClass(25));
            add(new MyClass(70));
        }};

        System.out.println("Перемешанный список");
        Collections.shuffle(tempList);
        System.out.println("tempList = " + tempList);

        System.out.println("Сортированный по возрастанию - по умолчанию");
        Collections.sort(tempList);
        System.out.println("tempList = " + tempList);

        System.out.println("Обратная сортировка через экземпляр класса");
        tempList.sort(new ReverseMyClassList());
        System.out.println("tempList = " + tempList);

        Collections.shuffle(tempList);

        System.out.println("Обратная сортировка через экземпляр анонимного класса");
        tempList.sort(reverseIntegerList);
        System.out.println("tempList = " + tempList);

        printSectionEnding();
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

class ReverseMyClassList implements Comparator<MyClass> {
    @Override
    public int compare(MyClass o1, MyClass o2) {
        return -1 * (o1.compareTo(o2));
    }
}

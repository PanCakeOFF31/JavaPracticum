package freePractise.comparartor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static helpers.Helpers.*;

public class ComparatorClass {
    public static void comparatorClass() {
        printArticle("Comparator Class");

        program_1();
        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. anonymous Comparator, class extends Comparator");

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

    private static void program_2() {
        printSection("Program_2. reversedComparator, lambda Comparator");

        ArrayList<Integer> list = new ArrayList<>() {{
            this.add(15);
            this.add(5);
            this.add(30);
            this.add(35);
        }};


        Comparator<Integer> directSort = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> reverseSort = directSort.reversed();

        Comparator<Integer> lambdaSort = (o1, o2) -> o1 - o2;

        Collections.shuffle(list);
        list.sort(directSort);
        System.out.println("list = " + list);

        Collections.shuffle(list);
        list.sort(reverseSort);
        System.out.println("list = " + list);

        Collections.shuffle(list);
        list.sort(lambdaSort);
        System.out.println("list = " + list);


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

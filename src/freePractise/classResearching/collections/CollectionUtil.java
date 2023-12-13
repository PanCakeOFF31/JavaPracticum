package freePractise.classResearching.collections;

import freePractise.logger_coloredString.Colors;
import freePractise.logger_coloredString.Logger;

import java.util.*;
import java.util.function.UnaryOperator;

import static helpers.Helpers.*;

public class CollectionUtil {
    public static void collectionUtil() {
        program_1();
        program_2();
        program_3();
    }

    private static void program_1() {
        printSection("Program_1. ");

        ArrayList<MyClass> list = new ArrayList<>() {{
            add(new MyClass(10));
            add(new MyClass(30));
            add(new MyClass(20));
            add(new MyClass(50));
            add(new MyClass(70));
            add(new MyClass(11));
            add(new MyClass(33));
            add(new MyClass(22));
        }};

        Logger.printMessage("Исходный list");
        System.out.println("list = " + list);

        ArrayList<MyClass> list1 = new ArrayList<>() {{
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
            add(new MyClass(0));
        }};

        Logger.printMessage("Исходный list1");
        System.out.println("list1 = " + list1);

        Logger.printMessage("list1 после копирования");
        Collections.copy(list1, list);
        System.out.println("list1 = " + list1);

        Logger.printMessage("Списки после изменения list");
        list.set(0, new MyClass(999));
        list.get(1).setValue(555);
        System.out.println("list = " + list);
        System.out.println("list1 = " + list1);


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. ");


        Logger.printMessage("Использование ссылки на конструктор:", Colors.BLUE);

        ArrayList<MyClass> list = new ArrayList<>() {{
            add(new MyClass(10));
            add(new MyClass(30));
            add(new MyClass(20));
            add(new MyClass(50));
            add(new MyClass(70));
            add(new MyClass(11));
            add(new MyClass(33));
            add(new MyClass(22));
        }};

        Logger.printMessage("Исходный list");
        System.out.println("list = " + list);

        ArrayList<MyClass> list1 = new ArrayList<>(deepListCopy(list, MyClass::new));
        Logger.printMessage("Исходный list1");
        System.out.println("list1 = " + list1);

        list.get(0).setValue(999);
        list.set(1, new MyClass(555));

        Logger.printMessage("Списки после изменения элементов только в list");
        System.out.println("list = " + list);
        System.out.println("list1 = " + list1);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. ");
        Logger.printMessage("Использование ссылки на конструктор:", Colors.BLUE);

        Map<Integer, MyClass> map = new HashMap<>() {{
            put(1, new MyClass(10));
            put(2, new MyClass(20));
            put(3, new MyClass(5));
            put(4, new MyClass(100));
            put(5, new MyClass(3));
            put(6, new MyClass(77));
            put(7, new MyClass(44));
            put(8, new MyClass(55));
        }};

        Logger.printMessage("Исходная map");
        System.out.println("map = " + map);

        Map<Integer, MyClass> map1 = new HashMap<>(deepMapCopy(map, MyClass::new));
        Logger.printMessage("Исходный map1");
        System.out.println("map1 = " + map1);

        map.get(1).setValue(999);
        map.put(2, new MyClass(555));

        Logger.printMessage("Таблицы после изменения элементов только в map");
        System.out.println("map = " + map);
        System.out.println("map1 = " + map1);

        printSectionEnding();
    }

    private static <T> List<T> deepListCopy(List<T> list, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();

        for (T element : list) {
            newList.add(operator.apply(element));
        }

        return newList;
    }

    private static <K, V> Map<K, V> deepMapCopy(Map<K, V> map, UnaryOperator<V> operator) {
        Map<K, V> newMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = operator.apply(entry.getValue());
            newMap.put(key, value);
        }

        return newMap;
    }
}


class MyClass implements Comparable<MyClass> {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public MyClass createMyClass(int value) {
        return new MyClass(value);
    }

    public MyClass(MyClass obj) {
        this.value = obj.value;
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

    public void setValue(int value) {
        this.value = value;
    }
}


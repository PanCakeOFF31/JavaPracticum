package gerbertShieldBook.chapter_20;

import freePractise.logger_coloredString.ColoredString;
import freePractise.logger_coloredString.Colors;
import freePractise.logger_coloredString.Logger;

import java.util.*;
import java.util.function.Consumer;

import static helpers.Helpers.*;

public class Chapter_20 {
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

    public static void chapter_20() {
        printArticle("Chapter_20. java.util, The Collections Framework");

//        The Collection Interface
//        program_1();

//        The List Interface: unmodifiable list
//        program_2();
//        The List Interface: replaceAll()
//        program_3();

//        The Set Interface: add(), Set.copyOf()
//        program_4();

//        ArrayList
//        program_5();

//        LinkedList
//        program_6();

//        HashSet
//        program_7();

//        LinkedHashSet
//        program_8();

//        TreeSet
//        program_9();

//        SortedSet
//        program_10();

//        NavigableSet
//        program_11();

//        PriorityQueue
//        program_12();

//        EnumSet
//        program_13();

//        Iterator, ListIterator
//        program_14();

//        Spliterator
//        program_15();

//        program_16();
//        program_17();
//        program_18();

//        List versus Set in for-each methods
//        program_19();


//                  Working with Maps
//        Map
//        program_20();
//        program_20_1();
//        program_20_2();

//        HashMap
//        program_21();
//
//        LinkedHashMap
//        program_22();

//        Comparator
//        program_23();
//        program_23_1();

//        SortedMap
//        program_24();

//        NavigableMap
//        program_25();

//        Map.Entry
//        program_26();
//        program_27();

//        Test of arguments of type of the generic method
//        program_28();

//        Fast test
//        program_29();

//        The Collections Algorithm
//        program_30();

//        The Arrays
//        program_31();

//                  The Legacy Classes and Interfaces
        program_32();
//        program_33();
//        program_34();
//        program_35();



//        program_36();
//        program_37();
//        program_38();
//        program_39();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. The Collection Interface");

        List<String> list = new ArrayList<>() {{
            addAll(Arrays.asList(strings));
        }};

        System.out.println("list = " + list);

        String[] asList = list.toArray(new String[0]);

        System.out.println(Arrays.toString(asList));

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. The List Interface");

//        Unmodifiable list
        List<String> list = List.of(strings[0], strings[1]);

        try {
            list.add("other String variable");
        } catch (UnsupportedOperationException e) {
            System.out.println(e);
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. The List Interface: relpaceAll()");

        List<String> list = new ArrayList<>();

        list.add(strings[0]);
        list.add(strings[3]);
        list.add(strings[5]);

        System.out.println("list = " + list);

        list.replaceAll(n -> "Start" + n);

        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. The Set Interface: add(), Set.copyOf()");

        {
            Set<String> set = new HashSet<>();

            System.out.println(set.add(strings[0]));
            System.out.println(set.add(strings[1]));
//            Возвращает false, так как элемент уже существует, а множество не допускает дублирования
            System.out.println(set.add(strings[0]));

            System.out.println("set = " + set);
        }

        {
            List<String> list = new ArrayList<>() {{
                add(strings[0]);
                add(strings[1]);
                add(strings[2]);
                add(strings[3]);
                add(strings[0]);
                add(strings[3]);
            }};
            System.out.println("list.size() = " + list.size());
            System.out.println("list = " + list);

            Set<String> set = Set.copyOf(list);
            System.out.println("set.size() = " + set.size());
            System.out.println("set = " + set);
        }

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. The ArrayList ");

        List<String> list = new ArrayList<>() {{
            Collections.addAll(this, strings);
            add(strings[0]);
            add(strings[1]);
            add(strings[2]);
            add(strings[3]);
            add(strings[0]);
        }};
        System.out.println("list with " + list.size() + " elements:\n" + list);

        String[] copy = new String[0];
        copy = list.toArray(copy);
        System.out.println("array with " + copy.length + " elements:\n" + Arrays.toString(copy));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. The LinkedList");

        LinkedList<String> list = new LinkedList<>() {{
//            Collections.addAll(this, strings);
            add("it's added to the last");
            offer("it,s added to the last");
            addLast("it is added to the last of the list ");
            offerLast("it is offered to the last of the list");
            push("it's pushed in the start of the list");
        }};

        System.out.println("list with " + list.size() + " elements:\n" + list);

        System.out.println("list.element() = " + list.element());
        System.out.println("list.peek() = " + list.peek());
        System.out.println("list.get() = " + list.get(0));
        System.out.println("list.getFirst() = " + list.getFirst());
        System.out.println("list.peekFirst() = " + list.peekFirst());

        Logger.printMessage("Stack methods:");
        {
            LinkedList<String> list1 = new LinkedList<>();
            System.out.println("list1.peek() = " + list1.peek());
//            System.out.println("list1.getFirsts() = " + list1.getFirst());
//            System.out.println("list1.element() = " + list1.element());
            System.out.println("list1.poll() = " + list1.poll());
//            System.out.println("list1.remove() = " + list1.remove());
//            System.out.println("list1.pop() = " + list1.pop());
            System.out.println("list1.push() = ");
            list1.add(null);
        }

        printSectionEnding();
    }

    private record A(int a) implements Comparable<A> {

        @Override
        public boolean equals(final Object obj) {
            return Objects.equals(this.a, ((A) obj).a);
        }

        @Override
        public String toString() {
            return "{a: " + a + "}";
        }

        @Override
        public int compareTo(A o) {
            return this.a - o.a;
        }
    }

    private static void program_7() {
        printSection("Program_7. HashSet");

//        В качестве ключа используется сам объект - то, есть если объект-ключ существует, то другой идентичный объект
//        даст такой-же hashcode. HashSet в качестве значения Map использует один и тот же объект, чтобы
//        память не заполнять.

        HashSet<A> set = new HashSet<>();

        A a1 = new A(10);
        A a2 = new A(20);
        A a3 = new A(30);
        A a4 = new A(40);
        A a5 = new A(50);
        A a6 = new A(10);

        set.add(a1);
        set.add(a2);
        set.add(a5);
        set.add(a6);
        set.add(a3);
        set.add(a4);

        System.out.println("set = " + set);

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. LinkedHashSet");

        LinkedHashSet<A> set = new LinkedHashSet<>();

        A a1 = new A(10);
        A a2 = new A(20);
        A a3 = new A(30);
        A a4 = new A(40);
        A a5 = new A(50);
        A a6 = new A(10);

        set.add(a1);
        set.add(a2);
        set.add(a5);
        set.add(a6);
        set.add(a3);
        set.add(a4);

        System.out.println("set = " + set);

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. TreeMap");

        TreeSet<A> set = new TreeSet<>();

        A a1 = new A(10);
        A a2 = new A(20);
        A a3 = new A(30);
        A a4 = new A(40);
        A a5 = new A(50);
        A a6 = new A(10);

        set.add(a1);
        set.add(a2);
        set.add(a5);
        set.add(a6);
        set.add(a3);
        set.add(a4);

        System.out.println("set = " + set);

        printSectionEnding();
    }

    private record B(String name, int age) {

        @Override
        public String toString() {
            return "{name: \"" + ColoredString.of(name, Colors.BLACK) + "\", " +
                    "age: " + ColoredString.of(String.valueOf(age), Colors.CYAN) + "}";
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(this.name, ((B) obj).name) &&
                    Objects.equals(this.age, ((B) obj).age);
        }
    }

    private static void program_10() {
        printSection("Program_10. SortedSet");

        Comparator<B> ascending = (n1, n2) -> {
            int firstMemberDifference = String.CASE_INSENSITIVE_ORDER.compare(n1.name, n2.name);

            if (firstMemberDifference == 0)
                return n1.age - n2.age;

            return firstMemberDifference;
        };

        Comparator<B> descending = (n1, n2) -> {
            int firstMemberDifference = String.CASE_INSENSITIVE_ORDER.compare(n2.name, n1.name);

            if (firstMemberDifference == 0)
                return n2.age - n1.age;

            return firstMemberDifference;
        };

        SortedSet<B> set = new TreeSet<>(ascending);

        B b1 = new B("Angel", 20);
        B b2 = new B("Angel", 30);
        B b3 = new B("Angelle", 20);
        B b4 = new B("Angelle", 10);
        B b5 = new B("Maxim", 25);
        B b6 = new B("Alex", 45);
        B b7 = new B("Amelia", 35);
        B b8 = new B("Amelia", 35);
        B b9 = new B("Amelia", 25);
        B b10 = new B("Ruby", 25);
        B b11 = new B("Mia", 25);
        B b12 = new B("Lily", 25);

        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);
        set.add(b6);
        set.add(b7);
        set.add(b8);
        set.add(b9);
        set.add(b10);
        set.add(b11);
        set.add(b12);

        System.out.println(set);

        SortedSet<B> set1 = new TreeSet<>(descending);

        set1.addAll(set);

        System.out.println(set1);

//        System.out.println(descending.compare(new B("Slava", 10), new B("Sergey", 30)));

        Comparator<? super B> ascendingCopy = set.comparator();

        Logger.printMessage("headSet()");
//        Начиная с начала до элемента, который меньше чем toElement
        System.out.println(set.headSet(new B("G", 100)));

        Logger.printMessage("tailSet()");
//        От элемента fromElement, до всех, которые больше или равны
        System.out.println(set.tailSet(new B("G", 100)));

        System.out.println(set.subSet(new B("L", 0), new B("N", 0)));

        System.out.println(set.first());
        System.out.println(set.last());

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. NavigableSet");

        int[] ints = {9, 23, 1, 5, 7, -9, 10, 9, 12, 53, 96, 43, 4, -5, 3, 0, -45, -22, -17, 15};

        Comparator<Integer> ascending = (n1, n2) -> n1 - n2;
        Comparator<Integer> descensing = ascending.reversed();

        SortedSet<Integer> set = new TreeSet<>(ascending);
        SortedSet<Integer> set1 = new TreeSet<>(descensing);

        for (int number : ints) {
            set.add(number);
            set1.add(number);
        }

        Logger.printMessage("set, ascending");
//        SortedSet
        System.out.println("set = " + set);
        System.out.println("set.size() = " + set.size());
        System.out.println("set.headSet(0) = " + set.headSet(0));
        System.out.println("set.tailSet(0) = " + set.tailSet(0));
        System.out.println("set.subSet(0,9) = " + set.subSet(-9, 10));

        Logger.printMessage("setCopy");
        SortedSet<Integer> setCopy = new TreeSet<>(set);
        setCopy.removeAll(Set.of(96, 53));
        System.out.println("setCopy = " + setCopy);
        System.out.println("setCopy.size() = " + setCopy.size());

        setCopy.retainAll(Set.of(-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println("setCopy = " + setCopy);

        Logger.printMessage("set1,descending");
//        SortedSet
        System.out.println("set1 = " + set1);
        System.out.println("set.headSet(0) = " + set.headSet(0));
        System.out.println("set.tailSet(0) = " + set.tailSet(0));
        System.out.println("set.subSet() = " + set.subSet(-9, 10));

        Logger.printMessage("set2, ascending");
//        NavigableSet
        NavigableSet<Integer> set2 = new TreeSet<>(set);
        System.out.println("set2 = " + set2);
        System.out.println("set2.ceiling(5) = " + set2.ceiling(5));
        System.out.println("set2.higher(5) = " + set2.higher(5));
        System.out.println("set2.floor(4) = " + set2.floor(-5));
        System.out.println("set2.lower(4) = " + set2.lower(-5));
        System.out.println(set2.subSet(-5, false, +5, false));
        System.out.println(set2.subSet(-5, true, +5, true));

//        Logger.printMessage("set3,descending");
//        NavigableSet

        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. PriorityQueue");

        Comparator<Integer> ascending = (n1, n2) -> n1 - n2;
        Comparator<Integer> descensing = ascending.reversed();

        PriorityQueue<Integer> queue = new PriorityQueue<>(ascending) {{
            add(5);
            add(10);
            add(0);
            add(0);
            add(15);
            add(50);
            add(50);
            add(20);
            add(35);
            add(40);
            add(45);
            add(25);
            add(20);
            add(20);
            add(5);
            add(10);
        }};
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(descensing);


        System.out.println("queue = " + queue);
        System.out.println("queue.poll()() = " + queue.poll());
        System.out.println("queue.poll()() = " + queue.poll());
        System.out.println("queue.poll()() = " + queue.poll());

        queue1.addAll(queue);
        System.out.println("queue1 = " + queue1);
        System.out.println("queue1.poll() = " + queue1.poll());
        System.out.println("queue1.poll() = " + queue1.poll());
        System.out.println("queue1.poll() = " + queue1.poll());

        System.out.println(queue.remove(20));
        queue.removeAll(Set.of(20));

        for (Integer integer : queue) {
            System.out.println(integer);
        }

        printSectionEnding();
    }

    private static void program_13() {
        printSection("Program_13. EnumSet");


        printSectionEnding();
    }

    private static void program_14() {
        printSection("Program_14. Iterator, ListIterator");
        List<Integer> list = new ArrayList<>() {{
            addAll(List.of(100, 200, 300, 150, 250, 350, 50, 500));
        }};

        System.out.println("list = " + list);
//
//        Iterator<Integer> iterator = list.iterator();
//
//        System.out.print("[");
//        while (iterator.hasNext()) {
//            Integer element = iterator.next();
//            System.out.print(element + ", ");
//        }
//        System.out.println("\b\b]");

        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext() && listIterator.next() != null) ;

        System.out.print("listIterator: [");

        while (listIterator.hasPrevious()) {
            Integer element = listIterator.previous();
            listIterator.set(element * 2);
            System.out.print(element + ", ");
        }

        System.out.println("]");

        System.out.println("list = " + list);

        while (listIterator.hasNext()) {
            int index = listIterator.nextIndex();
            Integer element = listIterator.next();
            System.out.println("[" + index + "] " + element);
        }

        System.out.println("list = " + list);

//        remove()
        while (listIterator.hasPrevious()) {
            Integer element = listIterator.previous();
            if (element >= 800)
                listIterator.remove();
        }

        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void program_15() {
        printSection("Program_15. Spliterator");

        List<Integer> list = new ArrayList<>() {{
            addAll(List.of(100, 200, 300, 150, 250, 350, 50, 500));
        }};

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Consumer<Integer> copying = (Integer n) -> {
            if (n > 500)
                list1.add(n * 2);
            else
                list1.add(n * 3);
        };

        Consumer<Integer> copying100 = (Integer n) -> list2.add(n * 100);

        System.out.println("list = " + list);

        Spliterator<Integer> spliterator = list.spliterator();
        System.out.println("spliterator.estimateSize() = " + spliterator.estimateSize());

        Logger.printMessage("tryAdvance()");
        while (spliterator.tryAdvance(System.out::println)) ;

        Logger.printMessage("tryAdvance()");
        spliterator = list.spliterator();
        for (int i = 0; i < 4; i++) {
            spliterator.tryAdvance(System.out::println);
        }

        Logger.printMessage("forEachRemaining()");
        spliterator.forEachRemaining(System.out::println);

        spliterator = list.spliterator();
        spliterator.forEachRemaining(copying);
        System.out.println("list1 = " + list1);

        list.spliterator().forEachRemaining(copying100);
        System.out.println("list2 = " + list2);

        printSectionEnding();
    }

    private static void program_16() {
        printSection("Program_16. ");


        printSectionEnding();
    }

    private static void program_19() {
        printSection("Program_19. List/Set - time measuring");

        int size = 33_554_432; // 700MB //1450MB

        List<Integer> list1 = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list1.add(i);
        }

        Set<Integer> set1 = new HashSet<>(33_554_500, 1.0f);

        set1.addAll(list1);

        double result1 = 0;
        for (int i = 0; i < 10; i++) {
            long time1 = System.currentTimeMillis();

//            for (Integer integer : list1) {
//                int a;
//            }

            for (Integer integer : set1) {
                int a;
            }

            long time2 = System.currentTimeMillis();

            result1 += (time2 - time1);
            System.out.println("result1 = " + result1);
        }

        double result2 = 0;
        for (int i = 0; i < 10; i++) {
            long time1 = System.currentTimeMillis();

            for (Integer integer : set1) {
                int a;
            }

//            for (Integer integer : list1) {
//                int a;
//            }

            long time2 = System.currentTimeMillis();

            result2 += (time2 - time1);
            System.out.println("result2 = " + result2);
        }

        System.out.println(result1 / 10.0);
        System.out.println(result2 / 10.0);

//        try {
//            Thread.sleep(3_000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        printSectionEnding();
    }

    private static void program_20() {
        printSection("Program_20. The Map Interface");

//      Просто статические методы
        System.out.println("Unmodifiable map - " + Map.of(10, 20, 11, 20, 12, 20));
        System.out.println("Unmodifiable map - " + Map.ofEntries(Map.entry(10, 20), Map.entry(11, 30), Map.entry(12, 30)));

        Map<String, Double> rating = new HashMap<>();

        rating.put("Александр", 4.49);
        rating.put("Сергей", 3.01);
        rating.put("Дмитрий", 2.54);
        rating.put("Андрей", 2.43);
        rating.put("Алексей", 2.0);
        rating.put("Максим", 1.84);
        rating.put("Иван", 1.71);
        rating.put("Владимир", 1.49);
        rating.put("Евгений", 1.38);

        System.out.println("rating = " + rating);

        Logger.printMessage("Проверка на существование в коллекции");
        System.out.println("rating.containsKey(Integer.valueOf(100)) = " + rating.containsKey(Integer.valueOf(100)));
        System.out.println("rating.containsKey(\"Максим\") = " + rating.containsKey("Максим"));
        System.out.println("rating.containsValue(2.0) = " + rating.containsValue(2.0));

        Logger.printMessage("Имена, чьи рейтинги больше 2.5");
        rating.forEach((key, value) -> {
            if (value > 2.5)
                System.out.println(key + "=" + value);
        });

        Logger.printMessage("Увеличить значения рейтинга каждого ключа в 10 раз");
        rating.forEach((key, value) -> rating.compute(key, (key1, value1) -> value1 * 10));

        Logger.printMessage("");
        rating.computeIfPresent("Сергей", (key, value) -> 50.0);
        rating.computeIfAbsent("Ниглотай", key -> 999.0);

        System.out.println("rating = " + rating);

        printSectionEnding();
    }

    private static void program_20_1() {
        printSection("Program_20_1. The Map Interface");

        Map<String, Double> rating = new HashMap<>();

        System.out.println(rating.putIfAbsent("Александр", 4.49));
        System.out.println(rating.put("Сергей", 3.01));
        rating.putIfAbsent("Дмитрий", 2.54);
        rating.putIfAbsent("Андрей", 2.43);
        rating.putIfAbsent("Алексей", 2.0);
        rating.putIfAbsent("Максим", 1.84);
        rating.putIfAbsent("Иван", 1.71);
        rating.putIfAbsent("Владимир", 1.49);
        rating.putIfAbsent("Евгений", 1.38);

        Logger.printMessage("Исходная таблица");
        System.out.println(rating);
        System.out.println("rating.size() = " + rating.size());

        Logger.printMessage("Удаление Алексея:");
        System.out.println("rating.remove(\"Алексей\",5.0) = " + rating.remove("Алексей", 5.0));
        System.out.println("Алексей удален, у него было значения рейтинга = " + rating.remove("Алексей"));
        System.out.println(rating);

        Logger.printMessage("Замена по ключу: replace()");
        if (rating.containsKey("Дмитрий") && rating.containsValue(2.54))
            System.out.println(rating.replace("Дмитрий", 7.0));
        System.out.println(rating.replace("Владимир", 1.49, 6.13));
        System.out.println("rating = " + rating);

        Logger.printMessage("Выделение ключей, значений, записей");
        {
            Logger.printMessage("Множество ключей:", Colors.GREEN);
            rating.keySet().forEach(System.out::println);
            Logger.printMessage("Список значений:", Colors.GREEN);
            rating.values().forEach(System.out::println);
            Logger.printMessage("Множество записей:", Colors.GREEN);
            rating.entrySet().forEach(System.out::println);
        }

        Logger.printMessage("Замена через лямбда выражение - replaceAll()");
        rating.replaceAll((key, value) -> 0.0);
        System.out.println("rating = " + rating);

        printSectionEnding();
    }

    private static void program_20_2() {
        printSection("Program_20_2. The Map Interface, class without overriding methods");

        class A {
            int a;

            public A(int a) {
                this.a = a;
            }

            @Override
            public String toString() {
                return "{a: " + a + "}";
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }
        }

        record B(int b) {
            @Override
            public boolean equals(Object obj) {
                if (this == obj || !(obj instanceof B))
                    return false;

                return Objects.equals(this.b, ((B) obj).b);
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.b);
            }

            @Override
            public String toString() {
                return "{b: " + b + "}";
            }
        }

        HashMap<A, Integer> map = new HashMap<>();

        Logger.printMessage("Список объектов с hashCode() по умолчанию, идентичные объекты дают разный хещ");
        A a1 = new A(10);
        System.out.println("a1 = " + a1);
        System.out.println("a1.hashCode() = " + a1.hashCode());
        A a2 = new A(10);
        System.out.println("a2 = " + a2);
        System.out.println("a2.hashCode() = " + a2.hashCode());
        A a3 = new A(10);
        System.out.println("a3 = " + a3);
        System.out.println("a3.hashCode() = " + a3.hashCode());
        A a4 = new A(10);
        System.out.println("a4 = " + a4);
        System.out.println("a4.hashCode() = " + a4.hashCode());
        A a5 = a4;
        System.out.println("a5 = " + a5);
        System.out.println("a5.hashCode() = " + a5.hashCode());
        A a6 = new A(15);
        System.out.println("a6 = " + a6);
        System.out.println("a6.hashCode() = " + a6.hashCode());

//        Добавление новой записи
        map.putIfAbsent(a1, 10);
//        Добавление новой записи
        map.putIfAbsent(a2, 10);
//        Добавление новой записи
        map.putIfAbsent(a3, 10);
//        Добавление новой записи
        map.putIfAbsent(a4, 10);
//        Перезаписывание вышестоящей записи, так как хеш-код одинаковый, а super.equals(obj) сравнивает по ссылке
//        Перезапись завершится неудачей так как это один и тот же объект, вернется значение, которое пытались вставить
        System.out.println("map.putIfAbsent(a5,10) = " + map.putIfAbsent(a5, 10));
//        Добавление новой записи
        map.putIfAbsent(a6, 15);

        Logger.printMessage("Список записей, для которых не переопределяли equals()");
        map.entrySet().forEach(System.out::println);

        HashMap<B, Integer> map1 = new HashMap<>();

        Logger.printMessage("Список объектов с переопределенным hasCode()");
        B b1 = new B(10);
        System.out.println("b1 = " + b1);
        System.out.println("b1.hashCode() = " + b1.hashCode());
        B b2 = new B(10);
        System.out.println("b2 = " + b2);
        System.out.println("b2.hashCode() = " + b2.hashCode());
        B b3 = new B(15);
        System.out.println("b3 = " + b3);
        System.out.println("b3.hashCode() = " + b3.hashCode());
        B b4 = new B(10);
        System.out.println("b4 = " + b4);
        System.out.println("b4.hashCode() = " + b4.hashCode());
        B b5 = b4;
        System.out.println("b5 = " + b5);
        System.out.println("b5.hashCode() = " + b5.hashCode());
        B b6 = new B(10);
        System.out.println("b6 = " + b6);
        System.out.println("b6.hashCode() = " + b6.hashCode());

        Logger.printMessage("Список записей, для которых переопределены hashCode() и equals()");
        System.out.println("map1.putIfAbsent(b1,10) = " + map1.putIfAbsent(b1, 10));
        System.out.println("map1.putIfAbsent(b2,10) = " + map1.putIfAbsent(b2, 10));
        map1.putIfAbsent(b3, 10);
        map1.putIfAbsent(b4, 10);
        map1.putIfAbsent(b5, 10);
        map1.putIfAbsent(b6, 10);

        map1.entrySet().forEach(System.out::println);

        printSectionEnding();
    }

    private static void program_21() {
        printSection("Program_21. HashMap");


        printSectionEnding();
    }

    private static void program_22() {
        printSection("Program_22. LinkedHashMap");

        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();

        for (int i = 0; i < strings.length; i += 2) {
            map1.put(i, strings[i]);
        }

        map1.forEach((n1, n2) -> System.out.println(n1 + "=" + n2));


        printSectionEnding();
    }

    private static void program_23() {
        printSection("Program_23. Comparator via one implementation");

        Comparator<Integer> natural = Comparator.naturalOrder();
        Comparator<Integer> reversed = Comparator.reverseOrder();

        Comparator<String> nameSername = (str1, str2) -> {
            int i, j, c;

            i = str1.lastIndexOf(' ');
            j = str2.lastIndexOf(' ');

            c = str1.substring(i + 1).compareTo(str2.substring(j + 1));

            if (c == 0)
                return str1.substring(0, i).compareTo(str2.substring(0, j));
            else
                return c;
        };

        SortedSet<String> set = new TreeSet<>();

        set.add("Виктор Гудзонов");
        set.add("Виктор Алобаев");
        set.add("Анатолий Буланов");
        set.add("Анатолий Булгаков");
        set.add("Николай Улюбеков");

        Logger.printMessage("Естественная сортировка");
        set.forEach(System.out::println);

        SortedSet<String> set1 = new TreeSet<>(nameSername);
        set1.addAll(set);

        Logger.printMessage("Сортировка сначала по фамилии, затем по имени");
        set1.forEach(System.out::println);

        printSectionEnding();
    }

    private static void program_23_1() {
        printSection("Program_23_1. Comparator via thenComparing()");

        Comparator<String> surname = (str1, str2) -> {
            int i = str1.lastIndexOf(' ');
            int j = str2.lastIndexOf(' ');

            return str1.substring(i + 1).compareTo(str2.substring(j + 1));
        };

        Comparator<String> name = (str1, str2) -> {
            int i = str1.lastIndexOf(' ');
            int j = str2.lastIndexOf(' ');

            return str1.substring(0, i).compareTo(str2.substring(0, j));
        };

        Comparator<String> nameSurname = surname.thenComparing(name);

        SortedSet<String> set = new TreeSet<>(nameSurname);

        set.add("Виктор Гудзонов");
        set.add("Виктор Алобаев");
        set.add("Анатолий Буланов");
        set.add("Анатолий Булгаков");
        set.add("Николай Улюбеков");

        Logger.printMessage("Сортировка сначала по фамилии, затем по имени");
        set.forEach(System.out::println);

        printSectionEnding();
    }

    private static void program_24() {
        printSection("Program_24. SortedMap");

        SortedMap<Integer, String> map1 = new TreeMap<>();

        for (int i = 0; i < strings.length; i++) {
            map1.put(i, strings[i]);
        }

        map1.forEach((n1, n2) -> System.out.println(n1 + "=" + n2));

        Logger.printMessage("SortedMap interface methods");
        System.out.println("map1.headMap(5) = " + map1.headMap(5));
        System.out.println("map1.tailMap(10) = " + map1.tailMap(14));
        System.out.println("map1.subMap(7,11) = " + map1.subMap(7, 11));
        System.out.println("map1.firstKey() = " + map1.firstKey());
        System.out.println("map1.lastKey() = " + map1.lastKey());

        printSectionEnding();
    }

    private static void program_25() {
        printSection("Program_25. NavigableMap");

        NavigableMap<Integer, String> map1 = new TreeMap<>();

        for (int i = 0; i < strings.length; i++) {
            map1.put(i, strings[i]);
        }

        map1.forEach((n1, n2) -> System.out.println(n1 + "=" + n2));

        Logger.printMessage("SortedMap interface methods");
        System.out.println("map1.subMap(2,true,4,true) = " + map1.subMap(2, true, 4, true));

        System.out.println("map1.ceilingKey(3) = " + map1.ceilingKey(3));
        System.out.println("map1.ceilingEntry(3) = " + map1.ceilingEntry(3));

        System.out.println("map1.lowerKey(3) = " + map1.lowerKey(3));
        System.out.println("map1.lowerEntry(3) = " + map1.lowerEntry(3));

        System.out.println("map1.floorKey(3) = " + map1.floorKey(3));
        System.out.println("map1.floorEntry(3) = " + map1.floorEntry(3));
        System.out.println("map1.higherKey(3) = " + map1.higherKey(3));
        System.out.println("map1.higherEntry(3) = " + map1.higherEntry(3));

        System.out.println("map1.pollFirstEntry() = " + map1.pollFirstEntry());
        System.out.println("map1.pollLastEntry() = " + map1.pollLastEntry());

        map1.descendingMap().forEach((n1, n2) -> System.out.println(n1 + "=" + n2));

        printSectionEnding();
    }

    private static void program_26() {
        printSection("Program_26. Map.Entry");

        Map.Entry<Integer, String> entry1 = Map.entry(1, "create");
        Map.Entry<Integer, String> entry2 = Map.entry(2, "remove");
        Map.Entry<Integer, String> entry3 = Map.entry(1, "remove");
        Map.Entry<Integer, String> entry4 = Map.entry(2, "create");

        Map.Entry<Integer, String>[] entries = new Map.Entry[]{
                Map.entry(3, "compare"),
                Map.entry(4, "condition"),
                Map.entry(5, "less"),
                Map.entry(3, "greater"),
        };

        Logger.printMessage("Исходный список записей:");
        for (var entry : entries) {
            System.out.println(entry);
        }

        Logger.printMessage("Сравнение ключей:");
        System.out.println("Первая запись - " + entry1);
        System.out.println("Вторая запись - " + entry4);
        System.out.println("Сравнение ключей дает - " + entry1.getKey().equals(entry4.getKey()));
        System.out.println("Сравнение значений дает - " + entry1.getValue().equals(entry4.getValue()));
        System.out.println("entry1.equals(entry4) = " + entry1.equals(entry4));

//        Comparator<Map.Entry<Integer, String>> comparator1 = Map.Entry.comparingByKey();
//        Comparator<Map.Entry<Integer, String>> comparator2 = Map.Entry.comparingByValue();
        var comparator1 = Map.Entry.<Integer, String>comparingByKey();
        var comparator2 = Map.Entry.<Integer, String>comparingByValue();

        TreeSet<Map.Entry<Integer, String>> set1 = new TreeSet<>(comparator1);
        TreeSet<Map.Entry<Integer, String>> set2 = new TreeSet<>(comparator2);

        set1.add(entry1);
        set1.add(entry2);
        set1.add(entry3);
        set1.add(entry4);
        set1.add(entries[0]);
        set1.add(entries[1]);
        set1.add(entries[2]);
        set1.add(entries[3]);

        set2.add(entry1);
        set2.add(entry2);
        set2.add(entry3);
        set2.add(entry4);
        set2.add(entries[0]);
        set2.add(entries[1]);
        set2.add(entries[2]);
        set2.add(entries[3]);

        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);

        Queue<Map.Entry<Integer, String>> queue1 = new PriorityQueue<>(comparator1);
        Queue<Map.Entry<Integer, String>> queue2 = new PriorityQueue<>(comparator2);

        queue1.add(entry1);
        queue1.add(entry2);
        queue1.add(entry3);
        queue1.add(entry4);
        queue1.add(entries[0]);
        queue1.add(entries[1]);
        queue1.add(entries[2]);
        queue1.add(entries[3]);

        queue2.addAll(queue1);

        Logger.printMessage("queue1:");
        for (int i = 0; i < queue1.size(); ) {
            System.out.println(queue1.poll());
        }

        Logger.printMessage("queue2:");
        for (int i = 0; i < queue2.size(); ) {
            System.out.println(queue2.poll());
        }

        printSectionEnding();
    }

    private static void program_27() {
        printSection("Program_27. Generic madness");

        record A(int a) implements Comparable<A> {

            @Override
            public int compareTo(A o) {
                return this.a - o.a;
            }

            @Override
            public String toString() {
                return "A{a: " + a + "}";
            }
        }

        Logger.printMessage("Переменная с параметром типа", Colors.BLUE);
        Queue<A> queue1 = foo();

        queue1.add(new A(0));
        queue1.add(new A(10));
        queue1.add(new A(-10));

        System.out.println("queue1 = " + queue1);

        for (int i = 0; i < queue1.size(); ) {
            System.out.println(queue1.poll());
        }

        Logger.printMessage("Ключевое слово var", Colors.RED);
        var queue2 = foo();
//        queue2.add()

        var queue3 = Chapter_20.<A>foo();
        queue3.add(new A(0));

        System.out.println("queue2 = " + queue2);

        printSectionEnding();
    }

    private static <T extends Comparable<? super T>> Queue<T> foo() {
        return new PriorityQueue<T>();
    }

    private static void program_28() {
        printSection("Program_28. test");

        Double double1 = 100.0;
        var double2 = Chapter_20.<Integer>foo1(double1.intValue());

        System.out.println(double1);
        System.out.println(double2);

        printSectionEnding();
    }

    private static <T extends Number> T foo1(T obj) {
        return obj;
    }

    private static void program_29() {
        printSection("Program_29. Test");


        AA a1 = new AA();
        a1.signal();

        AA b1 = new BB();
        b1.signal();

        BB b2 = new BB();
        b2.signal();

        Chapter_20.enter(a1);
        Chapter_20.enter(b1);
        Chapter_20.enter(b2);

        printSectionEnding();
    }

    private static class AA {
        public void signal() {
            System.out.println("Я экземпляр AA");
        }
    }

    private static class BB extends AA {
        @Override
        public void signal() {
            System.out.println("Я экземпляр B");
        }
    }

    private static void enter(AA a) {
        System.out.println("Вызван метод для enter(A a)");
    }

    private static void enter(BB b) {
        System.out.println("Вызван метод для enter(B b)");
    }

    private static void program_30() {
        printSection("Program_30. The Collections Algorithm");

        printSubSection("Некоторые базовые методы");
        {
            List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 5, 15, 25, 35));

            Logger.printMessage("Исходный список - original list");
            list.forEach(System.out::println);

            Logger.printMessage("Развернутый список - reversed()");
            list.reversed().forEach(System.out::println);

            Logger.printMessage("Перемешанный список - shuffle()");
            Collections.shuffle(list);
            list.forEach(System.out::println);

            Logger.printMessage("Collections.max() and Collections.min()");
            System.out.println("Collections.max(list) = " + Collections.max(list));
            System.out.println("Collections.min(list) = " + Collections.min(list));
            System.out.println(Collections.max(list, Comparator.reverseOrder()));

            Logger.printMessage("Collections.rotate()");
            System.out.println("list = " + list);
            Collections.rotate(list, 4);
            System.out.println("list = " + list);

            Logger.printMessage("Collections.swap()");
            Collections.swap(list, 0, 7);
            System.out.println("list = " + list);
        }

//        Я не правильно предположил как работает метод
//        printSubSection("Collections.newSetFromMap()");
//        {
//            Map<String, Boolean> map1 = new HashMap<>() {{
//                put("Максим", false);
//                put("Толик-Еболик", true);
//                put("Михаил", true);
//                put("Арканзас", false);
//            }};
//
//            map1.forEach(Chapter_20::println);
//
//            var names = Collections.newSetFromMap(map1);
//
//            names.forEach(System.out::println);
//        }

        printSubSection("Еще дополнительные методы");
        {
//            disjoint(), indexOfSubList(), lastIndexOfSublist(), frequency()
            List<Integer> generalList = new ArrayList<>(List.of(5, 20, 30, 15, 25, 35, 10, 20, 30, 15, 25, 35));
            List<Integer> list1 = new ArrayList<>(List.of(10, 20, 30));
            List<Integer> list2 = new ArrayList<>(List.of(15, 25, 35));

            System.out.println("list1 = " + list1);
            System.out.println("list2 = " + list2);
            System.out.println("generalList = " + generalList);

            System.out.println("Collections.disjoint(list1,list2) = " + Collections.disjoint(list1, list2));
            System.out.println("Collections.disjoint(generalList,list1) = " + Collections.disjoint(generalList, list1));

            System.out.println("Collections.indexOfSubList(generalList, list1) = " + Collections.indexOfSubList(generalList, list1));
            System.out.println("Collections.frequency(generalList,20) = " + Collections.frequency(generalList, 20));
        }

        printSubSection("Binary search");
        {
            var list = new ArrayList<>(List.of(10, 15, 5, 60, 44, 33, 22, 11, 0, 5, 6, 7, 89, 23, 543, 262, 723, 7, 275));
            list.sort(Comparator.naturalOrder());

            System.out.println("list = " + list);
            System.out.println("Collections.binarySearch(list,89) = " + Collections.binarySearch(list, 89));
        }

        printSectionEnding();
    }

    public static <K, V> void println(K k, V v) {
        System.out.println(k + "=" + v);
    }

    private static void program_31() {
        printSection("Program_31. The Arrays Class");

        List<String> list = new ArrayList<>(Arrays.asList(strings));
        System.out.println(list);
        System.out.println(list.getClass());

        Logger.printMessage("Arrays.fill()");
        {
            int[] arr1 = new int[10];
            Arrays.fill(arr1, 55);
            System.out.println(Arrays.toString(arr1));
        }

        Logger.printMessage("Arrays.equals()");
        {
            int[] arr1 = {10, 15, 20};
            int[] arr2 = {10, 15, 25};
            int[] arr3 = {10, 15, 20};

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));

            System.out.println("Arrays.equals(arr1, arr2) = " + Arrays.equals(arr1, arr2));
            System.out.println("Arrays.equals(arr1,arr3) = " + Arrays.equals(arr1, arr3));
        }

        Logger.printMessage("Arrays.mismatch()");
        {
            int[] arr1 = {10, 15, 20, 30};
            int[] arr2 = {10, 15, 25, 20};

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            int mismatch = Arrays.mismatch(arr1, arr2);

            if (mismatch > -1) {
                System.out.println("Расхождение найдено по индексу - " + mismatch);
                System.out.println(arr1[mismatch]);
                System.out.println(arr2[mismatch]);
            } else
                System.out.println("Расхождений нет");

        }

        Logger.printMessage("Arrays.sort()/parallelSort()/binarySearch()");
        {
            int[] arr1 = {10, 15, 20, 30, 0, 5, 15, 7, 8, 44, 33, 22, 11};
            int[] arr2 = {10, 15, 20, 30, 0, 5, 15, 7, 8, 44, 33, 22, 11};

            Arrays.sort(arr1);
            Arrays.parallelSort(arr2);

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            System.out.println("Arrays.binarySearch(arr1) = " + Arrays.binarySearch(arr1, 15));
            System.out.println("Arrays.binarySearch(arr2) = " + Arrays.binarySearch(arr2, 15));

        }

        Logger.printMessage("Arrays.spliterator()");
        {
            int[] arr1 = new int[10];

            Spliterator.OfInt spliterator = Arrays.spliterator(arr1);
        }

        Logger.printMessage("Arrays.copyOfRange()");
        {
            int[] arr1 = {10, 15, 20, 30, 0, 5, 15, 7, 8, 44, 33, 22, 11};

            int[] copy = Arrays.copyOf(arr1, 5);
            System.out.println(Arrays.toString(copy));

            copy = Arrays.copyOf(arr1, 20);
            System.out.println(Arrays.toString(copy));
        }

        Logger.printMessage("Arrays.deepEquals()/equals()");
        {
            int[] arr1 = {10, 15, 20, 30};
            int[] arr2 = {10, 15, 25, 20};

            int[][] general_1 = {arr1, arr2};
            int[][] general_2 = {arr2, arr1};

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.deepToString(general_1));

            System.out.println(Arrays.deepEquals(general_1, general_2));
            System.out.println(Arrays.deepEquals(general_1, general_1));
        }

        Logger.printMessage("Arrays.setAll(), parallelPrefix()");
        {
            int[] arr1 = {10, 15, 20, 30, 40, 50, 60, 70, 80};
//            int[] arr2 = {10, 15, 25, 20};

            Arrays.setAll(arr1, n -> n * 2);
            System.out.println(Arrays.toString(arr1));

            Arrays.parallelPrefix(arr1, (n1, n2) -> n1 / 3 + n2);
            System.out.println(Arrays.toString(arr1));
        }

        Logger.printMessage("Arrays.compareUnsigned()");
        {
            int[] arr1 = {10, 15, 20, 30};
            int[] arr2 = {-10, -15, -20, 30};

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            System.out.println(Arrays.compareUnsigned(arr1, arr2));
        }

        printSectionEnding();
    }

    private static void program_32() {
        printSection("Program_32. The Legacy Classes and Interfaces: ");

//        ArrayList<Object> list = new ArrayList<>();

        printSectionEnding();
    }
}






































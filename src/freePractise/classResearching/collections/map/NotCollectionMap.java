package freePractise.classResearching.collections.map;

import freePractise.logger_coloredString.Colors;
import freePractise.logger_coloredString.Logger;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Random;

import static helpers.Helpers.*;

public class NotCollectionMap {
    public static void notCollectionMap() {
        printArticle("Maps");

//        HashMapStructure.hashMapStructure();

//        program_1;
//        program_2();
//        program_3();

//        program_10();
//        program_11();

        program_15();
        program_16();
        program_17();

        program_15();
        program_16();
        program_17();
    }

    /**
     * <ul>
     *     <li>HashMap - порядок следования не гарантирует</li>
     *     <li>LinkedHashMap - гарантирует порядок следования</li>
     *     <li>TreeMap - гарантирует, что таблица будет отсортирован по ключу</li>
     * </ul>
     */
    private static void program_1() {
        printSection("Program_1. HashMap, LinkedMap, TreeMap - общее сравнение");

        Logger.printMessage("HashMap");

        Map<Integer, String> map1 = new HashMap<>() {{
            put(1, "Some text #1");
            put(3, "Some text #3");
            put(7, "Some text #7");
            put(1, "Some text #1");
            put(5, "Some text #5");
            put(4, "Some text #4");
            put(1, "Some text #1");
            put(2, "Some text #2");
            put(10, "Some text #10");
            put(9, "Some text #9");
            put(17, "Some text #17");
            put(33, "Some text #33");
        }};

        System.out.println("map1.size() = " + map1.size());
        System.out.println("map1 = " + map1);
        printKeys(map1);

        Logger.printMessage("LinkedHashMap");

        Map<Integer, String> map2 = new LinkedHashMap<>() {{
            put(1, "Some text #1");
            put(3, "Some text #3");
            put(7, "Some text #7");
            put(1, "Some text #1");
            put(5, "Some text #5");
            put(4, "Some text #4");
            put(1, "Some text #1");
            put(2, "Some text #2");
            put(10, "Some text #10");
            put(9, "Some text #9");
            put(17, "Some text #17");
            put(33, "Some text #33");

        }};

        System.out.println("map2.size() = " + map2.size());
        System.out.println("map2 = " + map2);
        printKeys(map2);

        Logger.printMessage("TreeMap");

        Map<Integer, String> map3 = new TreeMap<>() {{
            put(1, "Some text #1");
            put(3, "Some text #3");
            put(7, "Some text #7");
            put(1, "Some text #1");
            put(5, "Some text #5");
            put(4, "Some text #4");
            put(1, "Some text #1");
            put(2, "Some text #2");
            put(10, "Some text #10");
            put(9, "Some text #9");
            put(17, "Some text #17");
            put(33, "Some text #33");

        }};

        System.out.println("map3.size() = " + map3.size());
        System.out.println("map3 = " + map3);
        printKeys(map3);

        printSectionEnding();
    }

    private static <K, V> void printKeys(Map<K, V> map) {
        System.out.println("size - " + map.size());
        int h;
        for (K k : map.keySet()) {
            int hash = (h = k.hashCode()) ^ (h >>> 16);
            System.out.println(k + " - " + hash % 16);
        }
    }

    private static void program_2() {
        printSection("Program_2. LinkedHashMap");
        Logger.printMessage("LinkedHashMap accessOrder is true");

        Map<Integer, String> map = new LinkedHashMap<>(32, 0.9F, true);

        map.put(1, "Some text #1");
        map.put(3, "Some text #3");
        map.put(7, "Some text #7");
        map.put(1, "Some text #1");
        map.put(5, "Some text #5");
        map.put(4, "Some text #4");
        map.put(1, "Some text #1");
        map.put(2, "Some text #2");
        map.put(10, "Some text #10");
        map.put(9, "Some text #9");
        map.put(17, "Some text #17");
        map.put(33, "Some text #33");

        System.out.println("map = " + map);

        Logger.printMessage("Список просто заполнен в режиме access order");
        printKeys(map);

        map.get(1);
        map.get(1);
        map.get(2);

        Logger.printMessage("Как выглядит список после get()");
        printKeys(map);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. TreeMap ");

        TreeMap<Integer, String> map = new TreeMap<>() {{
            put(1, "Some text #1");
            put(3, "Some text #3");
            put(7, "Some text #7");
            put(1, "Some text #1");
            put(5, "Some text #5");
            put(4, "Some text #4");
            put(1, "Some text #1");
            put(2, "Some text #2");
            put(10, "Some text #10");
            put(9, "Some text #9");
            put(17, "Some text #17");
            put(33, "Some text #33");

        }};

        printKeys(map);

        System.out.println(map.firstEntry());
        System.out.println(map.lastEntry());

        System.out.println(map.floorEntry(7));
        System.out.println(map.ceilingEntry(7));

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. Measuring code time execution");

        double average1 = 0;
        double average2 = 0;
        double average3 = 0;
        int count = 10;

        for (int i = 0; i < count; i++) {

            LocalTime before = LocalTime.now();
            long startMilli = System.currentTimeMillis();
            long startNano = System.nanoTime();

            int[] arr = new int[1_000];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new Random().nextInt(0, 100);
            }

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {
//
//            }

            LocalTime after = LocalTime.now();
            long endMilli = System.currentTimeMillis();
            long endNano = System.nanoTime();

            Logger.printMessage("Три разные разницы:");
            Duration duration = Duration.between(before, after);

            average1 += duration.getNano();
            average2 += endMilli - startMilli;
            average3 += (endNano - startNano);

            System.out.println("difference = " + duration);
            System.out.println("difference = " + (endMilli - startMilli) + " Millis");
            System.out.println("difference = " + (endNano - startNano) + "Nanos");

        }

        Logger.printMessage("Средние значения:");
        System.out.println("average1 = " + average1 / count / 1000 / 1000 + "Millis");
        System.out.println("average2 = " + average2 / count + " Millis");
        System.out.printf("average3 = %.6f - Millis \n", average3 / count / 1000 / 1000);

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. ");

        LocalTime start = LocalTime.now();
        Instant startI = Instant.now();
        System.out.println("start = " + start);

        try {
            Thread.sleep(0, 1);
        } catch (InterruptedException ignore) {
        }

        LocalTime end = LocalTime.now();
        Instant endI = Instant.now();
        System.out.println("end = " + end);

//        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
//        System.out.println("System.nanoTime() = " + System.nanoTime());

        System.out.println(Duration.between(start, end));
        System.out.println(Duration.between(startI, endI));

        printSectionEnding();
    }

    private static void program_15() {
        printSection("Program_15. ");

        Thread thread1 = new Thread(new ThreadHashMap());
        Thread thread2 = new Thread(new ThreadLinkedHashMap());
        Thread thread3 = new Thread(new ThreadTreeMap());

        try {

            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();
        } catch (InterruptedException ignore) {

        }
        printSectionEnding();
    }

    private static void program_16() {
        printSection("Program_16. ");

        Thread thread1 = new Thread(new ThreadHashMap());
        Thread thread2 = new Thread(new ThreadLinkedHashMap());
        Thread thread3 = new Thread(new ThreadTreeMap());

        try {
            thread3.start();
            thread3.join();

            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

        } catch (InterruptedException ignore) {

        }

        printSectionEnding();
    }

    private static void program_17() {
        printSection("Program_17. ");

        Thread thread1 = new Thread(new ThreadHashMap());
        Thread thread2 = new Thread(new ThreadLinkedHashMap());
        Thread thread3 = new Thread(new ThreadTreeMap());

        try {
            thread2.start();
            thread2.join();

            thread1.start();
            thread1.join();

            thread3.start();
            thread3.join();
        } catch (InterruptedException ignore) {

        }

        printSectionEnding();
    }
}

class ThreadHashMap implements Runnable {

    @Override
    public void run() {
//        Logger.printMessage("HashMap");

//        long startMilli = System.currentTimeMillis();
        long startNano = System.nanoTime();

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, "Some text №" + i);
        }

//        Logger.printMessage("map.size() = " + map.size(), Colors.BLUE);

//        long endMilli = System.currentTimeMillis();
        long endNano = System.nanoTime();


//        Logger.printMessage("HashMap. Duration = " + (endMilli - startMilli) + " Millis", Colors.BLUE);
        Logger.printMessage("HashMap. Duration = " + (endNano - startNano) / 1_000_000.0 + " Millis", Colors.BLUE);
    }
}

class ThreadLinkedHashMap implements Runnable {

    @Override
    public void run() {
//        Logger.printMessage("LinkedHashMap");

        long startMilli = System.currentTimeMillis();
        long startNano = System.nanoTime();

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, "Some text №" + i);
        }

//        Logger.printMessage("map.size() = " + map.size(), Colors.PURPLE);

        long endMilli = System.currentTimeMillis();
        long endNano = System.nanoTime();


//        Logger.printMessage("LinkedHashMap. Duration = " + (endMilli - startMilli) + " Millis", Colors.PURPLE);
        Logger.printMessage("LinkedHashMap. Duration = " + (endNano - startNano) / 1000.0 / 1000 + " Millis", Colors.PURPLE);
    }
}

class ThreadTreeMap implements Runnable {

    @Override
    public void run() {
//        Logger.printMessage("TreeMap");

        long startMilli = System.currentTimeMillis();
        long startNano = System.nanoTime();

        java.util.TreeMap<Integer, String> map = new java.util.TreeMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, "Some text №" + i);
        }

//        Logger.printMessage("map.size() = " + map.size(), Colors.CYAN);


        long endMilli = System.currentTimeMillis();
        long endNano = System.nanoTime();


//        Logger.printMessage("TreeMap. Duration = " + (endMilli - startMilli) + " Millis", Colors.CYAN);
        Logger.printMessage("TreeMap. Duration = " + (endNano - startNano) / 1000.0 / 1000 + " Millis", Colors.CYAN);
    }
}
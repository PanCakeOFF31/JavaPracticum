package yandexPracticum.javaCoreContinuation.theme_4.lesson_3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3. LinkedHashMap, TreeMap");

//        program_1();
        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Сравнение map");

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>(16, 0.5f, false);
        Map<String, String> map3 = new TreeMap<>();

        fillMap(map1);
        fillMap(map2);
        fillMap(map3);

        System.out.println("HashMap, порядок не гарантирован:");
        printMap(map1);
        System.out.println("LinkedHashMap, отсортировано в порядке добавления:");
        printMap(map2);
        System.out.println("TreeMap, элементы расположены в порядке сравнения от < 0 до > 0:");
        printMap(map3);


        printSubSectionEnding();
    }

    private static void fillMap(Map<String, String> map) {
        map.put("младший", "получать");
        map.put("почва", "хватить");
        map.put("описать", "высокий");
        map.put("берег", "тюрьма");
        map.put("покой", "примитивный");
        map.put("предупредить", "поэт");
        map.put("талантливый", "пробовать");
        map.put("элементарный", "парк");
        map.put("столица", "определяться");
        map.put("товарищ", "славянский");
    }

    private static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }

    private static void program_2() {
        printSubSection("Program_2. TreeMap");

        TreeMap<String, String> map = new TreeMap<>();

        fillMap(map);
        printMap(map);

        System.out.println("map.firstEntry() = " + map.firstEntry());
        System.out.println("map.firstKey() = " + map.firstKey());

        System.out.println("map.lastEntry() = " + map.lastEntry());
        System.out.println("map.lastKey() = " + map.lastKey());

        TreeMap<String, String> oldMap = new TreeMap<>();

        Map.Entry<String, String> temp = map.pollFirstEntry();
        oldMap.put(temp.getKey(), temp.getValue());

        temp = map.pollLastEntry();
        oldMap.put(temp.getKey(), temp.getValue());

        printMap(map);
        printMap(oldMap);

        printMap(new LinkedHashMap<>(map.descendingMap()));
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {

        }

        printSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

class Test implements Comparable<Test> {
    @Override
    public int compareTo(Test o) {
        return 0;
    }
}
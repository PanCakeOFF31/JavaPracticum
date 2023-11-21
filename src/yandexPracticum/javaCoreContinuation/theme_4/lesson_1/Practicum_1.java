package yandexPracticum.javaCoreContinuation.theme_4.lesson_1;

import java.util.HashMap;
import java.util.Map;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1. HashMap");

        program_1();
        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        Map<String, Boolean> map = new HashMap<>();

        map.putIfAbsent("Maxim", true);
        map.putIfAbsent("Maxim", false);

        map.put("Blinov", false);
        map.put("Blinov", true);

        System.out.println("map = " + map);

        System.out.println("map.get(\"Max\") = " + map.get("Max"));
        System.out.println("map.getOrDefault(\"Max\", false) = " + map.getOrDefault("Max", false));


        map.put("Test", false);
        System.out.println("map.remove(\"Test\",true) = " + map.remove("Test", true));
        System.out.println("map.remove(\"asd\") = " + map.remove("asd"));
        System.out.println("map = " + map);

        printSubSectionEnding();
    }


    private static void program_2() {
        printSubSection("Program_2. remove");

        Map<String, Integer> map = new HashMap<>();

        map.put("key1", 1231);
        map.put("key2", 231);
        map.put("key3", 305);
        map.put("key4", 551);

        System.out.println("map = " + map);

        System.out.println("map.remove(\"key1\") = " + map.remove("key1"));
        System.out.println("map.remove(\"asd\") = " + map.remove("asd"));
        System.out.println("map.remove(\"key2\",231) = " + map.remove("key2", 231));
        System.out.println("map.remove(\"key2\",111) = " + map.remove("key2", 111));

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            stringIntegerEntry.get
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            
        }

        printSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

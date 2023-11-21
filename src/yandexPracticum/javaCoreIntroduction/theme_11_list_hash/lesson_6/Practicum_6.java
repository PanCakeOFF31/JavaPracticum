package yandexPracticum.javaCoreIntroduction.theme_11_list_hash.lesson_6;

import static helpers.Helpers.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Practicum_6 {
    public static void practicum_6() {
        printSection("Practicum_6. Добавляем элементы в хеш-таблицу");

//      First steps
//        program_1();

//        Сложный хеш
        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. First steps");

        HashMap<String, String> officeTools = new HashMap<>();

        officeTools.put("s23421", "Стул");
        officeTools.put("s23420", "Стол");
        officeTools.put("s25221", "Компьютер");
        officeTools.put("s25221", "Крутой компьютер");

        System.out.println(officeTools);

        System.out.println(officeTools.keySet());
        System.out.println(officeTools.values());

        System.out.println(officeTools.get("s23421"));

        printSubSectionEnding();
    }

     private static void program_2() {
        printSubSection("Program_2. Сложный хеш-список");

        HashMap<String, ArrayList<Double>> menu = new HashMap<>();

        ArrayList<Double> coffeePrice = new ArrayList<>();
        coffeePrice.add(100.4);
        coffeePrice.add(13.4);
        coffeePrice.add(10.4);

        ArrayList<Double> meetPrice = new ArrayList<>();
        meetPrice.add(1000.4);
        meetPrice.add(130.4);
        meetPrice.add(100.4);

        ArrayList<Double> milkPrice = new ArrayList<>();
        milkPrice.add(76.4);
        milkPrice.add(7.4);
        milkPrice.add(5.4);

        menu.put("Кофе", coffeePrice);
        menu.put("Мясо", meetPrice);
        menu.put("Молоко", milkPrice);

         System.out.println(menu);

        printSubSectionEnding();
    }

    /* private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

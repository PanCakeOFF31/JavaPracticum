package yandexPracticum.javaCoreIntroduction.theme_11_list_hash.lesson_3;

import java.util.ArrayList;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3. Методы списков. Часть 2");

//
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Еще методы");

        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        a.add("Maxim");
        a.add("Slava");
        a.add("Koly");
        a.add("Kirill");
        a.add("Maxim");
        System.out.println("a - " + a);

        a.remove("Maxim"); // Удаляет первый встретившийся
        System.out.println("a - " + a);

        b.add("Slava");
        b.add("Kirill");
        System.out.println("b - " + b);

        a.removeAll(b); // Удаляет все значения, схожие со значениями b-списка
        System.out.println("a - " + a);

        b.clear();
        System.out.println("b is empty? - " + b.isEmpty());

        System.out.println("a - " + a);
        System.out.println("a contains Maxim? - " + a.contains("Maxim"));

        printSubSectionEnding();
    }

    /* private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

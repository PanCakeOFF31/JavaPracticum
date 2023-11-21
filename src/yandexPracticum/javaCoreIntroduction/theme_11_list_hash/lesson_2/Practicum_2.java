package yandexPracticum.javaCoreIntroduction.theme_11_list_hash.lesson_2;

import java.util.ArrayList;
import java.util.Random;

import static helpers.Helpers.*;

public class Practicum_2 {
    public static void practicum_2() {
        printSection("Practicum_2. Методы списков. Часть 1");

//
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Методы списка");

        Random random = new Random();
        ArrayList<Integer> a = new ArrayList<>(100);
        int temp;

        System.out.println("Коллекция a:");

        for (int i = 0; i < 9; ++i) {
            a.add(random.nextInt(0,100));
        }

        printArrayList(a);
        System.out.println("ArrayList содержит - " + a.size());

        a.add(2, 144);
        printArrayList(a);
        System.out.println("ArrayList содержит - " + a.size());

        System.out.println(a + " - " + a.size());
//
//        a.clear();
//        System.out.println(a.isEmpty());

        a.remove(0);
        System.out.println(a + " - " + a.size());

        System.out.println("Элемент по индексу 0 - " + a.get(0));

        System.out.println("Добавляем новую коллекцию b, а затем складываем с a:");

        ArrayList<Integer> b = new ArrayList<>(100);

        for (int i = 0; i < 10; ++i) {
            b.add(random.nextInt(0,100));
        }

        System.out.println(b + " - " + b.size());

        ArrayList<Integer> c = new ArrayList<>(100);

        c.addAll(a);
        c.addAll(b);

        System.out.println(c + " - " + c.size());

        ArrayList<Integer> d = (ArrayList<Integer>) c.clone();
        for (int i = 0; i < d.size()/2; ++i) {
            d.remove(d.size() - 1);
        }
        System.out.println(d);

        printSubSectionEnding();
    }

    private static void printArrayList(ArrayList<Integer> a) {
        System.out.print("[");
        for (Integer x : a) {
            System.out.print(x + " ");
        }
        System.out.println("]");
    }

    /* private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

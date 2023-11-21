package yandexPracticum.basics.loops;

import static helpers.Helpers.*;
import java.util.Random;
public class Loops {
    public static void loops() {
        printArticle("Циклы - Loops");

        // Цикл for
//        program_1();

        //  Random class
//        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("");

        // Первая часть скобок - инициализация, что выполняется при первом запуске цикла
        int i = 3;
        for (int j = 1; j < i; i--) {
            System.out.println(i);
            System.out.println(j);
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Random class");

        Random random = new Random();
        System.out.println(random.nextInt(10));

        printSectionEnding();
    }

    /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}

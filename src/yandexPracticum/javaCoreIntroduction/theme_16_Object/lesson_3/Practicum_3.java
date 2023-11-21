package yandexPracticum.javaCoreIntroduction.theme_16_Object.lesson_3;

import java.util.HashMap;
import java.util.Objects;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3. Вычисляем хеш");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("");

        int hash = Objects.hash(10, 20,30,40,50,60);
        System.out.println(hash);

        hash = Objects.hash(10, 20,30,40,51,60);
        System.out.println(hash);

        printSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

package yandexPracticum.javaCoreIntroduction.theme_14_alphabet.lesson_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Проверка switch");

        switch ("ma") {
            case "maxim" :
                System.out.println("maxim");
                break;
            case "max" :
                System.out.println("max");
            default:
                System.out.println("default");
        }

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

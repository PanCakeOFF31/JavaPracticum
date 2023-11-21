package javaRush.javaSyntaxPro.level_13;

import java.util.ArrayList;
import java.util.Arrays;

import static helpers.Helpers.*;

public class Level_13 {
    public static void level_13() {
        printSection("Level 13. Функции");

//
        program_1();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. ArrayList<> ");

        ArrayList<Integer> integers = new ArrayList<>(10){{
            add(10);
            add(20);
            add(40);
            add(80);
        }};


        Integer[] ints = new Integer[0];
        ints = integers.toArray(ints);

        System.out.println("integers = " + integers);
        System.out.println("ints = " + Arrays.toString(ints));

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

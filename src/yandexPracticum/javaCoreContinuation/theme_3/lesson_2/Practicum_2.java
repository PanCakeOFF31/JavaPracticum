package yandexPracticum.javaCoreContinuation.theme_3.lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static helpers.Helpers.*;

public class Practicum_2 {
    public static void practicum_2() {
        printSection("Practicum_2");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. List");

        Integer[] array = new Integer[]{10, 20, 30};

        System.out.println("List.of(array) = " + List.of(array));

        List<Integer> list = new ArrayList<>(List.of(10, 203, 40, 60));


        Integer[] newArray = new Integer[]{};
        newArray = list.toArray(newArray);
        System.out.println("Arrays.toString(newArray) = " + Arrays.toString(newArray));

        Random random = new Random();
        random.nextInt(10);

        ArrayList<Integer> a = new ArrayList<>(List.of(10,20,30));

//        Integer x = 10000;
//        Integer y = 10000;
//        System.out.println("x == y = " + (x == y));
//        System.out.println("x.equals(y) = " + x.equals(y));

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

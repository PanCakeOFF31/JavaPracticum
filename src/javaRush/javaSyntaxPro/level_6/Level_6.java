package javaRush.javaSyntaxPro.level_6;

import static helpers.OneDimensionalArray.*;
import static helpers.Helpers.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Level_6 {
    public static void level_6() {
        printSection("Level 6. Массивы");

//      Тестируем массивы
//        program_1();

//        Взаимодействие с Arrays
//        program_2();

//        Вспомогательный класс Arrays
//        program_3();

//        Вспомогательный класс Arrays, часть - 2
//        program_4();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Тестируем массивы");

//        Массив может работать как с примитивами так и со ссылочным типом данных
        Integer[] integerArray = new Integer[5];
        int[]   intArray = new int[5];

        String[] stringArray = new String[5];
        printOneDimensionalArray(intArray);
        printOneDimensionalArray(stringArray);

        System.out.println(integerArray.getClass());
        System.out.println(integerArray.getClass().getName());

        System.out.println(stringArray.getClass());
        System.out.println(stringArray.getClass().getName());

        System.out.println(new Test().getClass());
        System.out.println(new Test().getClass().getName());
        System.out.println(Test.class);

    }

    private static void program_2() {
        printSubSection("Program 2. Взаимодействие с Arrays");

        String[] a = {"Maxim", "Blinov", "Alexandrovich", "Dmitry", "Ilya"};
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(Arrays.copyOfRange(a,1,4)));

        System.out.println("Элементы массива:");
        for (String s : a) {
            System.out.println(s);
        }

        System.out.println("Элементы массива:");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. Вспомогательный класс Arrays");
        System.out.println("Используемые методы: toString(), deepToString(), equals(), deepEquals()");
        Random random = new Random();
        int[] one_1 = new int[10];
        Integer[] one_2 = new Integer[10];

        int[][] two_1 = new int[3][3];
        Integer[][] two_2 = new Integer[3][3];

        Arrays.fill(one_1, 0,5,15);
        Arrays.fill(one_2, 2,6,30);

        for (int i = 0; i < two_1.length; i++) {
            Arrays.fill(two_1[i],(i+1)*3);
            Arrays.fill(two_2[i],(i+1)*5);
        }

        printSubSection("One Dimension Arrays");
//        Метод toString работает только с одномерными массивами примитивов или ссылочных типов
        System.out.println("toString - " + Arrays.toString(one_1));
        System.out.println("toString - " + Arrays.toString(one_2));
//        Метод deepToString работает с массивами ссылочных типов любой размерности
//        System.out.println(Arrays.deepToString(one_1));
        System.out.println("deepToString - " + Arrays.deepToString(one_2));

        printSubSectionEnding();
        printSubSection("Two Dimension Arrays");

        System.out.println(Arrays.toString(two_1));
        System.out.println(Arrays.toString(two_2));
        System.out.println(Arrays.deepToString(two_1));
        System.out.println(Arrays.deepToString(two_2));

        printSubSectionEnding();
        printSubSection("Методы equals() and deepEquals()");

        Arrays.fill(one_1, 15);
        Arrays.fill(one_2, 15);

        int[] one_4 = Arrays.copyOf(one_1,one_1.length);
        Integer[] one_3 = new Integer[one_1.length];
        for (int i = 0; i < one_3.length; i++) {
            one_3[i] = one_1[i];
        }

        System.out.println("one_1.toString - " + Arrays.toString(one_1));
        System.out.println("one_2.toString - " + Arrays.toString(one_2));
        System.out.println("one_3.toString - " + Arrays.toString(one_3));
        System.out.println("one_4.toString - " + Arrays.toString(one_4));

        System.out.println(Arrays.equals(one_1,one_4));
        System.out.println(Arrays.equals(one_2,one_3));
        System.out.println("Сравним one_3, one_2 содержимое массивов по длине и значениям: " + Arrays.equals(one_3,0,4,one_2,0,4));
        System.out.println("Сравним one_3, one_2  содержимое массивов по длине и значениям: " + Arrays.deepEquals(one_3,one_2));

        Integer[][] two_3 = new Integer[3][3];

        for (int i = 0; i < two_1.length; i++) {
            Arrays.fill(two_1[i],(i+1));
            Arrays.fill(two_2[i],(i+1));
            Arrays.fill(two_3[i],(i+1));
        }

        System.out.println(Arrays.deepToString(two_1));
        System.out.println(Arrays.deepToString(two_2));

        System.out.println(Arrays.deepEquals(two_3[0],two_2[0]));
        System.out.println("Сравним two_3, two_2  содержимое массивов по длине и значениям: " + Arrays.deepEquals(two_3,two_2));

        printSubSectionEnding();
    }


    private static void program_4() {
        printSubSection("Program 4. Вспомогательный класс Arrays, часть 2");
        System.out.println("Используемые методы: fill(), copyOf(), copyOfRange()," +
                " sort(), binarySearch(), mismatch()");

        int[] one_1 = new int[10];

        System.out.println("Массив - one_1, заполненный через метод fill():");
        Arrays.fill(one_1,10);
        printArray(one_1);

        System.out.println("Массив - one_1, заполненный через метод fillArrayWithRandomNumbers():");
        fillArrayWithRandomNumbers(one_1);
        printArray(one_1);

        int[] one_2;
        one_2 = Arrays.copyOf(one_1,one_1.length);

        System.out.println("Массив - one_2, который является полной копией one_1:");
        printArray(one_2);

        System.out.println("Массив - one_1, после сортировки методом sort():");
        Arrays.sort(one_1);
        printArray(one_1);

        int indexOfSearch = Arrays.binarySearch(one_1, one_2[0]);
        System.out.println("Число - " + one_2[0] + " находится в one_1 по index - " + indexOfSearch);

        int[] one_3;
        one_3 = Arrays.copyOfRange(one_1,5,15);
        System.out.println("Массив - one_3, который является копие one_1 после сортировки начиная с 5 элемента:");
        printArray(one_3);

        System.out.println("Массив - one_3, который отсортирован, с 3 по 7 индекс");
        Arrays.sort(one_3,3,7);
        printArray(one_3);

        int[] one_4 = Arrays.copyOf(one_3,10);
        one_4[8] = 231;
        System.out.println("Массив -  one_4, которыя является копие one_3");
        printArray(one_4);
        System.out.println("Найдем первое вхождение, где обнаружено не соответствие по значению:");
        int mismatchIndex = Arrays.mismatch(one_3,0,one_3.length,one_4,0,10);
        System.out.println("Индекс - " + mismatchIndex + ", значение в one_4 - " + one_4[mismatchIndex]);

        printSubSectionEnding();
    }

    private static void fillArrayWithRandomNumbers(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(0,50);
        }
    }

    private static void printArray(int[] a) {
        System.out.println(a.length + " - " + Arrays.toString(a));
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

class Test {

}

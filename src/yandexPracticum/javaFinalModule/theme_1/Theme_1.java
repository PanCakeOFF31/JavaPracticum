package yandexPracticum.javaFinalModule.theme_1;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static helpers.Helpers.*;

public class Theme_1 {
    public static void main(String[] args) {
        printArticle("Алгоритмы и рекурсия");

//        program_1();
//        program_2();
        // Матрёшка - рекурсивное построение - buildMatroska()
//        program_3();
        // Recursive case - stairsBuilder()
//        program_4();
        // Рекурсивный поиск элемента в списке - hasName()
//        program_5();
        // isPalindrome()
//        program_6();
        //  Мантра
//                program_7();
        // BinarySearch
//        program_8();
        // Merge sort
        program_9();
        // bubble sort
        program_10();

    }

    private static void program_1() {
        printSection("Program_1. Что такое рекурсия");

//        Stack overflow
//        foo_1(1);

        printSectionEnding();
    }

    public static void foo_1(int deep) {
        System.out.println(deep++);
        foo_1(deep);
    }

    private static void program_2() {
        printSection("Program_2. Queue");

        String rootPath = "C:\\Users\\user\\YandexDisk\\0_Programming\\Intellij IDEA Java Projects\\JavaYandexPracticum\\src\\yandexPracticum\\javaFinalModule\\theme_1\\root";
        String targetName = "target.txt";
        Path root = Path.of(rootPath);

        File dir = new File(rootPath);
        System.out.println(Arrays.toString(dir.list()));

        File dir1 = new File(root.resolve("books").toUri());
        System.out.println(Arrays.toString(dir1.list()));

        File dir2 = new File(root.resolve("books/../").toUri());
        System.out.println(Arrays.toString(dir2.list()));

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Матрёшка - рекурсивное построение");

        foo_3(1, 3);

        printSectionEnding();
    }

    // build Matroska
    private static void foo_3(final int size, final int n) {
        if (size <= 0)
            return;

        if (n >= 1) {
            System.out.println("Создаём низ матрешки размера " + size);
            foo_3(size - 1, n - 1);
            System.out.println("Создаём верх матрёшки размером " + size);
        }
    }

    // Recursive case
    private static void program_4() {
        printSection("Program_4. Recursive case");

        foo_4(10);

        printSectionEnding();
    }

    // stairsBuilder()
    private static int foo_4(final int n) {
        if (n == 0)
            return 0;

        System.out.println("Осталось ступеней: " + n);
        foo_4(n - 1);
//        System.out.println("Осталось построить ступеней " + n);

        return n;
    }

    private static void program_5() {
        printSection("Program_5. Рекурсивный поиск элемента в списке");

        List<String> names = List.of("maxim", "pavel", "igor", "danil");
        String targetName = "danil";

        System.out.printf("Имя \"%s\" содержится в списке имен: %s, ответ: %b\n",
                targetName, names, foo_5(targetName, names));

        printSectionEnding();
    }

    // hasElement()
    private static boolean foo_5(final String text, final List<String> list) {
        if (list.isEmpty()) return false;

        if (list.getFirst().equals(text)) return true;

        return foo_5(text, list.subList(1, list.size()));
    }

    // isPalindrome()
    private static void program_6() {
        printSection("Program_6. isPalindrome()");

        System.out.println(": " + foo_6(""));
        System.out.println("a: " + foo_6("a"));
        System.out.println("maxam: " + foo_6("maxam"));
        System.out.println("maxim: " + foo_6("maxim"));

        printSectionEnding();
    }

    private static boolean foo_6(String testString) {
        testString = testString.trim().toLowerCase();

        int length = testString.length();
        if (length == 0) return true;
        if (length == 1) return true;

        char firstChar = testString.charAt(0);
        char lastChar = testString.charAt(length - 1);

        return firstChar == lastChar && foo_6(testString.substring(1, length - 1));
    }

    private static void program_7() {
        printSection("Program_7. Mantra");


        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. BinarySearch");

        int[] array = {1, 2, 5, 8, 12, 13, 14, 20, 22, 24, 30, 32};

        System.out.println("Индекс искомого элемента: " + searchBinary(array, 1));
        System.out.println("Индекс искомого элемента: " + searchBinary(array, 2));
        System.out.println("Индекс искомого элемента: " + searchBinary(array, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(array, 32));
        System.out.println("Индекс искомого элемента: " + searchBinary(array, -123123));

        printSectionEnding();
    }

    private static int searchBinary(int[] array, int element) {
        if (array.length == 0) return -1;

        if (array.length == 1) {
            if (element == array[0])
                return 0;

            return -1;
        }

        return searchBinaryRecursive(array, element, 0, array.length - 1);
    }

    private static int searchBinaryRecursive(int[] array, int element, int low, int high) {
        if (high < low) return -1;

        if (high == low) {
            if (element == array[low])
                return low;

            return -1;
        }

        int middle = low + (high - low) / 2;
        int middleElement = array[middle];

        if (middleElement == element)
            return middle;

        if (element < middleElement)
            return searchBinaryRecursive(array, element, low, middle);

        return searchBinaryRecursive(array, element, middle + 1, high);
    }

    private static void program_9() {
        printSection("Program_9. Merge sort");

        int[] array = {29, 28, 44, 4, 10, 83, 11};
        int[] sorted = mergeSortDescending(array);

        int sort = getSortRecursive(sorted, 0, 0);
        if (sort > 0) {
            System.out.println("Массив отсортирован по возрастанию");
        } else if (sort < 0) {
            System.out.println("Массив отсортирован по убыванию");
        } else {
            System.out.println("Массив не отсортирован");
        }

        printSectionEnding();
    }

    private static int[] mergeSortDescending(int[] array) {
        if (array.length <= 1)
            return array;

        int[] result = new int[array.length];

        int[] leftPart = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] left = mergeSortDescending(leftPart);

        int[] rightPart = Arrays.copyOfRange(array, array.length / 2, array.length);
        int[] right = mergeSortDescending(rightPart);

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                ++leftIndex;
            } else {
                result[resultIndex] = right[rightIndex];
                ++rightIndex;
            }

            ++resultIndex;
        }

        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

    private static int getSortRecursive(int[] array, int sort, int next) {
        // Несортированный, если массив пустой
        if (array.length == 0 || array.length == 1) return 0;

        if (sort == 0) {
            if (array[next] < array[next + 1])
                sort = 1;
            if (array[next] > array[next + 1])
                sort = -1;
        }

        if (next + 1 >= array.length)
            return sort;

        if (sort > 0 && array[next] < array[next + 1])
            return getSortRecursive(array, sort, ++next);

        if (sort < 0 && array[next] > array[next + 1])
            return getSortRecursive(array, sort, ++next);

        return 0;
    }

    private static void program_10() {
        printSection("Program_10. Bubble sort");



        printSectionEnding();
    }

    private static void bubbleSortAscending(){

    }
}

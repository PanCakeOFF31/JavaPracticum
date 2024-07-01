package yandexPracticum.javaFinalModule.theme_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Theme_7 {
    public static void main(String[] args) {
//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
        program_7();
        //        program_8();
        //        program_9();
    }

    private static void program_1() {
        printSection("Program_1. Перечисления");

        for (CarBrend value : CarBrend.values()) {
            System.out.println("Перечисление с именем " + value.toString() + " имеет порядок " + value.ordinal());
            System.out.println("Перечисление с именем " + value.name() + " имеет порядок " + value.ordinal());
            System.out.println(value.name() + " " + value.info());
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Static");

        System.out.println(ConstantContainer.humanLegs);
        System.out.println(new ConstantContainer(10).getHorseLegs());

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Comparator и Comparable");

        Set<BowlingPin> set1 = new TreeSet<>();
        Set<ChessPin> set2 = new TreeSet<>();

        set1.add(new BowlingPin(10, 10));
        set2.add(new ChessPin(10, 10));

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Exception");

        try {
            throw new ArithmeticException();
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Обработано " + e.getClass().getName() + "исключение");
        }

        try {
            throw new IllegalArgumentException();
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Обработано " + e.getClass().getName() + "исключение");
        }

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Exception inheritance");

//        try {
//            throwRandomExceptionOfTwoException();
//        } catch (ExceptionOne e) {
//            System.out.println("Обработано " + e.getClass().getName() + "исключение");
//        } catch (ExceptionTwo e) {
//            System.out.println("Обработано " + e.getClass().getName() + "исключение");
//        }
//

        printSectionEnding();
    }

    private static RuntimeException throwRandomExceptionOfTwoException() {
        return new ExceptionOne();
    }

    private static class ExceptionOne extends RuntimeException {

    }

    private static class ExceptionTwo extends ExceptionOne {

    }

    private static void program_6() {
        printSection("Program_6. Test");

        Integer a = Integer.valueOf(10);
        Integer b = Integer.valueOf(10);

        System.out.println(a.equals(b));
        System.out.println(a == b);

        System.out.println(crazyDivide(10, 5));

//        String

        printSectionEnding();
    }

    private static int crazyDivide(int a, int b) {
        try {
            return a / b;
        } catch (RuntimeException ignore) {
            return a + b;
        } finally {
            return a * b;
        }
    }

    private static void program_7() {
        printSection("Program_7. Проверка ошибок");

//        System.out.println(calculate(3,2,1));

        Set<MagicBox> set1 = new TreeSet<>() {{
            add(MagicBox.of(10));
            add(MagicBox.of(10));
            add(MagicBox.of(10));
            add(MagicBox.of(10));
            add(MagicBox.of(20));
            add(MagicBox.of(5));
            add(MagicBox.of(20));
            add(MagicBox.of(5));
            add(MagicBox.of(10));
            add(MagicBox.of(15));

        }};

        Set<MagicBox> set2 = new TreeSet<>() {{
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(10));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(10));
            add(MagicBox.of(15));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
            add(MagicBox.of(25));

        }};

        List<MagicBox> list1 = new ArrayList<>() {{
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(10));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(10));
            add(MagicBox.of(15));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
        }};

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(bubbleSort(list1));
        System.out.println(insertionSort(list1));
        System.out.println(bubbleSort(new ArrayList<>(List.of(20, 5, 11, 20, 20, 20, 10, 5, 5, 5, 5, 5, 10, 15, 25, 25, 25, 25))));


        List<MagicBox> list2 = new ArrayList<>() {{
            add(MagicBox.of(20));
            add(MagicBox.of(5));
            add(MagicBox.of(20));
            add(MagicBox.of(10));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(5));
            add(MagicBox.of(4));
            add(MagicBox.of(4));
            add(MagicBox.of(2));
            add(MagicBox.of(2));
            add(MagicBox.of(25));
            add(MagicBox.of(5));
            add(MagicBox.of(5));
            add(MagicBox.of(15));
            add(MagicBox.of(10));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
        }};

        List<MagicBox> list3 = new ArrayList<>() {{
            add(MagicBox.of(4));
            add(MagicBox.of(5));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(10));
            add(MagicBox.of(20));
            add(MagicBox.of(20));
            add(MagicBox.of(5));
            add(MagicBox.of(4));
            add(MagicBox.of(2));
            add(MagicBox.of(2));
            add(MagicBox.of(25));
            add(MagicBox.of(5));
            add(MagicBox.of(25));
            add(MagicBox.of(5));
            add(MagicBox.of(15));
            add(MagicBox.of(10));
            add(MagicBox.of(25));
            add(MagicBox.of(25));
        }};

        System.out.println(bubbleSort(list2));
        System.out.println(insertionSort(list3));

        printSectionEnding();
    }

    public static <T extends Comparable<T>> List<T> insertionSort(List<T> sortArr) {
        var list = new ArrayList<>(sortArr);

        int j;
        for (int i = 1; i < list.size(); i++) {
            T swap = list.get(i);
            for (j = i; j > 0 && swap.compareTo(list.get(j - 1)) < 0; j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(j, swap);
        }

        return list;
    }

    static int calculate(int a, int b, int c) {
        int max = a;
        if (b > a)
            System.out.println("b больше, чем a");
        max = b;
        if (c > max)
            return c;
        else
            return max;
    }

    public static <T extends Comparable<T>> List<T> bubbleSort(List<T> sortArr) {
        var list = new ArrayList<>(sortArr);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    T swap = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, swap);
                }
            }
        }

        return list;
    }
}

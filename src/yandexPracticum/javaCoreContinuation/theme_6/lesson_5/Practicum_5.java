package yandexPracticum.javaCoreContinuation.theme_6.lesson_5;

import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Practicum_5 {
    public static void practicum_5() {
        printSection("Practicum_5");

//        constructors
//        program_1();

//        charAt(), setCharAt(), deleteCharAt()
//        program_2();

//        replace()
//        program_3();

//        deleteCharAt(), delete()
//        program_4();

//        reverse()
//        program_5();

//        setLength()
//        program_6();

//        task_!
//        program_10();

//        length(), capacity(), ensureCapacity()
//        program_7();

//        task_2
//        program_8();

//        task_3
//        program_9();

        program_11();

//        program_12();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. StringBuilder: constructors");
        Logger.printCallingMethod();

        StringBuilder str1 = new StringBuilder();
        System.out.println("Пустой StringBuilder, str1 = " + str1);

        StringBuilder str2 = new StringBuilder(100);
        System.out.println("Пустой StringBuilder, str2 = " + str2);

        StringBuilder str3 = new StringBuilder("Some text in a mutable object");
        System.out.println("Не пустой StringBuilder, str3 = " + str3);

        var str4 = new StringBuilder(str3);
        System.out.println("Копия str3, str4 = " + str4);

        printSubSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. StringBuilder: charAt(), setCharAt(), deleteCharAt()");

        String str1 = "Картельные сговоры не допускаются.";
        System.out.println("str1.charAt(0) = " + str1.charAt(0));

        StringBuilder str2 = new StringBuilder(str1);
        System.out.println("str2.charAt(0) = " + str2.charAt(0));

        str2.setCharAt(0, 'Х');
        str2.deleteCharAt(1);
        str2.insert(1, 'и');

        System.out.println("str2 = " + str2);

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. StringBuilder: replace()");

        StringBuilder str = new StringBuilder("С учётом сложившейся международной обстановки");
        StringBuilder changed = str.replace(0, 1, "Без");

//        Изменения происходят внутри StringBuilder - mutable object
        System.out.println("str = " + str);
        System.out.println("changed = " + changed);

        str.replace(0, 30, "foo");

        System.out.println("str = " + str);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. StringBuilder: delete(), deleteCharAt()");

        StringBuilder str = new StringBuilder("С учётом сложившейся международной обстановки");

        System.out.println("str = " + str);

        str.delete(0, 30);
        str.deleteCharAt(10);

        System.out.println("str = " + str);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. StringBuilder: reverse()");

        StringBuilder str = new StringBuilder("Лепс спел");

        System.out.println("str = " + str);

        str.reverse();

        System.out.println("str = " + str);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. StringBuilder: setLength()");

        StringBuilder str = new StringBuilder("С учётом сложившейся международной обстановки");

        System.out.println("str = " + str);

        str.setLength(20);

        System.out.println("str = " + str);

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. StringBuilder: task");

        StringBuilder initial = new StringBuilder("Большая красная кнопка");

        initial.replace(8, 15, "белая");
        initial.delete(14, 30);
        initial.append("груша");
        initial.setLength(7);
        initial.reverse();

        System.out.println(initial.toString().toLowerCase());

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. StringBuilder: length(), capacity(), ensureCapacity()");

        StringBuilder str = new StringBuilder(100);

        System.out.println("str.capacity() = " + str.capacity());

        str.append("Some text");
        str.ensureCapacity(3000);

        System.out.println("str.length() = " + str.length());
        System.out.println("str.capacity() = " + str.capacity());

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. StringBuilder: task2");

        String text = "разрразаразз, раз, раз ра";
        String substring = "раз";

        System.out.println(numberOfRepeats(text, substring));

        printSectionEnding();
    }

    public static int numberOfRepeats(String text, String substring) {
        StringBuilder str = new StringBuilder(text);
        int count = 0;
        int index;

        while ((index = str.indexOf(substring)) != -1) {
            count++;
            str.delete(0, index + substring.length());
        }

        return count;
    }

    private static void program_9() {
        printSection("Program_9. StringBuidler: task3");

        String text = "max x a m";
        System.out.println(isPalindromeLine(text));

        printSectionEnding();
    }

    public static boolean isPalindromeLine(String str) {
        StringBuilder s = new StringBuilder(str.replace(" ", ""));
        System.out.println("s = " + s);
        StringBuilder s1 = new StringBuilder(s);
        s.reverse();
        System.out.println("s1 = " + s1);
        return s1.compareTo(s) == 0;
    }

    private static void program_11() {
        printSection("Program_11. Iterable");




        printSectionEnding();
    }
}

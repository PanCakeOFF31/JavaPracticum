package freePractise.languageComparison;

import helpers.coloredString.ColoredString;
import helpers.coloredString.Logger;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

import static helpers.Helpers.*;

public class PythonComparison {
    public static void main(String[] args) {
        printArticle("Java vs Other Programming Language");

//        Форматирование целых чисел
//        program_1();
//        Операции с множествами
//        program_2();
//        input()
//        program_3();
//        Аргументы переменной длины
//        program_4();
//        Оператор присваивания в Python - инструкция
//        program_5();
//        Mutable and Immutable types
//        program_6();
//        String method and manipulation
//        program_7();
//        Целые числа
//        program_8();
//        String splitting/joining
//        program_9();
//        Списки
        program_10();
//        program_11();
//        program_12();
//        program_13();
//        program_14();
//        program_15();
//        program_16();
//        program_17();
//        program_18();
//        program_19();
        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Python. Форматирование целых чисел с выводом");

        int number;

        number = 0x1f;
        System.out.println(Integer.toString(0x1f, 16));
        System.out.println("number = " + number);

        number = 0b010101010;
        System.out.println(Integer.toOctalString(0b010101010));
        System.out.println("number = " + number);

        number = 077;
        System.out.println("number = " + number);


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Операции с множествами");

        Collection<String> playlist1 = new HashSet<>() {{
            add("Голубой");
            add("Облака");
            add("Yesterday");
            add("Лето");
        }};

        Collection<String> playlist2 = new HashSet<>() {{
            add("Голубой");
            add("Облака");
            add("Лето");
        }};

        playlist1.removeAll(playlist2);
        System.out.println("playlist1 = " + playlist1);

        Map<Integer, String> dic = new HashMap<>();

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Scanner vs input()");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name");
        String name = scanner.next();
        System.out.println("Your name is: " + name);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Variable length arguments");

        foo(10, 20, 30);

        printSectionEnding();
    }

    private static void foo(int first, int... second) {
        System.out.println(first + Arrays.toString(second));
    }

    private static void program_5() {
        printSection("Program_5. Statement/Expression");

//        Assignment operator
        int a = 10;

        System.out.println(a = 20);
        System.out.println(a);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Mutable and Immutable types");

        printSubSection("Mutable variable");
        {
            List<Integer> list = new ArrayList<>();

            list.add(10);
            list.add(20);
            list.add(30);

            var other_list = list;
            other_list.add(40);


            System.out.println("list = " + list);
            System.out.println("other_list = " + other_list);
        }
        printSectionEnding();


        printSubSection("Immutable variable");
        {
            List<Integer> list = List.of(10, 20, 30);
            System.out.println("list = " + list);
            list.add(40);
        }
        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Strings");

        String example = "Исходная строка";

        printSubSection("Базовые махинации");
        {
            System.out.println("example = " + example);
            System.out.println("Длина строки: " + example.length());
            System.out.println("Первый элемент: " + example.charAt(0));
            System.out.println("Последний элемент: " + example.charAt(example.length() - 1));
            System.out.println("Подстрока: " + example.substring(1, 3));
            System.out.printf("Строка форматирования - '%s'\n", example);
        }

        printSubSection("Методы строк в сравнении с Python");
        {
//            upper()
            System.out.println("Строка в верхнем регистре: " + example.toUpperCase());
//            lower()
            System.out.println("Строка в нижнем регистре: " + example.toLowerCase());
//            count()
//            replace()
            System.out.println(example.replace("о", "О"));
//            index()
            System.out.println(example.indexOf("р"));
            System.out.println(example.charAt(11));
//            capitalize()
        }

        printSubSection("Проверки строки на различное");
        {

        }

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Целые числа");

        final String str = "-0.1";

        if (isDigit(str)) {
            System.out.println(Integer.parseInt(str));
        } else {
            System.out.println("Строка не является числом: " + str);
        }

        if (isDigitRegex(str)) {
            System.out.println(Double.parseDouble(str));
        } else {
            System.out.println("Строка не является числом: " + str);
        }

        printSubSection("Длина строки на основе символов");
        {
            String full = "Maxim   m";
            System.out.println(characterLength(full));
        }

        printSectionEnding();
        System.exit(100);
    }

    private static boolean isDigit(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDigitRegex(final String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private static int characterLength(String origin) {
        origin = origin.trim();
        StringBuilder builder = new StringBuilder(origin.length());

        for (char c : origin.toCharArray()) {
            if (Character.isAlphabetic(c))
                builder.append(c);
        }

        return builder.toString().length();
    }

    private static void program_9() {
        printSection("Program_9. String split()/join()");

        String origin = "Большая исходная строка";

        System.out.println("origin = " + origin);
        System.out.println(Arrays.toString(origin.split(" ")));
        System.out.println(String.join("_,", origin.split(" ")));


        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. List methods");

        List<String> origin = new ArrayList<>() {{
            add("Ветер");
            add("144");
            add("Аргумент");
            add("аргумент");
            add("аргумент");
            add("night-007");
        }};

        System.out.println("origin = " + origin);

        printSubSection("append()/insert()");
//        append() and insert()
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            copy.add("Последний");
            copy.add(2, "в середине где-то");

            System.out.println("copy после add() = " + copy);
        }

        printSubSection("index()");
//        index()
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            int headIndex = copy.indexOf("аргумент");
            int tailIndex = copy.lastIndexOf("аргумент");

            System.out.println("headIndex = " + headIndex);
            System.out.println("tailIndex = " + tailIndex);
        }

        printSubSection("count()");
//        count() - подсчет количества вхождений
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            int count = Collections.frequency(copy, "аргумент");
            System.out.printf("Количество вхождений \'аругмент\' в списке = %d\n", count);
        }

        printSubSection("remove()/pop()");
//          remove(), pop()
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            Logger.printMarkMessage("Удаление последнего элемента");
            copy.removeLast();
            System.out.println("copy = " + copy);

            Logger.printMarkMessage("Удаление 3 элемента с конца");
            copy.remove(copy.size() - 4);
            System.out.println("copy = " + copy);

            Logger.printMarkMessage("Удаление всех элементов по значению");
            copy.removeAll(Collections.singleton("аргумент"));
            System.out.println("copy = " + copy);

            Logger.printMarkMessage("Удаление элемента по значению");
            copy.remove("Ветер");
            System.out.println("copy = " + copy);
        }

        printSubSection("reverse()");
//
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            Collections.reverse(copy);
            System.out.println("copy = " + copy);
        }

        printSubSection("");
//
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);
        }

        printSubSection("Подсчет суммы списка");
//
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

            Optional<Integer> length = copy.stream()
                    .map(String::length)
                    .reduce(Integer::sum);

            System.out.println(length.orElse(0));

        }

        printSubSection("copy()/list()/[:]");
//
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

        }

        printSubSection("");
//
        {
            List<String> copy = new ArrayList<>(origin);
            System.out.println("copy = " + copy);

        }


        printSectionEnding();
    }
}
        

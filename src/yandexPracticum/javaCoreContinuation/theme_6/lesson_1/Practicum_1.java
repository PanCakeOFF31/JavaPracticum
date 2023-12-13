package yandexPracticum.javaCoreContinuation.theme_6.lesson_1;

import freePractise.logger_coloredString.Logger;
import helpers.OneDimensionalArray;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printArticle("Practicum_1");

//        join(), copyValueOf(), concat()
//        program_1();

//        indexOf(), lastIndexOf()
//        program_2();

//        startsWith(), endsWidth(), contains()
//        program_3();

//        format(), formatted()
//        program_4();

//        replace()
//        program_5();

//        substring()
//        program_6();

//        codePoint
//        program_7();

//        split()
//        program_8();

//        repeat()
//        program_9();

//        codePoints constructor
//        program_10();

//        numberOfRepeats
//        program_11();

//        transform()
//        program_12();

//        replace(), replaceFirst()
//        program_13();

//
        program_14();
//        program_15();

        printArticleEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. String: join(), copyValueOf()");

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        String str1 = "Maxim";
        String str2 = "Blinov";

        String joined = String.join(",", str1, str2);
        String copied = String.copyValueOf(chars, 2, chars.length - 2);

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("joined = " + joined);
        System.out.println("copied = " + copied);

        String concatenated = str1.concat(str2);
        System.out.println("concatenated = " + concatenated);

        printSubSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. String indexOf(), lastIndexOf()");

        String str1 = "Wild";
        String str2 = "Berry";
        String str3 = "Wildberries";

        System.out.println(str3.indexOf(str1));
        System.out.println(str3.indexOf('i', 3));

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. String: startsWith(), endsWith(), contains()");

        String str1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

        System.out.println(str1.startsWith("Lorem"));
        System.out.println(str1.startsWith("ipsum", 6));

        System.out.println(str1.endsWith("elit"));

        System.out.println(str1.contains("dolor"));

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. String: String.format(), formatted()");

        String origin = "amount of apples is %d and weight is %.2f";
        String formatted = origin.formatted(100, 2000.0);

        System.out.println("origin = " + origin);
        System.out.println("formatted = " + formatted);

        System.out.println();

        String formatted1 = String.format(origin, 400, 400.0);
        System.out.println("formatted1 = " + formatted1);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5.String: replace()");

        String origin = "Lorem ipsum dolor sit amet";
        String replaced1 = origin.replace('L', 'l');
        String replaced2 = origin.replace("Lorem", "lorik");

        System.out.println("origin = " + origin);
        System.out.println("replaced1 = " + replaced1);
        System.out.println("replaced2 = " + replaced2);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. String: substring()");

        String origin = "Lorem ipsum dolor sit amet";

        String sub1 = origin.substring(10);
        String sub2 = origin.substring(5, 11);

        System.out.println("origin = " + origin);
        System.out.println("sub1 = " + sub1);
        System.out.println("sub2 = " + sub2);

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. String: code point");

        String str1 = "Lorem имеется спорная точка зрения, гласящая примерно следующее";

        String codePoint = "\\u" + str1.codePointAt(0);
        System.out.println("codePoint = " + codePoint);

        codePoint = "\\u" + str1.codePointAt(6);
        System.out.println("codePoint = " + codePoint);

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. String: split()");

        String str1 = "some text_ other text_ one more text_ last some text";

        Logger.printMessage("regex is applied");
        OneDimensionalArray.printOneDimensionalArray((str1.split("_")));

        Logger.printMessage("regex is applied 0 time");
        OneDimensionalArray.printOneDimensionalArray((str1.split("_", 0)));

        Logger.printMessage("regex is applied 2 times");
        OneDimensionalArray.printOneDimensionalArray((str1.split("_", 2)));

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. String: repeat()");

        String origin = "*";
        String repeated = origin.repeat(8);

        System.out.println("origin = " + origin);
        System.out.println("repeated = " + repeated);

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. String: codePoints constructor");

        int[] codePoints = new int[]{1232, 1513, 3152, 123, 623, 54};

        String frank = new String(codePoints, 0, codePoints.length);
        System.out.println("frank = " + frank);

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Number of repeats");

        int count = numberOfRepeats("раз, раз, два, р", "р");
        System.out.println(count);

        String str = "aslkdkl;asjd";
//        String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1, str.length() - 1)

        printSectionEnding();
    }

    private static int numberOfRepeats(String text, String substring) {
        int count = 0;
        int index;
        int offset = 0;

        while ((index = text.indexOf(substring, offset)) != -1) {
            offset = index + substring.length();
            count++;
        }

        return count;
    }

    private static void program_12() {
        printSection("Program_12. String: transform - functional interface");

        String original = "some original text";

        String transformed = original.transform(n -> n.concat("!"));

        System.out.println("original = " + original);
        System.out.println("transformed = " + transformed);

        printSectionEnding();
    }

    private static void program_13() {
        printSection("Program_13. String: trim(), replace(), replaceFirst()");

        String origin = "Alphabet is a book with...";
        System.out.println("origin = " + origin);

        origin  = origin.replaceFirst("A", "a");
        System.out.println("origin = " + origin);

        origin = origin.replace("a", "A");
        System.out.println("origin = " + origin);

        printSectionEnding();
    }

    private static void program_14() {
        printSection("Program_14. String: replaceAll()");



        printSectionEnding();
    }

    private static void program_15() {
        printSection("Program_15. ");


        printSectionEnding();
    }

    private static void program_16() {
        printSection("Program_16. ");



        printSectionEnding();
    }

}

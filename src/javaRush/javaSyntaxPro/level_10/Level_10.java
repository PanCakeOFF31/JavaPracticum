package javaRush.javaSyntaxPro.level_10;

import java.util.StringTokenizer;

import static helpers.Helpers.*;

public class Level_10 {
    public static void level_10() {
        printSection("Level 10. Работа со строками");

//
//        program_1();

        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. JDK15 - тройные кавычки в строковом литерале");

        System.out.println("""
                Hello
                Hi
                """);

        printSubSectionEnding();
    }


    private static void program_2() {
        printSubSection("Program 2. StringTokenizer");

        String original = "Maxim, Blinov, Aleksandrovich";
        StringTokenizer tokenizer = new StringTokenizer(original,", ");
        String token = tokenizer.nextToken();
        System.out.println(token);
        token = tokenizer.nextToken(", ");
        System.out.println(token);
        token = tokenizer.nextToken("o");
        System.out.println(token);
        token = tokenizer.nextToken("o");
        System.out.println(token);

        printSubSectionEnding();
    }
    /* private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

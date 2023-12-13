package yandexPracticum.javaCoreContinuation.theme_9.lesson_4;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static helpers.Helpers.*;

public class Practicum_4 {
    public static void practicum_4() {
        printSection("Practicum_4.");

        program_1();
        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Charset");

        Charset charset = Charset.forName("UTF-8");
        System.out.println("charset = " + charset);

        Charset charset1 = StandardCharsets.UTF_8;
        System.out.println("charset1 = " + charset1);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Charset");

//        InputStreamReader inputStreamReader = new InputStreamReader( , StandardCharsets.UTF_8);


        printSectionEnding();
    }

}

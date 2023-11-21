package yandexPracticum.basics.familiarity;

import static helpers.Helpers.*;

public class Familiarity {

    public static void familiarity() {
        printArticle("Знакомство с Java");

        //
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Сложение и конкатенация");

        String text = " Hello ";

        System.out.println("Порядок арифметических операций при конкатенации следует учитывать!!!");
        System.out.println("text + 10 + 20 - \"" + text + 10 + 20 + "\"" + "\"");
        System.out.println("10 + 20 + text - \"" + (10 + 20) + text + "\"");
        System.out.println("10 + 20 + text + 10 + 20 - \"" + (10 + 20) + text + 10 + 20 + "\"");
        System.out.println("10 + 20 + text + 30 * 2 + text - \"" + (10 + 20) + text + 30 * 2 + text + "\"");
        System.out.println("10 + 20 + text + (10 + 20) - \"" + (10 + 20) + text + (10 + 20) + "\"");
        System.out.println();

        printSectionEnding();
    }



    /*static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/

}

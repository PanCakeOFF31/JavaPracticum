package headFirst.chapter_5_singleton;

import headFirst.chapter_5_singleton.classic.Singleton_ST;

import static helpers.Helpers.*;

public class Chapter_5_Singleton {
    public static void chapter_5() {
        printArticle("Singleton");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Singleton_singlethread");

        Singleton_ST object1 = Singleton_ST.getInstance();
        System.out.println(object1);

        Singleton_ST object2 = Singleton_ST.getInstance();
        System.out.println(object2);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Singleton_multithread");



        printSectionEnding();
    }
}

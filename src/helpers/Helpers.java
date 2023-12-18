// Вспомогательный класс, для визуального оформления в консоль вывода
package helpers;

import helpers.coloredString.Logger;

public class Helpers {
    private static final String ARTICLE_LINE = "======================================================================";
    private static final String SECTION_LINE = "----------------------------------------------------------------------";
    private static final String SUB_SECTION_LINE = "-----------------------------------";
    private static final String PART = "|--------------------";

    public static void printNewLine() {
        System.out.println();
    }

    public static void printArticle() {
        System.out.println(ARTICLE_LINE);
    }

    public static void printArticle(String text) {
        System.out.println(ARTICLE_LINE);
//        System.out.println("\t\t\t" + text);
        Logger.printMessage("\t\t\t" + text);
    }

    public static void printArticleEnding() {
        printArticle();
    }

    public static void printSection() {
        System.out.println(SECTION_LINE);
    }

    public static void printSection(String text) {
        System.out.println(SECTION_LINE);
//        System.out.println("\t\t" + text);
        Logger.printMessage("\t\t" + text);
    }

    public static void printSectionEnding() {
        printSection();
    }

    public static void printSubSection() {
        System.out.println(SUB_SECTION_LINE);
    }

    public static void printSubSection(String text) {
        System.out.println(SUB_SECTION_LINE);
//        System.out.println("\t" + text);
        Logger.printMessage("\t" + text);
    }

    public static void printSubSectionEnding() {
        printSubSection();
    }

    public static void printPart() {
        System.out.println(PART);
    }

    public static void printPart(String text) {
        System.out.println(PART);
//        System.out.println("\t" + text);
        Logger.printMessage("\t" + text);
    }

    public static void printTextWithTab(String text) {
        System.out.println("\t" + text);
    }
}
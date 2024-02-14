package headFirst.chapter_8_template_method;

import headFirst.chapter_8_template_method.beverage.Coffee;
import headFirst.chapter_8_template_method.beverage.Tea;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_8_template_method {
    public static void chapter_8() {
        printArticle("Template Method Pattern");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        Logger.printMessage("Варим чай");
        {
            Tea tea = new Tea();
            tea.prepareRecipe();
        }

        Logger.printMessage("Варим кофе");
        {
            Coffee coffee = new Coffee();
            coffee.prepareRecipe();
        }
        printSectionEnding();
    }
}

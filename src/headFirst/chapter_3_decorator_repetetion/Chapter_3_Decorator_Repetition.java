package headFirst.chapter_3_decorator_repetetion;

import headFirst.chapter_3_decorator_repetetion.starbuzz.beverage.Beverage;
import headFirst.chapter_3_decorator_repetetion.starbuzz.beverage.HouseBlend;
import headFirst.chapter_3_decorator_repetetion.starbuzz.decorator.CondimentDecorator;
import headFirst.chapter_3_decorator_repetetion.starbuzz.decorator.Milk;

import static helpers.Helpers.*;

public class Chapter_3_Decorator_Repetition {
    public static void chapter_3() {
        printArticle("Decorator - Repetition");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Decorator");

        Beverage beverage = new HouseBlend();

        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());

        beverage = new Milk(new Milk(beverage));

        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());

        printSectionEnding();
    }
}

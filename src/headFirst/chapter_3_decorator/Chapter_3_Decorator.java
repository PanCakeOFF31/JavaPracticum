package headFirst.chapter_3_decorator;

import headFirst.chapter_3_decorator.starbuzz.beverage.Beverage;
import headFirst.chapter_3_decorator.starbuzz.beverage.Espresso;
import headFirst.chapter_3_decorator.starbuzz.decorator.Milk;
import headFirst.chapter_3_decorator.starbuzz.decorator.Mocha;
import headFirst.chapter_3_decorator.starbuzz.decorator.Soy;
import headFirst.chapter_3_decorator.starbuzz.decorator.Whip;

import static helpers.Helpers.*;

public class Chapter_3_Decorator {
    public static void chapter_3() {
        printArticle("Chapter 3. Decorator");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Starbuzz");

        {
            Beverage beverage = new Espresso();
            System.out.println("beverage = " + beverage);
        }

        {
            Beverage beverage = new Espresso();
            beverage = new Milk(beverage);
            System.out.println("beverage = " + beverage);
        }

        {
            Beverage beverage = new Espresso();

            beverage = new Milk(beverage);
            beverage = new Mocha(beverage);
            beverage = new Whip(beverage);
            beverage = new Soy(beverage);

            System.out.println("beverage = " + beverage);
        }

        printSectionEnding();
    }
}

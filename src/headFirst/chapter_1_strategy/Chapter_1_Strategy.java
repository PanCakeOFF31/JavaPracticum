package headFirst.chapter_1_strategy;

import headFirst.chapter_1_strategy.ducks.entity.Duck;
import headFirst.chapter_1_strategy.ducks.entity.MallardDuck;
import headFirst.chapter_1_strategy.ducks.entity.ModelDuck;
import headFirst.chapter_1_strategy.ducks.fly.FlyRocketBehavior;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_1_Strategy {
    public static void chapter_1() {
        printArticle("Chapter 1. Strategy");

//        Ducks
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Ducks");

        Logger.printMessage("Mallar Duck - простой пример");
        {
            Duck mallard = new MallardDuck();
            mallard.disply();
            mallard.swim();
            mallard.performFly();
            mallard.performQuack();
        }

        Logger.printMessage("Возможность изменять поведение полета");
        {
            Duck model = new ModelDuck();
            model.disply();
            model.swim();

            model.performQuack();
            model.performFly();

            model.setFlyBehavior(new FlyRocketBehavior());

            model.performQuack();
            model.performFly();
        }

        printSectionEnding();
    }
}

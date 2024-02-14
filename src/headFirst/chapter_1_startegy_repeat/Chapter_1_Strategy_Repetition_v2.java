package headFirst.chapter_1_startegy_repeat;

import headFirst.chapter_1_startegy_repeat.duck_v2.duck.Duck;
import headFirst.chapter_1_startegy_repeat.duck_v2.duck.MallardDuck;
import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyBehavior;
import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyNoWay;
import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyRocketPowered;
import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyWithWings;
import headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior.MuteQuack;
import headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior.Quack;
import headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior.QuackBehavior;

import static helpers.Helpers.*;

public class Chapter_1_Strategy_Repetition_v2 {
    public static void chapter_1() {
        printArticle("Chapter 1. Strategy - Repetition v2");

//        Ducks
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Семейство поведений и динамическая подмена алгоритмов");
//        Семейство поведений: способность лета и способность крякать
//        Динамическая подмена алгоритмов за счет композиции

        FlyBehavior flyBehavior = new FlyWithWings();
        FlyBehavior flyBehavior1 = new FlyNoWay();
        FlyBehavior flyBehavior2 = new FlyRocketPowered();

        QuackBehavior quackBehavior = new Quack();
        QuackBehavior quackBehavior1 = new MuteQuack();

        Duck duck = new MallardDuck(flyBehavior, quackBehavior);
        duckActions(duck);

        duck.setFlyBehavior(flyBehavior1);
        duckActions(duck);

        duck.setFlyBehavior(flyBehavior2);
        duckActions(duck);

        printSectionEnding();
    }

    public static void duckActions(Duck duck) {
        duck.display();
        duck.swim();
        duck.performFly();
        duck.perfromQuack();
    }
}

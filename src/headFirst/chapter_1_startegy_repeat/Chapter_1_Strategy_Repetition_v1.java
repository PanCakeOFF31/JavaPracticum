package headFirst.chapter_1_startegy_repeat;

import headFirst.chapter_1_startegy_repeat.duck_v1.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static helpers.Helpers.*;

public class Chapter_1_Strategy_Repetition_v1 {
    public static void chapter_1() {
        printArticle("Chapter 1. Strategy - Repetition v1");

//        Ducks
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        List<Duck> ducks = new ArrayList<>() {{
            add(new MallardDuck());
            add(new RedheadDuck());
            add(new RubberDuck());
            add(new DecoyDuck());
        }};

        Consumer<Duck> quacking = Duck::quack;
        Consumer<Duck> equivalent = duck -> duck.quack();

        ducks.forEach(duck -> {
            duck.display();
            duck.quack();
            duck.fly();
        });

        printSectionEnding();
    }
}

























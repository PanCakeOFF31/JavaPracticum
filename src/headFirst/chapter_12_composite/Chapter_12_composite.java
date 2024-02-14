package headFirst.chapter_12_composite;

import headFirst.chapter_12_composite.adapter.GooseAdapter;
import headFirst.chapter_12_composite.component.Flock;
import headFirst.chapter_12_composite.decorator.QuackCounter;
import headFirst.chapter_12_composite.duck.Quackable;
import headFirst.chapter_12_composite.factory.AbstractDuckFactory;
import headFirst.chapter_12_composite.factory.CountingDuckFactory;
import headFirst.chapter_12_composite.goose.Goose;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.*;

public class Chapter_12_composite {
    public static void chapter_12() {
        printArticle("Composite Patterns");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Composite");

        AbstractDuckFactory factory = new CountingDuckFactory();

        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable duckCall = factory.createDuckCall();
        Quackable rubberDuck = factory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock flock = new Flock();

        flock.add(mallardDuck);
        flock.add(redheadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);
        flock.add(gooseDuck);

        flock.quack();

        System.out.println("Общее количество кряканий уток: " + QuackCounter.getQuacks());

        printSectionEnding();
    }
}

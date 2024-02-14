package headFirst.chapter_12_composite.factory;

import headFirst.chapter_12_composite.decorator.QuackCounter;
import headFirst.chapter_12_composite.duck.Quackable;

public class CountingDuckFactory extends DuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(super.createMallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(super.createRedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(super.createDuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(super.createRubberDuck());
    }
}

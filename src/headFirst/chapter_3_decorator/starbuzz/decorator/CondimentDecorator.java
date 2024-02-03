package headFirst.chapter_3_decorator.starbuzz.decorator;

import headFirst.chapter_3_decorator.starbuzz.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public abstract String getDescription();

}

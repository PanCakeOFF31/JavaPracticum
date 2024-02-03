package headFirst.chapter_3_decorator.starbuzz.decorator;

import headFirst.chapter_3_decorator.starbuzz.beverage.Beverage;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.10;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}

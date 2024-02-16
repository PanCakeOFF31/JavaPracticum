package headFirst.chapter_3_decorator_repetetion.starbuzz.decorator;

import headFirst.chapter_3_decorator_repetetion.starbuzz.beverage.Beverage;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage, "Milk ");
    }

    @Override
    public double cost() {
        return beverage.cost() + 15;
    }
}

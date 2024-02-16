package headFirst.chapter_3_decorator_repetetion.starbuzz.decorator;

import headFirst.chapter_3_decorator_repetetion.starbuzz.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage, String description) {
        super(description);
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + this.description;
    }
}

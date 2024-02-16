package headFirst.chapter_3_decorator_repetetion.starbuzz.beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        super("HouseBlend ");
    }

    @Override
    public double cost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

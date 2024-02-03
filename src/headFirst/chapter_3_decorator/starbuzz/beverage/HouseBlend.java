package headFirst.chapter_3_decorator.starbuzz.beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        this.description = "Домашняя смесь";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}

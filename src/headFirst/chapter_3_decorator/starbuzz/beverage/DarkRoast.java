package headFirst.chapter_3_decorator.starbuzz.beverage;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        this.description = "Темня обжарка";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}

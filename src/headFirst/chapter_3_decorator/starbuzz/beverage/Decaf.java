package headFirst.chapter_3_decorator.starbuzz.beverage;

public class Decaf extends Beverage {
    public Decaf() {
        this.description = "Без кофеина";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}

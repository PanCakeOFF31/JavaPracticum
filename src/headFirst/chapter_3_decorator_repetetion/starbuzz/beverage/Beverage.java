package headFirst.chapter_3_decorator_repetetion.starbuzz.beverage;

public abstract class Beverage {
    public Beverage(String description) {
        this.description = description;
    }

    protected String description;

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}

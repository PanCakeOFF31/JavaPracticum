package headFirst.chapter_3_decorator.starbuzz.beverage;

public class Espresso extends  Beverage{
    public Espresso() {
        this.description = "Экспрессо";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

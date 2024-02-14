package headFirst.chapter_8_template_method.beverage;

public abstract class Beverage {
    public abstract void brew();

    public abstract void addCCondiments();

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCCondiments();
    }

    public void boilWater() {
        System.out.println("Кипячение воды");

    }

    public void pourInCup() {
        System.out.println("Наливаем в чашку напиток");
    }
}

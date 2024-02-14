package headFirst.chapter_8_template_method.beverage;

public class Coffee extends Beverage {
    @Override
    public void brew() {
        System.out.println("Варка кофейных зерен");
    }

    @Override
    public void addCCondiments() {
        System.out.println("Добавляем сахар и молоко");
    }
}

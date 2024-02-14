package headFirst.chapter_8_template_method.beverage;

public class Tea extends Beverage {
    @Override
    public void brew() {
        System.out.println("Заваривание чая в горячей воде");

    }

    @Override
    public void addCCondiments() {
        System.out.println("Добавляем лимон");
    }
}

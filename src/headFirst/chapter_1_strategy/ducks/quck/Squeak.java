package headFirst.chapter_1_strategy.ducks.quck;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Утки, которые пищат: пи!");
    }
}

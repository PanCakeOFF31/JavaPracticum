package headFirst.chapter_1_strategy.ducks.quck;

public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Утки, которые не издают звук: ...!");
    }
}

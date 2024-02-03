package headFirst.chapter_1_strategy.ducks.fly;

public class FlyRocketBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Утки, которые летают как ракету: ракетааааа...!");
    }
}

package headFirst.chapter_1_strategy.ducks.fly;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Утки, которые летают: лечу!");
    }
}

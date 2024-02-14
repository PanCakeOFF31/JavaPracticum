package headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Я не умею летать");
    }
}

package headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket");
    }
}

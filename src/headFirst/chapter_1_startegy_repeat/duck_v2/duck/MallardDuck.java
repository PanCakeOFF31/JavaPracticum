package headFirst.chapter_1_startegy_repeat.duck_v2.duck;

import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyBehavior;
import headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior.QuackBehavior;

public class MallardDuck extends Duck{
    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }
}

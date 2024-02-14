package headFirst.chapter_1_startegy_repeat.duck_v2.duck;

import headFirst.chapter_1_startegy_repeat.duck_v2.fly_behavior.FlyBehavior;
import headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior.QuackBehavior;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void perfromQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("Standard swimming behavior");
    }

    public void display() {
        System.out.println("Standard displaying behavior");
    }
}

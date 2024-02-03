package headFirst.chapter_1_strategy.ducks.entity;

import headFirst.chapter_1_strategy.ducks.fly.FlyWithWings;
import headFirst.chapter_1_strategy.ducks.quck.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyWithWings();
    }

    @Override
    public void swim() {
        System.out.println("MallardDuck is swimming");
    }

    @Override
    public void disply() {
        System.out.println("MallardDuck is displaying");
    }
}

package headFirst.chapter_1_strategy.ducks.entity;

import headFirst.chapter_1_strategy.ducks.fly.FlyNoWay;
import headFirst.chapter_1_strategy.ducks.quck.Quack;

public class ModelDuck extends Duck{
    public ModelDuck() {
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyNoWay();
    }

    @Override
    public void swim() {
        System.out.println("ModelDuck is swimming");
    }

    @Override
    public void disply() {
        System.out.println("ModelDuck is displaying");
    }
}

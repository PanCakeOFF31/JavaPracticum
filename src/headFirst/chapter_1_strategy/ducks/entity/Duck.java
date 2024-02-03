package headFirst.chapter_1_strategy.ducks.entity;

import headFirst.chapter_1_strategy.ducks.fly.FlyBehavior;
import headFirst.chapter_1_strategy.ducks.quck.QuackBehavior;

public abstract class Duck {
    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public abstract void swim();

    public abstract void disply();

    public void performQuack(){
        this.quackBehavior.quack();;
    }

    public void performFly(){
        this.flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

package headFirst.chapter_12_composite.duck;

import headFirst.chapter_12_composite.observer.Observable;
import headFirst.chapter_12_composite.observer.Observer;

public class MallardDuck implements Quackable {
    private final Observable observable;

    public MallardDuck(Observable observable) {
        this.observable = observable;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public void quack() {
        System.out.println("MallardDuck - quacking");
    }
}

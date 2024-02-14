package headFirst.chapter_12_composite.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable implements QuackObservable {
    List<Observer> observers = new ArrayList<>();
    private QuackObservable duck;

    public Observable(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(duck));
    }
}

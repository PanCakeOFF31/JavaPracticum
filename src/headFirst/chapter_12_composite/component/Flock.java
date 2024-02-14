package headFirst.chapter_12_composite.component;

import headFirst.chapter_12_composite.duck.Quackable;
import headFirst.chapter_12_composite.observer.Observer;

import java.util.ArrayList;

public class Flock implements Quackable {
    private final ArrayList<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        quackers.forEach(Quackable::quack);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}

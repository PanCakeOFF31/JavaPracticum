package headFirst.chapter_12_composite.duck;

import headFirst.chapter_12_composite.observer.QuackObservable;

public interface Quackable extends QuackObservable {
    void quack();
}

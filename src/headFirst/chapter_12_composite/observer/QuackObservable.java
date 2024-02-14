package headFirst.chapter_12_composite.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();

}

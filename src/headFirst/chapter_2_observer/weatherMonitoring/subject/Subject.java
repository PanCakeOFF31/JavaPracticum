package headFirst.chapter_2_observer.weatherMonitoring.subject;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

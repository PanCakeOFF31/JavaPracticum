package headFirst.chapter_2_observer_repetition.weather_station.subject;


import headFirst.chapter_2_observer_repetition.weather_station.object.Observer;
import headFirst.chapter_2_observer_repetition.weather_station.record.Data;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

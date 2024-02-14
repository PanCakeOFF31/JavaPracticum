package headFirst.chapter_2_observer_repetition.weather_station.object;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer_repetition.weather_station.record.Data;

public interface Object extends Observer {
    void update();
}

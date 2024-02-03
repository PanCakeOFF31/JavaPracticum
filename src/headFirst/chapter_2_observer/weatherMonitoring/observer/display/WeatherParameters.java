package headFirst.chapter_2_observer.weatherMonitoring.observer.display;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer.weatherMonitoring.subject.Subject;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;

public abstract class WeatherParameters implements Observer {
    protected double temperature;
    protected double humidity;
    protected double pressure;
    protected WeatherData weatherData;
}

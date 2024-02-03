package headFirst.chapter_2_observer.weatherMonitoring.observer.display;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer.weatherMonitoring.subject.Subject;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;
import helpers.coloredString.Logger;

public class ForeCastDisplay extends WeatherParameters implements DisplayElement, Observer {
    private double lastPressure;

    public ForeCastDisplay(WeatherData subject) {
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        Logger.printMarkMessage(false, "Forecast display");
    }

    @Override
    public void update() {
        lastPressure = this.pressure;
        pressure = weatherData.getPressure();
        display();
    }

    public void unregister() {
        this.weatherData.removeObserver(this);
    }

    public void reregister() {
        this.weatherData.registerObserver(this);
    }
}


package headFirst.chapter_2_observer.weatherMonitoring.observer.display;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer.weatherMonitoring.subject.Subject;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;
import helpers.coloredString.Logger;

public class StatisticsDisplay extends WeatherParameters implements DisplayElement, Observer {
    public StatisticsDisplay(WeatherData subject) {
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        Logger.printMarkMessage(false,"Statistic display");
    }

    @Override
    public void update() {
        display();
    }
}

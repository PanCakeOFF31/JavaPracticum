package headFirst.chapter_2_observer.weatherMonitoring.observer.display;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer.weatherMonitoring.subject.Subject;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;
import helpers.coloredString.Logger;

public class HeatIndexDisplay extends WeatherParameters implements Observer, DisplayElement {
    public HeatIndexDisplay(WeatherData subject) {
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        Logger.printMarkMessage(false, "Heat condition display");
    }

    @Override
    public void update(){

        display();
    }
}

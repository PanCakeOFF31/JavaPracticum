package headFirst.chapter_2_observer.weatherMonitoring.observer.display;

import headFirst.chapter_2_observer.weatherMonitoring.observer.Observer;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;
import helpers.coloredString.Logger;

public class CurrentConditionsDisplay extends WeatherParameters implements DisplayElement, Observer {
    public CurrentConditionsDisplay(WeatherData subject) {
        this.weatherData = subject;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        Logger.printMarkMessage(false, "Current condition display");
        System.out.println("temperature = " + temperature);
        System.out.println("humidity = " + humidity);
        System.out.println("pressure = " + pressure);
    }

    @Override
    public void update() {
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        this.pressure = weatherData.getPressure();

        display();
    }
}

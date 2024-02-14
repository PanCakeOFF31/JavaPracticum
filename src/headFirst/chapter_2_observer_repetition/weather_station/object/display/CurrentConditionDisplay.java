package headFirst.chapter_2_observer_repetition.weather_station.object.display;

import headFirst.chapter_2_observer_repetition.weather_station.object.Observer;
import headFirst.chapter_2_observer_repetition.weather_station.subject.WeatherData;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CurrentConditionDisplay implements Observer, Display {
    private double temperature;
    private double humidity;
    @NonNull
    private WeatherData weatherData;

    @Override
    public void update() {
        System.out.println("CurrentConditionDisplay получил данные");

        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();

        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "^C degrees and " + humidity + "% humidity");
    }
}

package headFirst.chapter_2_observer_repetition.weather_station.subject;

import headFirst.chapter_2_observer_repetition.weather_station.object.Observer;
import headFirst.chapter_2_observer_repetition.weather_station.record.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WeatherData implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private double temperature;
    private double humidity;
    private double pressure;

    public void measurementsChanged(double temperature,
                                    double humidity,
                                    double pressuere) {
        System.out.println("Данные в метеостанции изменились");

        this.temperature = temperature;
        this.pressure = pressuere;
        this.humidity = humidity;

        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }
}

package headFirst.chapter_2_observer_repetition;

import headFirst.chapter_2_observer_repetition.weather_station.object.Observer;
import headFirst.chapter_2_observer_repetition.weather_station.object.display.CurrentConditionDisplay;
import headFirst.chapter_2_observer_repetition.weather_station.subject.WeatherData;

import static helpers.Helpers.*;

public class Chapter_2_Observer_Repetition {
    public static void chapter_2() {
        printArticle("Chapter 2. Observer - Repetition");

//
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Observer - ");

        WeatherData weatherData = new WeatherData();
        Observer currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.registerObserver(currentConditionDisplay);
        weatherData.measurementsChanged(10, 20, 30);
        weatherData.measurementsChanged(20, 20, 15);
        weatherData.measurementsChanged(30, 20, 10);

        printSectionEnding();
    }

}

package headFirst.chapter_2_observer;

import headFirst.chapter_2_observer.weatherMonitoring.observer.display.CurrentConditionsDisplay;
import headFirst.chapter_2_observer.weatherMonitoring.observer.display.ForeCastDisplay;
import headFirst.chapter_2_observer.weatherMonitoring.observer.display.HeatIndexDisplay;
import headFirst.chapter_2_observer.weatherMonitoring.observer.display.StatisticsDisplay;
import headFirst.chapter_2_observer.weatherMonitoring.subject.WeatherData;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_2_Observer {
    public static void chapter_2() {
        printArticle("Chapter 2. Observer");

//
        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Weather Monitoring");

        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForeCastDisplay foreCastDisplay = new ForeCastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        Logger.printMessage("Scenario - 1");
        {
            weatherData.setMeasurements(10, 20, 30);
        }

        Logger.printMessage("Scenario - 2");

        {
            foreCastDisplay.unregister();

            weatherData.setMeasurements(11, 18, 30);
        }


        Logger.printMessage("Scenario - 3. Bag with registration");
        {
            foreCastDisplay.reregister();
            foreCastDisplay.reregister();
            weatherData.registerObserver(foreCastDisplay);

            weatherData.setMeasurements(11, 18, 30);
        }
        printSectionEnding();
    }
}

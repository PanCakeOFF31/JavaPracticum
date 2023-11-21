package yandexPracticum.javaCoreIntroduction.theme_9_types.lesson_4;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_4 {
    public static void lesson_4() {
        printSection("Lesson_4. ");

        WeatherCalendar calendar = new WeatherCalendar("Октябрь", 31);
        //    calendar.rainyDays = 0;
        //   calendar.isRainyMonth = false;

        String[] octoberWeather = new String[]{
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Дождь",
                "Дождь",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Солнечно",
                "Солнечно",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Солнечно",
                "Солнечно",
                "Облачно",
                "Облачно",
                "Облачно",
                "Облачно",
                "Дождь",
                "Дождь",
                "Облачно",
                "Солнечно",
                "Дождь",
                "Пасмурно",
                "Дождь",
                "Солнечно",
                "Солнечно",
                "Солнечно",
                "Солнечно",
                "Облачно"
        };

        for (int i = 0; i < calendar.numberOfDays; i++) {
            if (octoberWeather[i].equals("Дождь")) {
                calendar.addRainyDay();
            }
        }

        // Проверить, был ли месяц дождливым. Если да - установить значение isRainyMonth
        if (calendar.rainyDays > 15) {
            calendar.isRainyMonth = true;
        }

        System.out.println(calendar.month + " " + calendar.year + " года. "
                + calendar.rainyDays + " дней шёл дождь.");

        // Проверить значение isRainyMonth
        if (calendar.isRainyMonth) {
            System.out.println("Это был дождливый месяц.");
        } else {
            System.out.println("Этот месяц был довольно сухим.");
        }

        printSectionEnding();
    }
}

class WeatherCalendar {
    String month;
    int numberOfDays;
    int rainyDays;
    int year = 2020;
    boolean isRainyMonth;

    WeatherCalendar(String monthName, int monthNumberOfDays) {
        month = monthName;
        numberOfDays = monthNumberOfDays;
    }

    // Увеличить переменную rainyDays на единицу
    public void addRainyDay() {
        this.rainyDays++;
    }
}
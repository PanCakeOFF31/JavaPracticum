package yandexPracticum.javaCoreContinuation.theme_4.lesson_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static helpers.Helpers.printSection;

import static helpers.Helpers.printSectionEnding;

public class Lesson_1 {
    private static List<String> passengerNames = List.of(
            "Василий Петров",
            "Анна Ягирская",
            "Виктория Сотова",
            "Игорь Серов",
            "Людмила Ульянова"
    );

    public static void lesson_1() {
        printSection("Lesson_1. ");

        Map<String, Integer> seats = assignSeats(passengerNames);
        System.out.println("Места пассажиров: " + seats);

        printSectionEnding();
    }

    // Пример списка пассажиров (на самом деле их больше)


    public static Map<String, Integer> assignSeats(List<String> passengerNames) {
        // Тут нужно написать код, который будет распределять места в самолёте ✈️
        Map<String, Integer> seats = new HashMap<>();
        int counter = 1;

        for (String passengerName : passengerNames) {
            seats.put(passengerName,counter);
            counter++;
        }

        return seats;
    }
}

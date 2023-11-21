package freePractise.classResearching.dateAndTimeAPI;

import java.time.*;

import static helpers.Helpers.printSubSection;
import static helpers.Helpers.printSubSectionEnding;

public class DateTimeUtil {
    /**
     * Выводит всю информацию о дате
     */
    public static void fullySeparateDate(LocalDate date) {
        printSubSection("Переданная дата: [" + date + "]");

        System.out.println("year - " + date.getYear());
        System.out.println("month of year = " + date.getMonth());
        System.out.println("day of month - " + date.getDayOfMonth());
        System.out.println("date of week - " + date.getDayOfWeek());
        System.out.println("date of year - " + date.getDayOfYear());

        Year year = Year.of(date.getYear());
        System.out.println("year = " + year);

        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        System.out.println("yearMonth = " + yearMonth);

        MonthDay monthDay = MonthDay.of(date.getMonth(), date.getDayOfMonth());
        System.out.println("monthDay = " + monthDay);

        printSubSectionEnding();
    }

    public static void fullySeparateTime(LocalTime time) {
        printSubSection("Переданное время: [" + time + "]");

        System.out.println("hour - " + time.getHour());
        System.out.println("minute - " + time.getMinute());
        System.out.println("second - " + time.getSecond());
        System.out.println("nano - " + time.getNano());

        printSubSectionEnding();
    }



    public static void localDataAnalyser(LocalDate date1, LocalDate date2) {
        System.out.printf("Сравниваются две даты: [%s] и [%s] ", date1, date2);
        if (date1.equals(date2)) {
            System.out.println("Даты равны");
            return;
        }

        if (date1.isAfter(date2)) {
            System.out.println("Первая дата следует за второй, то есть позже");
        }

        if (date1.isBefore(date2)) {
            System.out.println("Первая дата перед второй, то есть раньше");
        }
    }

    public static LocalDate copyDate(LocalDate date) {
        return date.plusDays(0);
    }
    public static boolean isWeekend(LocalDateTime dateTime) {
        int dayOfWeek = dateTime.toLocalDate().getDayOfWeek().getValue();
        int timeValue = dateTime.toLocalTime().getHour();

        return switch (dayOfWeek) {
            case 5 -> timeValue >= 22;
            case 6 -> true;
            case 7 -> timeValue < 23;
            default -> false;
        };
    }
}


package freePractise.classResearching.dateAndTimeAPI;

import java.time.*;
import java.time.chrono.IsoEra;

import static helpers.Helpers.*;

public class DateAndTimeAPI {
    public static void dateAndTimeAPI() {
        printArticle("Date and Time API");

//        part_1();
//        part_2();
//        part_3();
//        part_4();
//        part_5();
//        part_6();
//        part_10();

        printArticleEnding();
    }

    private static void part_1() {
        printSection("Part_1. LocalDate");

        LocalDate EPOCH = LocalDate.EPOCH;
        LocalDate MAX = LocalDate.MAX;
        LocalDate MIN = LocalDate.MIN;

        System.out.println("EPOCH = " + EPOCH);
        System.out.println("MAX = " + MAX);
        System.out.println("MIN = " + MIN);

        LocalDate date_1 = LocalDate.now();
        DateTimeUtil.fullySeparateDate(date_1);

        printSectionEnding();
    }

    private static void part_2() {
        printSection("Part_2. LocalTime");

        LocalTime MAX = LocalTime.MAX;
        LocalTime MIN = LocalTime.MIN;
        LocalTime MIDNIGHT = LocalTime.MIDNIGHT;
        LocalTime NOON = LocalTime.NOON;

        System.out.println("MAX = " + MAX);
        System.out.println("MIN = " + MIN);
        System.out.println("MIDNIGHT = " + MIDNIGHT);
        System.out.println("NOON = " + NOON);

        LocalTime time = LocalTime.now();
        System.out.println("time = " + time);

        printSectionEnding();
    }

    private static void part_3() {
        printSection("Part_3. LocalDateTime");

        LocalDateTime MAX = LocalDateTime.MAX;
        LocalDateTime MIN = LocalDateTime.MIN;

        System.out.println("MAX = " + MAX);
        System.out.println("MIN = " + MIN);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("datetime = " + datetime);

        printSectionEnding();
    }

    private static void part_4() {
        printSection("Part_4. Enumerations");

        printPart("enum Month");
        for (Month value : Month.values()) {
            System.out.println("month - " + value + " " + value.getValue());
        }

        printPart("enum DayOfWeek");
        for (DayOfWeek value : DayOfWeek.values()) {
            System.out.println("day of week - " + value + " " + value.getValue());
        }

        printPart("enum Era");
        for (IsoEra value : IsoEra.values()) {
            System.out.println("Era - " + value + " " + value.getValue());
        }


        printSectionEnding();
    }

    private static void part_5() {
        printSection("Part_5. Additional value types");

        printSubSection("class Year");
        Year onlyYear = Year.of(1999);
        System.out.println("onlyYear = " + onlyYear);

        printSubSection("class YearMonth");
        YearMonth yearMonth = YearMonth.of(3099, Month.MARCH);
        System.out.println("yearMonth = " + yearMonth);

        printSubSection("class MonthDay");
        MonthDay monthDay = MonthDay.of(Month.SEPTEMBER, 15);
        System.out.println("monthDay = " + monthDay);

        printSectionEnding();
    }

    private static void part_6() {
        printSection("Part_6. ZoneDateTime");

//        ZoneOffset customZoneOffset = ZoneOffset.ofHours(-4);
//        ZoneId zoneId = ZoneId.ofOffset("+", customZoneOffset);
//        ZonedDateTime datetime = ZonedDateTime.of(LocalDate.now(),LocalTime.now(),zoneId);
//        System.out.println("datetime = " + datetime);

        ZonedDateTime zdt_1 = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Europe/Paris"));

        System.out.println("zdt_1 = " + zdt_1);

        printSectionEnding();
    }


    private static void part_10() {
        printSection("Part_10. ");

        Instant instant = Instant.now(); // timestamp
        System.out.println(instant);

        System.out.println(System.currentTimeMillis());

//        ZoneOffset zoneOffset = ZoneOffset.of("Russia");
//        System.out.println("zoneOffset = " + zoneOffset);

        printSectionEnding();
    }


    /*    private static void part_2() {
        printSection("Part_2. ");


        printSectionEnding();
    }*/

}

























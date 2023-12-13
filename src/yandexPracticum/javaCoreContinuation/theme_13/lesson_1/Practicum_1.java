package yandexPracticum.javaCoreContinuation.theme_13.lesson_1;

import helpers.coloredString.Logger;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;
import static java.time.Month.DECEMBER;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

//        Unix-time + Instant
//        program_1();

//        Instant
//        program_2();

//        LocalDate, LocalTime, LocalDateTime
//        program_3();

//        DateTimeFormatter
//        program_4();

//        Period
//        TemporalAmount
//        program_5();

//        program_6();

//        Duration with LocalDateTime
//        program_7();

//        ZoneId
        program_8();
        program_9();

        program_10();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Instant overview");

        Instant instant = Instant.ofEpochMilli(1609416000000L);
        System.out.println("instant = " + instant);

        Instant corrected = instant.plusMillis(3 * 60 * 60 * 1000);
        System.out.println("corrected = " + corrected);

        Instant bySeconds = Instant.ofEpochSecond(1609416000L);
        System.out.println("bySeconds = " + bySeconds);

        Instant now = Instant.now();
        System.out.println("now = " + now);
        System.out.println("now.toEpochMilli() = " + now.toEpochMilli());
        System.out.println("now.getNano() = " + now.getNano());

        Logger.printMessage("Фиксирую время выполнения программы");
        {
            Instant timestamp1 = Instant.now();

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Instant timestamp2 = Instant.now();

            System.out.println(timestamp2.toEpochMilli() - timestamp1.toEpochMilli());
            System.out.println(timestamp2.getNano() - timestamp1.getNano());
        }

        System.out.println("Instant.MAX = " + Instant.MAX);
        System.out.println("Instant.MIN = " + Instant.MIN);
        final long MAX_SECONDS = 31556889864403199L;
        System.out.println("MAX_SECONDS = " + MAX_SECONDS);
        final long MIN_SECONDS = -31556889864403200L;
        System.out.println("MIN_SECONDS = " + MIN_SECONDS);

        System.out.println(Instant.ofEpochSecond(31556889864403199L));

        System.out.println("Instant.EPOCH = " + Instant.EPOCH);
        System.out.println("Instant.ofEpochMilli(0) = " + Instant.ofEpochMilli(0));

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Instant instance methods");

        Logger.printMessage("Операции сложения");
        {
            Instant point = Instant.now();
            System.out.println("point = " + point);

            System.out.println("point.plusSeconds(60) = " + point.plusSeconds(60));
            System.out.println("point.plusMillis(5000) = " + point.plusMillis(5000));
            System.out.println("point.plusNanos(10_000_000_000L) = " + point.plusNanos(10000000000L));
        }

        Logger.printMessage("Операции вычитания");
        {
            Instant point = Instant.now();
            System.out.println("point = " + point);

            System.out.println("point.minusSeconds(60) = " + point.minusSeconds(60));
            System.out.println("point.minusMillis(5000) = " + point.minusMillis(5000));
            System.out.println("point.minusNanos(10_000_000_000L) = " + point.minusNanos(10000000000L));
        }

        Logger.printMessage("Сравнение временных меток на временной линии");
        {
            Instant present = Instant.now();
            Instant past = present.minusSeconds(180);
            Instant future = present.plusSeconds(360);

            System.out.println("present = " + present);
            System.out.println("past = " + past);
            System.out.println("future = " + future);

            System.out.println("past.isBefore(present) = " + past.isBefore(present));
            System.out.println("future.isAfter(present) = " + future.isAfter(present));
            System.out.println("present.equals(present) = " + present.equals(present));
        }

//        System.out.println(Instant.now());
//        System.out.println(Instant.now().plusSeconds(604_800L));

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. LocalDateTime");

        LocalDateTime time1 = LocalDateTime.of(2023, DECEMBER, 12, 17, 54);
        System.out.println("time1 = " + time1);

        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. DateTimeFormatter");

        LocalDate date = LocalDate.parse("2020-199", DateTimeFormatter.ofPattern("yyyy-D"));
        System.out.println("date = " + date);

        System.out.println(date.format(DateTimeFormatter.ofPattern("D-yy")));

        LocalDateTime.now().toLocalDate();
        LocalDateTime.now().toLocalTime();

//        LocalDateTime.now().getHo

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Period");

        List<Period> periods = new ArrayList<>();

        periods.add(Period.ofDays(100));
        periods.add(Period.ofDays(300));
        periods.add(Period.ofDays(300).negated());
        periods.add(Period.ofDays(600).normalized());
        periods.add(Period.ofWeeks(3));
        periods.add(Period.ofWeeks(10));
        periods.add(Period.ofMonths(4));
        periods.add(Period.ofMonths(8).plusDays(1));
        periods.add(Period.ofYears(1));
        periods.add(Period.ofYears(2));
        periods.add(Period.of(1, 1, 1));
        periods.add(Period.between(LocalDate.of(2020, 1, 1), LocalDate.of(2021, 2, 2)));
        periods.add(Period.between(LocalDate.of(2020, 1, 1), LocalDate.of(2018, 2, 2)));

        periods.forEach(System.out::println);

        Logger.printMessage("LocalDate + TemporalAmount");
        {
            Period period = Period.ofDays(3);
            Duration duration = Duration.ofHours(1);

            period.getUnits().forEach(System.out::println);
            duration.getUnits().forEach(System.out::println);

            LocalDate today = LocalDate.now();
            System.out.println("today = " + today);

            LocalDate threeDaysLater = today.plus(period);
            System.out.println("threeDaysLater = " + threeDaysLater);

            try {
                LocalDate andOneHourLater = threeDaysLater.plus(duration);
                System.out.println("andOneHourLater = " + andOneHourLater);
            } catch (UnsupportedTemporalTypeException e) {
                Logger.printAlarmMessage("LocalDate instance не поддерживает единицу времени - секунду");
            }
        }

        Logger.printMessage("LocalTime + TemporalAmount");
        {
            Period period = Period.ofDays(3);
            Duration duration = Duration.ofMinutes(15);

            LocalTime time = LocalTime.of(14, 55, 35);
            System.out.println("time = " + time);

            LocalTime fifteenMinutesLater = time.plus(duration);
            System.out.println("fifteenMinutesLater = " + fifteenMinutesLater);

            try {
                LocalTime threeDaysLater = time.plus(period);
                System.out.println("threeDaysLater = " + threeDaysLater);
            } catch (UnsupportedTemporalTypeException e) {
                Logger.printAlarmMessage("LocalTime instance не поддерживает единицу времени - дни");
            }
        }

        Logger.printMessage("Instant + TemporalAmount");
        {
            Duration duration = Duration.ofHours(1);
            Duration duration1 = Duration.ofMinutes(10);
            Duration total = duration.plus(duration1);
            System.out.println("total = " + total);

            Instant now = Instant.now().plusMillis(3 * 60 * 60 * 1000);
            System.out.println(now.plus(total));
        }

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. The Code execution measuring");

        Logger.printMessage("Замер времени выполнения и вывод в различных величинах");
        {
            var timestamp1 = LocalTime.now();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            var timestamp2 = LocalTime.now();
            var duration = Duration.between(timestamp1, timestamp2);

            System.out.println("duration = " + duration);
            System.out.println("duration.toMillis() = " + duration.toMillis());
            System.out.println("duration.toNanos() = " + duration.toNanos());
        }

        Logger.printMessage("Разница между временами");
        {
            LocalTime time1 = LocalTime.of(14, 25);
            LocalTime time2 = LocalTime.of(23, 40);

            var duration = Duration.between(time1, time2);

            System.out.println("duration = " + duration);
            System.out.println("duration.toHours() = " + duration.toHours());
            System.out.println("duration.toMinutes() = " + duration.toMinutes());
            System.out.println("duration.toHoursPart() = " + duration.toHoursPart());
            System.out.println("duration.toMinutesPart() = " + duration.toMinutesPart());
        }

        Logger.printMessage("test");
        {
            var time1 = LocalTime.of(0, 0);
            var time2 = LocalTime.of(23, 59);

            var duration = Duration.between(time1, time2);
            System.out.println("duration = " + duration);
            System.out.println("duration.toDays() = " + duration.toDays());

        }
        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. ");

        final int SECONDS_IN_DAY = 60 * 60 * 24;

        {
            LocalDate date1 = LocalDate.of(2020, 6, 10);
            LocalDate date2 = LocalDate.of(2020, 6, 20);

            Period period = Period.between(date1, date2);
//        Duration duration = Duration.between(date1,date2);

            System.out.println("period = " + period);
//        System.out.println("duration = " + duration);

            System.out.println("SECONDS_IN_DAY = " + SECONDS_IN_DAY);
        }

        {
            LocalDateTime firstStart = LocalDateTime.of(2099, 10, 10, 12, 5);
            LocalDateTime firstFinish = LocalDateTime.of(2100, 11, 11, 14, 15);

//
            Duration duration = Duration.between(firstStart, firstFinish);
            System.out.println("duration = " + duration);
            System.out.println("duration.toSeconds() = " + duration.toSeconds());
            System.out.println("duration.toDays() = " + duration.toDays());
            System.out.println("duration.toMinutesPart() = " + duration.toMinutesPart());
        }

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. ZoneDateTime");

//        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        ZoneId zoneUTC = ZoneId.of("UTC+03:00");
        System.out.println("zoneUTC = " + zoneUTC);

        ZoneId zoneMoscow = ZoneId.of("Europe/Moscow");
        System.out.println("zoneMoscow = " + zoneMoscow);

        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime nowInMoscow = now.atZone(zoneMoscow);

        System.out.println("now = " + now);
        System.out.println("nowInMoscow = " + nowInMoscow);

        {
            ZoneId zone1 = ZoneId.of("UTC+12");
            ZoneId zone2 = ZoneId.of("UTC-9");
            ZoneId zone3 = ZoneId.of("UTC-09:15");
            ZoneId zone4 = ZoneId.of("UTC-09:15:30");

            System.out.println("zone1 = " + zone1);
            System.out.println("zone2 = " + zone2);
            System.out.println("zone3 = " + zone3);
            System.out.println("zone4 = " + zone4);
        }

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. ZoneDateTime: withZoneSameInstant(), withZoneSameLocal");

        Instant now = Instant.now();
        System.out.println("now = " + now);

        LocalDateTime nowInMyZone = LocalDateTime.ofInstant(now, ZoneId.of("UTC+3"));
        System.out.println("nowInMyZone = " + nowInMyZone);

        ZonedDateTime inMoscow = ZonedDateTime.of(nowInMyZone, ZoneId.of("Europe/Moscow"));
        ZonedDateTime inNewYork = inMoscow.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("inMoscow = " + inMoscow);
        System.out.println("inNewYork = " + inNewYork);

        var temp = inMoscow.withZoneSameLocal(ZoneId.of("America/New_York"));
        System.out.println("temp = " + temp);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("Регион VV, смещение ZZZZZ");
        System.out.println(inMoscow.format(formatter));
        System.out.println(temp.format(formatter));

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. ");

        System.out.printf("%-15s\n","pen");
        System.out.printf("%15s\n","pen");
        System.out.printf("%1.5s\n","penpenpenpen");



        printSectionEnding();
    }
    }











































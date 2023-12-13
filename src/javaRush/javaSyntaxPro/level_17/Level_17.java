package javaRush.javaSyntaxPro.level_17;

import freePractise.classResearching.dateAndTimeAPI.DateTimeUtil;

import java.time.*;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

import static helpers.Helpers.*;

public class Level_17 {
    public static void level_17() {
        printSection("Level 17. Date and time API");

//        Date
//        program_1();

//        Calendar
//        program_2();

//        LocalDate
//        program_3();
//        program_4();
//        program_5();

//        LocalTime
//        program_10();
//        program_11();
//        program_12();
//        program_13();
//        program_14();


//        LocalDateTime
//        program_20();
//        program_21();
//        program_22();
//        program_23();

//        Instant - мгновение
//        program_30();
//        program_31();

//        ZoneDateTime
//        program_35();

//        DateTimeFormatter
        program_40();
//        program_41();

//        Duration
        program_45();
//        Period
        program_46();
        program_47();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Date");

        printPart();
        {

            Date current = new Date();

            System.out.println(current);
            System.out.println(current.getTime());

            current.setTime(1610855019999L);
            System.out.println(current);
        }

        printPart();
        {
            Date current = new Date();
            SimpleFormatter formatter = new SimpleFormatter();
        }


        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program_2. Calendar");

        printPart();
        {
            Calendar calendar = Calendar.getInstance();
            System.out.println("calendar.get(10) = " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        }

        printPart();
        {
            Calendar calendar = new GregorianCalendar();
            System.out.println("calendar.getTime() = " + calendar.getTime());

            calendar.set(2023, 11, 1);
            System.out.println("calendar.getTime() = " + calendar.getTime());
        }

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program_3. LocalDate");

        printPart();
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-YYYY-DD");
        }

        printPart("LocalDate.ofYearDay()");
        {
            LocalDate date = LocalDate.ofYearDay(2020, 350);
            System.out.println("date = " + date);
            System.out.println("date.getDayOfYear() = " + date.getDayOfYear());
        }

        printPart("ofEpochDay");
        {
            LocalDate date = LocalDate.ofEpochDay(20000);
            System.out.println("date = " + date);
        }

        printPart("getEra()");
        {
            LocalDate date = LocalDate.now();
            System.out.println("date.getEra() = " + date.getEra());

            for (IsoEra value : IsoEra.values()) {
                System.out.println("Era - " + value + " " + value.getValue());
            }

//            CE - current era
//            BCE - before current era
        }

        printPart("parse() + Era");
        {
            LocalDate date = LocalDate.parse("0001-01-01");
            System.out.println("Era - " + date.getEra());
            System.out.println("date = " + date);
            System.out.println("Year - " + date.getYear());

            date = LocalDate.parse("-0001-01-01");
            System.out.println("Era - " + date.getEra());
            System.out.println("date = " + date);
            System.out.println("Year - " + date.getYear());

//            date = LocalDate.parse("2000-JN-15");
//            System.out.println("date = " + date);
        }

        printPart("copy of date");
        {
            LocalDate originDate = LocalDate.now();
            LocalDate copyDate = originDate.plusDays(0);
            System.out.println("originDate = " + originDate);
            System.out.println("copyDate = " + copyDate);
            System.out.println("originDate.equals(copyDate) = " + originDate.equals(copyDate));
        }

        printPart("plus(), minus()");
        {
            LocalDate date = LocalDate.parse("2020-10-20");
            System.out.println("Исходная дата:");
            System.out.println("date = " + date);

            System.out.println("Прибавим к дате выше 5 дней:");
            LocalDate changedDate = date.plusDays(5);
            System.out.println("changedDate = " + changedDate);

            System.out.println("Отнимем от даты выше 2 недели (14 дней):");
            changedDate = changedDate.minusWeeks(2);
            System.out.println("changedDate = " + changedDate);

        }

        printSubSectionEnding();
    }

    private static void program_4() {
        printSubSection("Program_4. LocalDate");

        printPart("compareTo()");
        {
            System.out.println("Сравнение двух дат:");

            LocalDate date = LocalDate.parse("2020-10-20");
            System.out.println("date = " + date);
            LocalDate changedDate = date.minusWeeks(1);

            System.out.println("changedDate = " + changedDate);
            int comparison = date.compareTo(changedDate);
            if (comparison > 0) {
                System.out.println("первая дата больше/позже второй на " + comparison + " дней.");
            } else if (comparison < 0) {
                System.out.println("первая дата меньше/раньше второй на " + comparison + " дней.");
            } else {
                System.out.println("первая дата равна второй дате, разница " + comparison + " дней.");
            }
        }

        printPart("compareTo()");
        {
            System.out.println("Сравнение двух дат:");

            LocalDate date = LocalDate.parse("2020-10-20");
            System.out.println("date = " + date);
            LocalDate changedDate = date.plusWeeks(1);

            System.out.println("changedDate = " + changedDate);
            int comparison = date.compareTo(changedDate);
            if (comparison > 0) {
                System.out.println("первая дата больше/позже второй на " + comparison + " дней.");
            } else if (comparison < 0) {
                System.out.println("первая дата меньше/раньше второй на " + comparison + " дней.");
            } else {
                System.out.println("первая дата равна второй дате, разница " + comparison + " дней.");
            }
        }

        printPart("isAfter(), isBefore(), isEquals()");
        {
            LocalDate date = LocalDate.of(2030, 5, 13);
            var changedDate = date.plusDays(15);
            DateTimeUtil.localDataAnalyser(date, changedDate);

            changedDate = date.minusWeeks(4);
            DateTimeUtil.localDataAnalyser(date, changedDate);

            changedDate = DateTimeUtil.copyDate(date);
            DateTimeUtil.localDataAnalyser(date, changedDate);
        }

        printSubSectionEnding();
    }


    private static void program_5() {
        printSubSection("Program_5. ");

        printSubSectionEnding();
    }

    private static void program_6() {
        printSubSection("Program_6. ");


        printSubSectionEnding();
    }

    private static void program_7() {
        printSubSection("Program_7. ");


        printSubSectionEnding();
    }


    private static void program_10() {
        printSubSection("Program_10. LocalTime");

        printPart("LocalTime + ZoneId");
        {
            ZoneId timeZone = ZoneId.of("Asia/Shanghai");
            LocalTime today = LocalTime.now();
            System.out.println("today = " + today);
            today = LocalTime.now(timeZone);
            System.out.println("today = " + today);
        }

        printSubSectionEnding();
    }

    private static void program_11() {
        printSubSection("Program_11. LocalTime");

        LocalTime time_1 = LocalTime.of(14, 59);
        System.out.println("time_1 = " + time_1);

        LocalTime time_2 = LocalTime.of(14, 31, 12);
        System.out.println("time_2 = " + time_2);

        LocalTime time_3 = LocalTime.of(14, 59, 44, 20);
        System.out.println("time_3 = " + time_3);

        LocalTime time_4 = LocalTime.ofSecondOfDay(65678);
        System.out.println("time_4 = " + time_4);

        LocalTime time = LocalTime.now();
        DateTimeUtil.fullySeparateTime(time);

        printSubSectionEnding();
    }

    private static void program_12() {
        printSubSection("Program_12. LocalTime");

        printPart("plus() and minus()");
        {
            LocalTime changedTime;
            LocalTime time = LocalTime.of(10, 20, 30);

            changedTime = time.plusHours(2);
            changedTime = changedTime.plusMinutes(15);
            changedTime = changedTime.plusSeconds(11);
            changedTime = changedTime.plusNanos(100000);

            System.out.println("Исходное время - " + time);
            System.out.println("Время плюс: 2 часа 15 минут и 11 секунд и 10Е6 наносекунд\n" + changedTime);
        }

        printPart();
        {
            LocalTime time = LocalTime.of(0, 0);
            LocalTime changedTime;
            System.out.println("time = " + time);

            changedTime = time.minusSeconds(1);
            changedTime = changedTime.minusMinutes(10);
            changedTime = changedTime.minusHours(3);

            System.out.println("Исходное время - " + time);
            System.out.println("Измененное время - " + changedTime);

        }


        printSubSectionEnding();
    }


    private static void program_13() {
        printSubSection("Program_13. ");
        printSubSectionEnding();
    }

    private static void program_14() {
        printSubSection("Program_14. ");
        printSubSectionEnding();
    }

    private static void program_20() {
        printSubSection("Program_20. LocalDateTime");

        printPart();
        {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            time = time.withHour(10);
            LocalDateTime datetime = date.atTime(time);

            System.out.println("date = " + date);
            System.out.println("time = " + time);
            System.out.println("datetime = " + datetime);

        }

        printPart();
        {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            LocalDateTime datetime = time.atDate(date);

            System.out.println("date = " + date);
            System.out.println("time = " + time);
            System.out.println("datetime = " + datetime);
        }

        printPart();
        {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            System.out.println("dateTime = " + dateTime);
        }

        printPart();
        {
            LocalDateTime datetime = LocalDateTime.now();
            LocalDate date = datetime.toLocalDate();
            LocalTime time = datetime.toLocalTime();

            System.out.println("date = " + date);
            System.out.println("time = " + time);
            System.out.println("datetime = " + datetime);
        }

        printSubSectionEnding();
    }

    private static void program_21() {
        printSubSection("Program_21. LocalDateTime");

        printPart();
        {

        }

        printSubSectionEnding();
    }

    private static void program_30() {
        printSubSection("Program_30. Instant");

        printPart();
        {
            Instant instant = Instant.now();
            System.out.println("instant = " + instant);

            instant = Instant.ofEpochSecond(2_000_000_000L);
            System.out.println("instant = " + instant);

            instant = Instant.ofEpochMilli(2_000_000_000_000L);
            System.out.println("instant = " + instant);

            instant = Instant.ofEpochSecond(-2_000_000_000L);
            System.out.println("instant = " + instant);

            System.out.println("instant.getEpochSecond() = " + instant.getEpochSecond());

            System.out.println("Instant.MIN.getEpochSecond() = " + Instant.MIN.getEpochSecond());
            System.out.println("Instant.MAX.getEpochSecond() = " + Instant.MAX.getEpochSecond());
            System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
            System.out.println("Instant.MAX.getNano() = " + Instant.MAX.getNano());
            System.out.println("Instant.MIN.getNano() = " + Instant.MIN.getNano());
        }

        printSubSectionEnding();
    }

    private static void program_31() {
        printSubSection("Program_31. Instant");

        printPart();
        {

        }

        printSubSectionEnding();
    }

    private static void program_35() {
        printSubSection("Program_35. ZoneId, ZoneDateTime");

        printPart();
        {

            System.out.println("Количество зон: " + ZoneId.getAvailableZoneIds().size());

//            for (String zone : ZoneId.getAvailableZoneIds()) {
//                System.out.println("zone = " + zone);
//            }

            ZoneId myZone = ZoneId.of("Europe/Moscow");
            System.out.println("myZone = " + myZone);
        }

        printPart();
        {
            LocalDateTime ldt = LocalDateTime.now();
            ZoneId myZone = ZoneId.of("Europe/Moscow");
            ZonedDateTime datetime = ZonedDateTime.of(ldt, myZone);

            System.out.println("ldt = " + ldt);
            System.out.println("datetime = " + datetime);
        }

        printPart();
        {
            ZoneId africaZone = ZoneId.of("Africa/Cairo");
            ZonedDateTime africa = ZonedDateTime.of(LocalDateTime.now(), africaZone);

            System.out.println("africa = " + africa);

            System.out.println("africa.toLocalDateTime() = " + africa.toLocalDateTime());

        }

        printPart();
        {
            ZonedDateTime myZone = ZonedDateTime.now();
            System.out.println("myZone.getZone() = " + myZone.getZone());
        }

        printPart();
        {
            LocalDateTime datetime = LocalDateTime.now();
            ZonedDateTime myZone = ZonedDateTime.now();

            System.out.println("datetime = " + datetime);
            System.out.println("myZone = " + myZone);

            ZonedDateTime inAfriceNow = myZone.withZoneSameInstant(ZoneId.of("Africa/Cairo"));
            System.out.println("inAfriceNow = " + inAfriceNow);

            ZonedDateTime inMyZone = inAfriceNow.withZoneSameLocal(ZoneId.of("Africa/Cairo"));
            System.out.println("inMyZone = " + inMyZone);
        }

        printPart("Зона относительно зоны");
        {

//            withZoneSameInstant() - возвращает ZoneDateTime с учетом другой зоной, то есть
//            с изменением локального времени

//            withZoneSameLocal() - изменяет часовую зону объекта, локальное время не изменяется

            ZoneId zone1 = ZoneId.of("Africa/Cairo");
            ZoneId zone2 = ZoneId.of("Etc/GMT-8");
            ZoneId zone3 = ZoneId.of("America/Anchorage");
            ZoneId myZone = ZoneId.of("Europe/Moscow");

            LocalDateTime mydatetime = LocalDateTime.of(2020, 10, 20, 14, 0);
            ZonedDateTime myzdt = ZonedDateTime.of(mydatetime, myZone);
            System.out.println("mydatetime: \t\t" + mydatetime);
            System.out.println("myzdt:  \t\t\t" + myzdt);

            ZonedDateTime africa = myzdt.withZoneSameInstant(zone1);
            System.out.println("africa: \t\t\t" + africa);

            ZonedDateTime etc = myzdt.withZoneSameInstant(zone2);
            System.out.println("etc+8: \t\t\t\t" + etc);

            ZonedDateTime america = myzdt.withZoneSameInstant(zone3);
            System.out.println("america: \t\t\t" + america);

            printNewLine();
            System.out.println(america.withZoneSameInstant(myZone));

            ZonedDateTime temp = ZonedDateTime.of(LocalDateTime.of(2010, 10, 10, 10, 0), zone3);
            System.out.println(temp);
            System.out.println(temp.withZoneSameInstant(myZone));

        }

        printSubSectionEnding();
    }

    private static void program_40() {
        printSection("Program_40. DateTimeFormatter patterns, format()");
//      DateTimeFormatter определяет шаблон форматирования времени и даты в виде строки

        LocalDateTime ldt = LocalDateTime.of(2020, 5, 5, 15, 15, 15, 500);
        DateTimeFormatter dtf;

        System.out.println("ldt = " + ldt);

        printSubSection("Year:");
        {
            for (int i = 1990; i <= 2010; i++) {
                LocalDateTime temp = ldt.withYear(i);

                dtf = DateTimeFormatter.ofPattern("yy");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("yyyy");
                System.out.print("\t" + dtf.format(temp));

                if (i % 3 == 0)
                    System.out.println();
            }
        }

        printSubSection("Day:");
        {
            for (int i = 1; i <= 30; i++) {
                LocalDateTime temp = ldt.withDayOfMonth(i);

                dtf = DateTimeFormatter.ofPattern("d");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("dd");
                System.out.print("\t" + dtf.format(temp));

                if (i % 6 == 0)
                    System.out.println();
            }
        }

        printSubSection("Day of week:");
        {
            for (int i = 1; i <= 30; i++) {
                LocalDateTime temp = ldt.withDayOfMonth(i);

                dtf = DateTimeFormatter.ofPattern("E");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("EEEE");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("EEEEE");
                System.out.print("\t" + dtf.format(temp));

                if (i % 3 == 0)
                    System.out.println();
            }
        }

        printSubSection("Day of week:");
        {
//          Длины недели начинаются с воскресенья

            for (int i = 1; i <= 30; i++) {
                LocalDateTime temp = ldt.withDayOfMonth(i);

                dtf = DateTimeFormatter.ofPattern("e");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("ee");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("eeeee");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("eee");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("eeee");
                System.out.print("\t" + dtf.format(temp));

                if (i % 3 == 0)
                    System.out.println();
            }
        }

        printSubSection("Month:");
        {
            for (int i = 1; i <= 12; i++) {
                LocalDateTime temp = ldt.withMonth(i);

                dtf = DateTimeFormatter.ofPattern("M");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("MM");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("MMMMM");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("MMM");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("MMMM");
                System.out.println("\t\t" + dtf.format(temp));
            }
        }

        printSubSection("Week:");
        {
            for (int i = 1; i <= 30; i++) {
                LocalDateTime temp = ldt.withDayOfMonth(i);

                dtf = DateTimeFormatter.ofPattern("W");
                System.out.print("\t" + dtf.format(temp));

                dtf = DateTimeFormatter.ofPattern("w");
                System.out.print("\t" + dtf.format(temp));

                if (i % 10 == 0)
                    System.out.println();
            }
        }

        printSubSection("Day-Month-Year");
        {
            dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate temp = LocalDate.now();

            System.out.println(dtf.format(temp));
            System.out.println(dtf.parse("19/03/1999"));

            LocalDate parsed = LocalDate.parse("1999-03-19");
            System.out.println("parsed = " + parsed);

            parsed = LocalDate.parse("19/03/1999", dtf);
            System.out.println("parsed = " + parsed);

            temp = LocalDate.parse("1999-03-19", DateTimeFormatter.ISO_DATE);
            System.out.println("temp = " + temp);
        }


        printSubSection("Hours");
        {

        }

        printSubSection("test parse");
        {
            LocalDate now = LocalDate.now();
            DateTimeFormatter myDTF = DateTimeFormatter.ofPattern("EEEE-yyyy-MM");

            String date = myDTF.format(now);
            System.out.println(myDTF.parse(date));

            String text = "Friday-2023-11";

            System.out.println(myDTF.parse(text));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy");
            String dt = formatter.format(LocalDate.now());
            System.out.println("dt = " + dt);

            LocalDate ld = LocalDate.parse("17/Dec/24",formatter);
            System.out.println(ld);
        }

        printSubSection("pars of DayOfWeek by DateTimeFormatter"); {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
           String dayOfWeek = formatter.format(LocalDate.now().getDayOfWeek());
           System.out.println("dayOfWeek = " + dayOfWeek);
        }

        printSectionEnding();
    }

    private static void program_41() {
        printSection("Program_41. DateTimeFormatter");

        printSubSection("");
        {

        }

        printSubSection("");
        {

        }

        printSectionEnding();
    }

    private static void program_45() {
        printSection("Program_45. Duration");

        LocalTime now = LocalTime.now();
        LocalTime after = now.plusHours(10).plusMinutes(10).plusSeconds(10);
        after = after.plusNanos(1000321);

        Duration dur = Duration.between(now, after);

        System.out.println("now = " + now);
        System.out.println("after = " + after);
        System.out.println("dur = " + dur);

        printSectionEnding();
    }

    private static void program_46() {
        printSection("Program_46. Period");

        LocalDate now = LocalDate.now();
        LocalDate after = now.plusDays(10).plusWeeks(3);
        after = after.plusYears(1).plusMonths(3);

        Period period = Period.between(now, after);

        System.out.println("now = " + now);
        System.out.println("after = " + after);
        System.out.println("period = " + period);

        printSectionEnding();
    }

    private static void program_47() {
        printSection("Program_47. Period");


        printSectionEnding();
    }
}













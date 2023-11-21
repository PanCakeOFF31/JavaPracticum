package freePractise.enumeration;

import static helpers.Helpers.*;

public class EnumerationBasis {
    private static MonthOfYearSimple month;

    static void enumerationBasis() {
        printSection("Базовые методы enumeration values(), valueOf(), ordinal()");

        printSubSection("MonthOfYearSimple");
        month = MonthOfYearSimple.JANUARY;

        System.out.println(month);
        System.out.println(MonthOfYearSimple.valueOf("JANUARY"));
        System.out.println(month.name());
        System.out.println(month.ordinal());

        month = MonthOfYearSimple.FEBRUARY;
        System.out.println(month.ordinal());

        for (MonthOfYearSimple value : MonthOfYearSimple.values()) {
            System.out.println(value);
        }

        printSubSectionEnding();
        printSubSection("MonthOfYear");

        int command = 0;
        MonthOfYear monthOfYear = MonthOfYear.values()[command];
        System.out.print("Вы выбрали " + (command + 1) + "-й элемент перечисления - ");
        System.out.println(monthOfYear.toString());

        System.out.println(MonthOfYear.JANUARY == monthOfYear);

        int menuOption = 2;  // MARCH
        switch (getMonthOfYear(menuOption)) {
            case JANUARY:
                System.out.println("Вы выбрали январь");
                break;
            case FEBRUARY:
                System.out.println("Вы выбрали Февраль");
                break;
        }
//        System.out.println(MonthOfYear.JANUARY.ordinal());
//        System.out.println(MonthOfYear.JANUARY.getOrder());
        printSubSectionEnding();
        printSectionEnding();

    }

    private static MonthOfYear getMonthOfYear(int order) {
        MonthOfYear[] months = MonthOfYear.values();
        return months[order];
    }

}

//  Переменные типа последовательности могут принимать только одно значение из списка констант
enum MonthOfYearSimple {
    JANUARY,
    FEBRUARY,
    MARCH;
}

enum MonthOfYear {
    JANUARY(1), FEBRUARY(2), MARCH(3);
    private final int order;

    /*    MARCH,
        APRIL,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER;*/
    MonthOfYear(int order) {
        this.order = MonthOfYear.this.order;
    }

    int getOrder() {
        return this.order;
    }
}

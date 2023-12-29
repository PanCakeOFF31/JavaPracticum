package freePractise.enumeration;

import helpers.coloredString.Logger;

import java.util.Arrays;
import java.util.function.Supplier;

public class EnumerationAdditional {
    public static void main(String[] args) {
//        A a = new A(10);
//        System.out.println("a = " + a);
//        A copy = foo(a::getMyCopy);
//        System.out.println("copy = " + copy);

        Logger.printMessage("");
        {
            Day day = Day.MONDAY;
            foo1(day);
            foo2(Day.MONDAY);

            Day day2 = Day.WENSDEY;
            foo1(day);
            foo2(Day.WENSDEY);
        }

        Logger.printMessage("");
        {
            foo3(Day.MONDAY);
            foo3(Week.FRIDAY);
        }

        Logger.printMessage("Все элементы перечисления");
        {
            foo4(Day.values());
            foo5(Week.values());
        }

        Logger.printMessage("");
        {
            foo6(Week.FRIDAY);
        }
    }

    enum Day implements SpecifisImpl {
        MONDAY,
        WENSDEY;


        @Override
        public void doSMTH() {
            System.out.println("do smthng");
        }
    }

    enum Week implements SpecifisImpl {
        MONDAY,
        FRIDAY;

        @Override
        public void doSMTH() {
            System.out.println("do smthng");
        }
    }

    private static A foo(Supplier<A> supplier) {
        return supplier.get();
    }

    private static void foo1(Enum<Day> enumeration) {
        System.out.println(enumeration);
    }

    private static void foo2(Day day) {
        System.out.println(day);
    }

    private static void foo3(Enum<?> enumeration) {
        System.out.println(enumeration);
        System.out.println(enumeration.ordinal());
    }

    private static void foo4(Enum<?>[] enumConstants) {
        System.out.println(Arrays.toString(enumConstants));
    }

    private static <T extends Enum<T>> void foo5(Enum<T>[] enumConstants) {
        System.out.println(Arrays.toString(enumConstants));
    }

    private static void foo6(SpecifisImpl enumeration) {
        System.out.println(enumeration);
        enumeration.doSMTH();
    }
}

class A {
    int a;

    public A(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }
}

interface SpecifisImpl {
    void doSMTH();
}

package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_4;

import static helpers.Helpers.*;


public class Practicum_4 {
    public static void practicum_4() {
        printSection("Practicum_4");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Практикуемся с объектами");

        Hamster bite = new Hamster();
        Hamster ninja = new Hamster();
        Hamster kyza = new Hamster();
        Hamster paskal = new Hamster();

        System.out.println("Hamster #1");
        bite.printName();

        System.out.println("Hamster #2");
        ninja.name = "Ниндзя";
        ninja.printName();

        System.out.println("Hamster #3");
        ninja.name = "Кузя";
        kyza.printName();

        System.out.println("Hamster #4");
        paskal.name = "Паскаль";
        paskal.printName();

        // Суперхомяк был создан, чтобы вспомнить работу и разницу модификаторов доступа protected and default
        System.out.println("SuperHamster #1");
        SuperHamster superBite = new SuperHamster();
        superBite.printName();
        superBite.pritnSuperName();

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}


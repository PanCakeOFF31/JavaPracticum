package headFirst.chapter_10_state;

import headFirst.chapter_10_state.gum_v1.GumballMachine;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_10_state {
    public static void chapter_10() {
        printArticle("State Pattern");

//        program_1();
        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. gum_v1");

        GumballMachine machine = new GumballMachine(5);
        System.out.println(machine);

        machine.insertQuarter();
        machine.turnCrank();
        System.out.println(machine);

        machine.turnCrank();
        System.out.println(machine);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. gum_v2");

        var machine = new headFirst.chapter_10_state.gum_v2.machine.GumballMachine(10);

        Logger.printMessage("NoQuarterState");
        {
            machine.turnCrank();
            machine.ejectQuarter();
            machine.releaseBall();
        }

        Logger.printMessage("Вставляем моменту");

        machine.insertQuarter();
        Logger.printMessage("HasQuarterState");
        {
            machine.turnCrank();
            machine.ejectQuarter();
        }

        Logger.printMessage("Проверка приза");
        {
            machine.insertQuarter();
            machine.turnCrank();
        }

        printSectionEnding();
    }
}

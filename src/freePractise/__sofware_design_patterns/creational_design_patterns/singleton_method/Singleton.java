package freePractise.__sofware_design_patterns.creational_design_patterns.singleton_method;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Singleton {
    public static void singletonMethod() {
        printSection("Singleton Method");

        Logger.printMessage("Вариант одиночки №1",Colors.BLUE);
        {
            SinglObjectV1 instance1 = SinglObjectV1.getInstance();
            SinglObjectV1 instance2 = SinglObjectV1.getInstance();

            instance1.printInfo();
            instance2.printInfo();
        }

        Logger.printMessage("Вариант одиночки №2", Colors.BLUE);
        {
            SingleObjectV2 instance1 = SingleObjectV2.getInstance();
            SingleObjectV2 instance2 = SingleObjectV2.getInstance();

            instance1.printInfo();
            instance2.printInfo();
        }

        printSectionEnding();
    }
}



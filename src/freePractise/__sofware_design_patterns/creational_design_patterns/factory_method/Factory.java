package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method;

import freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars.Car;
import freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars.CarSelector;
import freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.currencies.Currency;
import helpers.coloredString.Logger;

import static freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars.CarSelector.*;
import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Factory {
    public static void factoryMethod() {
        printSection("Factory Method");

        Logger.printMessage("Пример реализации с сайта");
        {
            Currency rubleCurrency = CurrencyFactory.createCurrency("Russia");
            Currency dollarCurrency = CurrencyFactory.createCurrency("USA");
            Currency germanCurrency = CurrencyFactory.createCurrency("German");

            System.out.println("rubleCurrency = " + rubleCurrency.getSymbol());
            System.out.println("dollarCurrency = " + dollarCurrency.getSymbol());
            System.out.println("germanCurrency = " + germanCurrency.getSymbol());
        }

        Logger.printMessage("Пример с YouTube - java-begin");
        {
            Car car1 = CarFactory.getCar(PORSCHE);
            Car car2 = CarFactory.getCar(GEEP);
            Car car3 = CarFactory.getCar(POWERGEEP);

            System.out.println("car1 = " + car1);
            System.out.println("car2 = " + car2);
            System.out.println("car3 = " + car3);
        }

        printSectionEnding();

    }
}

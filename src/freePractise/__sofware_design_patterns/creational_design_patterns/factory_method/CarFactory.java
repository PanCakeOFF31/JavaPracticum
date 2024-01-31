package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method;

import freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars.*;

// Фабричный метод по созданию автомобилей
public class CarFactory {

    public static Car getCar(CarSelector selector) {
        return switch (selector) {
            case GEEP -> new Geep();
            case PORSCHE -> new Porsche();
            case POWERGEEP -> new PowerGeep();
            default -> throw new IllegalArgumentException();
        };
    }
}

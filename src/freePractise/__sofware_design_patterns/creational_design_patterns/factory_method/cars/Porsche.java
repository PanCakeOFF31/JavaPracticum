package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars;

public class Porsche implements Car {
    @Override
    public void drive() {
        System.out.println("Порше едет");
    }

    @Override
    public void stop() {
        System.out.println("Порше останавливается");
    }

    @Override
    public String toString() {
        return "Porsche";
    }
}
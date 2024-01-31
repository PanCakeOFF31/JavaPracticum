package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars;

public class Geep implements Car {

    @Override
    public void drive() {
        System.out.println("Джип едет");
    }

    @Override
    public void stop() {
        System.out.println("Джип останавливается");
    }

    @Override
    public String toString() {
        return "Geep";
    }
}

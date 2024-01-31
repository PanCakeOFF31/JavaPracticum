package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.cars;

public class PowerGeep extends Geep {
    public void superStart() {
        System.out.println("Супер ускорение");
    }
    @Override
    public String toString() {
        return "PowerGeep";
    }
}

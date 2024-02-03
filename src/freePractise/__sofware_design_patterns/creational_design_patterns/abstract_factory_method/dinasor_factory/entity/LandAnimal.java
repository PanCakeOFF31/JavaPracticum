package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;

public class LandAnimal extends Animal {
    @Override
    void create() {
        System.out.println("Creating land animal a " + this.type + " animal: " + this.name);
    }

    public LandAnimal(AnimalEra era, String name) {
        super(AnimalType.LAND, era, name);
        create();
    }
}

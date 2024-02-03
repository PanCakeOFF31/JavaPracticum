package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;

public class SkyAnimal extends Animal {
    @Override
    void create() {
        System.out.println("Creating sky animal a " + this.type + " animal: " + this.name);
    }

    public SkyAnimal(AnimalEra era, String name) {
        super(AnimalType.SKY, era, name);
        create();
    }
}

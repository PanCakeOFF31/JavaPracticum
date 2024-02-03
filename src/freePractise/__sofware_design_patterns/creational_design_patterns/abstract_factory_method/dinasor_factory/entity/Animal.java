package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;

public abstract class Animal {
    AnimalType type;
    AnimalEra era;
    String name;

    public Animal(AnimalType type, AnimalEra era, String name) {
        this.type = type;
        this.era = era;
        this.name = name;
    }

    abstract void create();
}

package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.Animal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.era.CenozoicAnimalFactory;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.era.MesozoicAnimalFactory;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;

public class AnimalAbstractFactory {
    private Animal animal;
    private AnimalEra configuration = AnimalEra.MESOZOIC;

    public Animal createAnimal(AnimalType type) {
        AnimalEra era = getFromConfiguration();

        switch (era) {
            case CENOZOIC -> animal = new CenozoicAnimalFactory().createAnimal(type);
            case MESOZOIC -> animal = new MesozoicAnimalFactory().createAnimal(type);
            default -> throw new IllegalArgumentException();
        }

        return animal;
    }

    private AnimalEra getFromConfiguration() {
        return configuration; // Default configuration
    }

    public AnimalAbstractFactory setConfiguration(AnimalEra era) {
        configuration = era;
        return this;
    }
}

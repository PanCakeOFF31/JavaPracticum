package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.era;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.Animal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.LandAnimal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.SkyAnimal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;

public class MesozoicAnimalFactory implements EraAnimalFactory {
    @Override
    public LandAnimal makeLandAnimal() {
        return new LandAnimal(AnimalEra.MESOZOIC, "Tyrannosaurus Rex");
    }

    @Override
    public SkyAnimal makeSkyAnimal() {
        return new SkyAnimal(AnimalEra.MESOZOIC, "Pterodactylus");
    }

    public Animal createAnimal(AnimalType type) {
        return switch (type) {
            case LAND -> makeLandAnimal();
            case SKY -> makeSkyAnimal();
        };
    }
}

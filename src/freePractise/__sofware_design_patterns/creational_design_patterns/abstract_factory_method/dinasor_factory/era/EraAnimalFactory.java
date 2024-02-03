package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.era;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.LandAnimal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.SkyAnimal;

public interface EraAnimalFactory {
    LandAnimal makeLandAnimal();
    SkyAnimal makeSkyAnimal();
}

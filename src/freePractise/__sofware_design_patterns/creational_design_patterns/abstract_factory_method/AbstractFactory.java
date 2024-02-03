package freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method;

import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.AnimalAbstractFactory;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.entity.Animal;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalEra;
import freePractise.__sofware_design_patterns.creational_design_patterns.abstract_factory_method.dinasor_factory.selector.AnimalType;
import helpers.coloredString.Logger;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class AbstractFactory {
    public static void abstractFactory() {
        printSection("Abstract Factory Method");

        Logger.printMessage("Динозавры и эры");
        {
//            По молчанию создаются объекты с типом MESOZOIC
            AnimalAbstractFactory factory = new AnimalAbstractFactory();

            Animal animal1 = factory.createAnimal(AnimalType.LAND);
            Animal animal2 = factory.createAnimal(AnimalType.SKY);

//            Изменение конфигурации типов порождаемых объектов - CENOZOIC
            factory = factory.setConfiguration(AnimalEra.CENOZOIC);

            Animal animal3 = factory.createAnimal(AnimalType.LAND);
            Animal animal4 = factory.createAnimal(AnimalType.SKY);

        }

        Logger.printMessage("YouTube пример");
        {

        }

        printSectionEnding();
    }
}

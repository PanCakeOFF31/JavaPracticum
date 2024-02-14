package freePractise.__sofware_design_patterns.creational_design_patterns;

import freePractise.__sofware_design_patterns.creational_design_patterns.builder_method.BuilderPattern;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class CreationalPatterns {
    public static void creationalPattern() {
        printSection("Creational Design Patterns");

//       "Одиночка"
//        Singleton.singletonMethod();
//      "Фабричный метод"
//        Factory.factoryMethod();


//      "Абстрактная фабрика"
//        AbstractFactory.abstractFactory();


//        "Прототип"
//        Prototype.prototypeMethod();
//        "Строитель"
        BuilderPattern.builderMethod();

        printSectionEnding();

    }
}

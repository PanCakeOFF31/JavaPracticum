package freePractise.__sofware_design_patterns.structaral_design_patterns;

import freePractise.__sofware_design_patterns.structaral_design_patterns.structural_methods.*;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class StructuralPatterns {
    public static void structuralPatterns() {
        printSection("Structural Patterns");

        Adapter.adapterMethod();
        Bridge.bridgeMethod();
        Composite.compositeMethod();
        Decarator.decoratorMethod();
        Facade.facadeMEthod();
        Flyweight.flyweightMethod();
        Proxy.proxyMethod();

        printSectionEnding();

    }
}

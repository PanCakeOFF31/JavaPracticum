package freePractise.__sofware_design_patterns.behavioral_design_patterns;

import freePractise.__sofware_design_patterns.behavioral_design_patterns.behavioral_methods.*;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class BehavioralPatterns {
    public static void behavioralPatterns() {
        printSection("Behavioral Design Pattern");

        ChainOfResponsibility.chainOfResponsibilityMethod();
        Command.commandMethod();
        Interpreter.interpreterMethod();
        Mediator.mediatorMethod();
        Memento.mementoMethod();
        Observer.observerMethod();
        State.stateMethod();
        Strategy.strategyMethod();
        Template.templateMethod();
        Visitor.visitorMethod();

        printSectionEnding();

    }
}

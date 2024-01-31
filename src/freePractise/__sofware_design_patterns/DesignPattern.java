package freePractise.__sofware_design_patterns;

import freePractise.__sofware_design_patterns.behavioral_design_patterns.BehavioralPatterns;
import freePractise.__sofware_design_patterns.creational_design_patterns.CreationalPatterns;
import freePractise.__sofware_design_patterns.structaral_design_patterns.StructuralPatterns;

import static helpers.Helpers.*;

public class DesignPattern {
    public static void patternClass() {
        printArticle("Software Design Patterns - паттерны проектирования ПО");

        CreationalPatterns.creationalPattern();
//        StructuralPatterns.structuralPatterns();
//        BehavioralPatterns.behavioralPatterns();

        printArticleEnding();
    }

}

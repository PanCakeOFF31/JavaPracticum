package headFirst.chapter_4_factory.pizza_store_v2.factory;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.*;

public abstract class SimplePizzaFactory {
//    public Pizza createPizza(String type) {
//        return switch (type) {
//            case "cheese" -> new CheesePizza();
//            case "pepperoni" -> new Pepperoni();
//            case "clam" -> new ClamPizza();
//            case "veggie" -> new VeggiePizza();
//            default -> throw new IllegalStateException("Unexpected value: " + type);
//        };
//    }

    public abstract Pizza createPizza(String type);
}
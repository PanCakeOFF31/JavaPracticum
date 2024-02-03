package headFirst.chapter_4_factory.pizza_store_v2.factory;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.NewYork.*;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;

public class NewYorkPizzaFactory extends SimplePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new NewYorkCheesePizza();
            case "pepperoni" -> new NewYorkPepperoniPizza();
            case "clam" -> new NewYorkClamPizza();
            case "veggie" -> new NewYorkVeggiePizza();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

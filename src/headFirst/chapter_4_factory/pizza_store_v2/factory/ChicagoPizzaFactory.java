package headFirst.chapter_4_factory.pizza_store_v2.factory;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.Chicago.ChicagoCheesePizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Chicago.ChicagoClamPizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Chicago.ChicagoPepperoniPizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Chicago.ChicagoVeggiePizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;

public class ChicagoPizzaFactory extends SimplePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new ChicagoCheesePizza();
            case "pepperoni" -> new ChicagoPepperoniPizza();
            case "clam" -> new ChicagoClamPizza();
            case "veggie" -> new ChicagoVeggiePizza();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

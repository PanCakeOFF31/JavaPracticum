package headFirst.chapter_4_factory.pizza_store_v2.factory;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.California.CaliforniaCheesePizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.California.CaliforniaClamPizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.California.CaliforniaPepperoniPizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.California.CaliforniaVeggiePizza;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;

public class CaliforniaPizzaFactory extends SimplePizzaFactory{
    @Override
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new CaliforniaCheesePizza();
            case "pepperoni" -> new CaliforniaPepperoniPizza();
            case "clam" -> new CaliforniaClamPizza();
            case "veggie" -> new CaliforniaVeggiePizza();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}

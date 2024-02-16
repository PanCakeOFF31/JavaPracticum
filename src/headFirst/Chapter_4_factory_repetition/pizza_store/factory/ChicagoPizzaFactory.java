package headFirst.Chapter_4_factory_repetition.pizza_store.factory;

import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.Pizza;
import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.PizzaType;

public class ChicagoPizzaFactory {
    public Pizza create(PizzaType type) {
        return new ChicagoPizzaFactory().create(type);
    }
}

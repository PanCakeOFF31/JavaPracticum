package headFirst.Chapter_4_factory_repetition.pizza_store;

import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.Pizza;
import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.PizzaType;

public abstract class PizzaStore {
    public Pizza orderPizza(PizzaType type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);
}

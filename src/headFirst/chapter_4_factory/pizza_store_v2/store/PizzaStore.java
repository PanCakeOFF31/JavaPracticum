package headFirst.chapter_4_factory.pizza_store_v2.store;

import headFirst.chapter_4_factory.pizza_store_v2.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;

public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}

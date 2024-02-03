package headFirst.chapter_4_factory.pizza_store_v1.store;

import headFirst.chapter_4_factory.pizza_store_v1.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v1.pizza.*;

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

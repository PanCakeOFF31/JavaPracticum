package headFirst.Chapter_4_factory_repetition.pizza_store;

import headFirst.Chapter_4_factory_repetition.pizza_store.factory.NewYorkPizzaFactory;
import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.Pizza;
import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.PizzaType;

public class NewYorkPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(PizzaType type) {
        return new NewYorkPizzaFactory().create(type);
    }
}

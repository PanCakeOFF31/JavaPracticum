package headFirst.chapter_4_factory.pizza_store_v3.store;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.ChicagoPizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        ingredientFactory = new ChicagoPizzaIngredientFactory();
        simplePizzaFactory = new SimplePizzaFactory(ingredientFactory);

        return simplePizzaFactory.createPizza(type);
    }
}

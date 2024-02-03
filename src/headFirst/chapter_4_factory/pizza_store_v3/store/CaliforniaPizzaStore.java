package headFirst.chapter_4_factory.pizza_store_v3.store;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.CaliforniaPizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        ingredientFactory = new CaliforniaPizzaIngredientFactory();
        simplePizzaFactory = new SimplePizzaFactory(ingredientFactory);

        return simplePizzaFactory.createPizza(type);
    }
}

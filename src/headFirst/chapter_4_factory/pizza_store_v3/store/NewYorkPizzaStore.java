package headFirst.chapter_4_factory.pizza_store_v3.store;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.NewYorkPizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;

public class NewYorkPizzaStore extends PizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;

        ingredientFactory = new NewYorkPizzaIngredientFactory();
        simplePizzaFactory = new SimplePizzaFactory(ingredientFactory);

        pizza = simplePizzaFactory.createPizza(type);
        pizza.setName("New York Style " + pizza.getName());

        return pizza;
    }
}

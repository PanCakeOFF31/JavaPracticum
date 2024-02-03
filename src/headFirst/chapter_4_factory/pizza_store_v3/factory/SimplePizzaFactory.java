package headFirst.chapter_4_factory.pizza_store_v3.factory;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.PizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.type.*;

public class SimplePizzaFactory {
    protected PizzaIngredientFactory ingredientFactory;

    public SimplePizzaFactory(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    public Pizza createPizza(String type) {
        Pizza pizza;

        switch (type) {
            case "cheese" -> {
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Cheese Pizza");
            }
            case "pepperoni" -> {
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Pepperoni Pizza");
            }
            case "clam" -> {
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("Clam Pizza");
            }
            case "veggie" -> {
                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("Veggie");
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }

        return pizza;
    }

//    public abstract Pizza createPizza(String type);
}
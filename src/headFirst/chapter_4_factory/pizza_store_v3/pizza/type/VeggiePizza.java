package headFirst.chapter_4_factory.pizza_store_v3.pizza.type;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.PizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class VeggiePizza extends Pizza {
    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        Logger.printMessage("Preparing " + this.name, Colors.BLACK);

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}

package headFirst.chapter_4_factory.pizza_store_v3.pizza.type;

import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.PizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class CheesePizza extends Pizza {
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        Logger.printMessage("Preparing " + this.name, Colors.BLACK);

        System.out.println("Кладем в пиццу: тесто, соус, сыр");

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}

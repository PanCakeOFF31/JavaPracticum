package headFirst.chapter_4_factory.pizza_store_v3.pizza;

import headFirst.chapter_4_factory.pizza_store_v3.engridient.base.*;
import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.PizzaIngredientFactory;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    @Setter
    @Getter
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;
    protected Veggies veggies[];
    protected List<String> toppings = new ArrayList<>();
    protected PizzaIngredientFactory ingredientFactory;

    //    public void prepare() {
//        Logger.printMessage("Preparing", Colors.BLACK);
//        System.out.println("Tossing dough " + this.dough);
//        System.out.println("Adding sauce" + this.sauce);
//        System.out.println("Adding toppings:");
//        toppings.forEach(topping -> System.out.println("  Topping: " + topping));
//    }
    public abstract void prepare();

    public void bake() {
        Logger.printMessage("Baking", Colors.BLACK);
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        Logger.printMessage("Cutting", Colors.BLACK);
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        Logger.printMessage("Boxing", Colors.BLACK);
        System.out.println("Place pizza in official PizzaStore box");
    }


}

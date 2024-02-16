package headFirst.Chapter_4_factory_repetition;

import headFirst.Chapter_4_factory_repetition.pizza_store.ChicagoPizzaStore;
import headFirst.Chapter_4_factory_repetition.pizza_store.NewYorkPizzaStore;
import headFirst.Chapter_4_factory_repetition.pizza_store.PizzaStore;
import headFirst.Chapter_4_factory_repetition.pizza_store.pizza.PizzaType;

import static helpers.Helpers.*;

public class Chapter_4_Factory_Repetition {
    public static void chapter_4() {
        printArticle("Factory");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Factory");

        PizzaStore store;

        {
            store = new NewYorkPizzaStore();
            store.orderPizza(PizzaType.ClamPizza);
            store.orderPizza(PizzaType.VeggiePizza);
        }

        {
            store = new ChicagoPizzaStore();
            store.orderPizza(PizzaType.CheesePizza);
            store.orderPizza(PizzaType.PepperoniPizza);
        }

        printSectionEnding();
    }
}

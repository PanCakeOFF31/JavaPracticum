package headFirst.chapter_4_factory;

//import headFirst.chapter_4_factory.pizza_store_v1.factory.SimplePizzaFactory;
//import headFirst.chapter_4_factory.pizza_store_v1.store.PizzaStore;

import headFirst.chapter_4_factory.pizza_store_v2.factory.CaliforniaPizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v2.factory.ChicagoPizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v2.factory.NewYorkPizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v3.store.NewYorkPizzaStore;
import headFirst.chapter_4_factory.pizza_store_v3.store.PizzaStore;
import headFirst.chapter_4_factory.pizza_store_v3.store.CaliforniaPizzaStore;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_4_Factory {
    public static void chapter_4() {
        printArticle("Chapter 4 . Factory");

        program_1();
        program_2();
        program_3();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. pizza_store_v1");


//        Logger.printMessage("Pizza_store_v1");
//        {
//            PizzaStore store = new PizzaStore(new SimplePizzaFactory());
//
//            Logger.printMessage("Заказывается cheese pizza");
//            store.orderPizza("cheese");
//
//            Logger.printMessage("Заказывается clam pizza");
//            store.orderPizza("clam");
//        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. pizza_store_v2");

//        Logger.printMessage("Pizza_store_v2");
//        {
//            PizzaStore store = new PizzaStore(new NewYorkPizzaFactory());
//            store.orderPizza("cheese");
//
//            store = new PizzaStore(new CaliforniaPizzaFactory());
//            store.orderPizza("veggie");
//
//            store = new PizzaStore(new ChicagoPizzaFactory());
//            store.orderPizza("clam");
//        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. pizza_store_v3");

        Logger.printMessage("Pizza_store_v3");
        {
            PizzaStore store = new NewYorkPizzaStore();
            store.orderPizza("cheese");
        }

        printSectionEnding();
    }
}

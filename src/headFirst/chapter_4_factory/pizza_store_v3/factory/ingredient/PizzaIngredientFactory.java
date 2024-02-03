package headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient;

import headFirst.chapter_4_factory.pizza_store_v3.engridient.base.*;

public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}

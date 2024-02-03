package headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient;

import headFirst.chapter_4_factory.pizza_store_v3.engridient.base.*;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.cheese.ReggianoCheese;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.clams.FreshClams;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.dough.ThinCrustDough;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.pepperoni.SlicedPepproni;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.sauce.MarinaraSauce;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.veggies.Garlic;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.veggies.Mushroom;
import headFirst.chapter_4_factory.pizza_store_v3.engridient.specific.veggies.Onion;

public class NewYorkPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Garlic(), new Onion(), new Mushroom()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepproni();
    }

    @Override
    public Clams createClams() {
        return new FreshClams();
    }
}

package headFirst.chapter_4_factory.pizza_store_v3.store;

import headFirst.chapter_4_factory.pizza_store_v3.factory.SimplePizzaFactory;
import headFirst.chapter_4_factory.pizza_store_v3.factory.ingredient.PizzaIngredientFactory;
import headFirst.chapter_4_factory.pizza_store_v3.pizza.Pizza;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class PizzaStore {
//    Это нужно для абстрактной фабрики продуктов - ингридиенты пиццы
    protected PizzaIngredientFactory ingredientFactory;
    protected SimplePizzaFactory simplePizzaFactory;

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

//    Фабричный метод - реализуется наследниками
    protected abstract Pizza createPizza(String type);

}

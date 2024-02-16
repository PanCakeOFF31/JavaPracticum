package headFirst.Chapter_4_factory_repetition.pizza_store.pizza;

public class SimplePizzaFactory {
    public Pizza createPizza(PizzaType type) {
        return switch (type) {
            case CheesePizza -> new CheesePizza();
            case PepperoniPizza -> new PepperoniPizza();
            case ClamPizza -> new ClamPizza();
            case VeggiePizza -> new VeggiePizza();
        };
    }
}

package headFirst.chapter_4_factory.pizza_store_v2.pizza.Chicago;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;
import helpers.coloredString.Logger;

public abstract class ChicagoPizza extends Pizza {
    @Override
    public void prepare() {
        Logger.printMarkMessage(false, "Chicago");
        super.prepare();
    }

    @Override
    public void bake() {
        Logger.printMarkMessage(false, "Chicago");
        super.bake();
    }

    @Override
    public void cut() {
        Logger.printMarkMessage(false, "Chicago");
        super.cut();
    }

    @Override
    public void box() {
        Logger.printMarkMessage(false, "Chicago");
        super.box();
    }
}

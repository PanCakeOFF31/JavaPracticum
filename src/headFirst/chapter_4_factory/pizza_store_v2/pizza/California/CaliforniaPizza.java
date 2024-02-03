package headFirst.chapter_4_factory.pizza_store_v2.pizza.California;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;
import helpers.coloredString.Logger;

public abstract class CaliforniaPizza extends Pizza {
    @Override
    public void prepare() {
        Logger.printMarkMessage(false, "California");
        super.prepare();
    }

    @Override
    public void bake() {
        Logger.printMarkMessage(false, "California");
        super.bake();
    }

    @Override
    public void cut() {
        Logger.printMarkMessage(false, "California");
        super.cut();
    }

    @Override
    public void box() {
        Logger.printMarkMessage(false, "California");
        super.box();
    }
}

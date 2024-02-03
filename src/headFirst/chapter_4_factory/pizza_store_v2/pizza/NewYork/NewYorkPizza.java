package headFirst.chapter_4_factory.pizza_store_v2.pizza.NewYork;

import headFirst.chapter_4_factory.pizza_store_v2.pizza.Pizza;
import helpers.coloredString.Logger;

public abstract class NewYorkPizza extends Pizza {
    @Override
    public void prepare() {
        Logger.printMarkMessage(false, "NewYork");
        super.prepare();
    }

    @Override
    public void bake() {
        Logger.printMarkMessage(false, "NewYork");
        super.bake();
    }

    @Override
    public void cut() {
        Logger.printMarkMessage(false, "NewYork");
        super.cut();
    }

    @Override
    public void box() {
        Logger.printMarkMessage(false, "NewYork");
        super.box();
    }
}

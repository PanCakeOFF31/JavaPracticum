package headFirst.chapter_7_adapter_facad.zoo.adapter;

import headFirst.chapter_7_adapter_facad.zoo.ducks.Duck;
import headFirst.chapter_7_adapter_facad.zoo.turky.Turkey;

public class TurkeyAdapter implements Duck {
    private final Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}

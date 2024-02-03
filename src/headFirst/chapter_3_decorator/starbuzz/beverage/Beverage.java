package headFirst.chapter_3_decorator.starbuzz.beverage;

import lombok.Getter;
import lombok.Setter;

public abstract class Beverage {
    @Getter
    protected String description;
    @Setter
    protected boolean milk;
    @Setter
    protected boolean soy;
    @Setter
    protected boolean mocha;
    @Setter
    protected boolean whip;

    public boolean hasMilk() {
        return this.milk;
    }

    public boolean hasSoy() {
        return this.soy;
    }

    public boolean hasMocha() {
        return this.mocha;
    }

    public boolean hasWhip() {
        return this.whip;
    }

    public abstract double cost();

    @Override
    public String toString() {
        return this.getDescription() +  " " + this.cost();
    }
}

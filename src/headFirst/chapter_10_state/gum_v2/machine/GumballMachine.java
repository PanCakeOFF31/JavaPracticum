package headFirst.chapter_10_state.gum_v2.machine;

import headFirst.chapter_10_state.gum_v2.state.*;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GumballMachine {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    @Setter
    private State state;
    private int count;

    public GumballMachine(int count) {
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);

        this.count = count;

        if (this.count > 0)
            state = noQuarterState;
        else state = soldOutState;
    }

    public void insertQuarter() {
        state.insertQuearter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0)
            --count;
    }
}

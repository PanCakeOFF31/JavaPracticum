package headFirst.chapter_11_proxy.gum.machine;

import headFirst.chapter_11_proxy.gum.state.*;
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
    private String location;

    public GumballMachine(String location, int count) {
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);

        this.count = count;
        this.location = location;

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

package headFirst.chapter_10_state.gum_v1;

import static headFirst.chapter_10_state.gum_v1.MachineState.*;

public class GumballMachine {
    private MachineState state;
    private int count;

    public GumballMachine(int count) {
        this.count = count;

        if (this.count > 0)
            state = NO_QUARTER;
    }

    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER -> System.out.println("You can’t insert another quarter");
            case NO_QUARTER -> {
                state =HAS_QUARTER;
                System.out.println("You inserted a quarter");
            }
            case SOLD_OUT -> System.out.println("You can’t insert a quarter, the machine is sold out");
            case SOLD -> System.out.println("Please wait, we’re already giving you a gumball");
        }
    }

    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER -> System.out.println("Quarter returned");
            case NO_QUARTER -> System.out.println("You haven’t inserted a quarter");
            case SOLD_OUT -> System.out.println("Sorry, you already turned the crank");
            case SOLD -> System.out.println("You can’t eject, you haven’t inserted a quarter yet");
        }
    }

    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn’t get you another gumball!");
        } else if (state == NO_QUARTER) {
            System.out.println("You turned but there’s no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if (state == HAS_QUARTER) {
            System.out.println("You turned...");
            state = SOLD;
            dispense();
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            --count;
            if (count == 0) {
                System.out.println("Oops, out of gumballs!");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("You need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }

    @Override
    public String toString() {
        return "Автомат с шариками. Осталось: " + count;
    }
}

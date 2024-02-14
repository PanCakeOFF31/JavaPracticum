package headFirst.chapter_11_proxy.gum.state;

import headFirst.chapter_11_proxy.gum.machine.GumballMachine;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WinnerState implements State {
    @NonNull
    private GumballMachine machine;

    @Override
    public void insertQuearter() {
        System.out.println("Please wait, we’re already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn’t get you another gumball!");
    }

    @Override
    public void dispense() {
        machine.releaseBall();
        if (machine.getCount() == 0) {
            machine.setState(machine.getSoldOutState());
        } else {
            machine.releaseBall();
            System.out.println("YOU’RE A WINNER! You got two gumballs for your quarter");
            if (machine.getCount() > 0) {
                machine.setState(machine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs!");
                machine.setState(machine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return "Победитель!!!";
    }
}

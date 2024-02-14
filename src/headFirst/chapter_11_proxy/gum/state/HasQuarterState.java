package headFirst.chapter_11_proxy.gum.state;

import headFirst.chapter_11_proxy.gum.machine.GumballMachine;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HasQuarterState implements State {
    @NonNull
    private GumballMachine machine;

    @Override
    public void insertQuearter() {
        System.out.println("You can’t insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.setState(machine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        machine.setState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "Имеется четвертак";
    }
}

package headFirst.chapter_11_proxy.gum.state;

import headFirst.chapter_11_proxy.gum.machine.GumballMachine;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NoQuarterState implements State {
    @NonNull
    private GumballMachine machine;

    @Override
    public void insertQuearter() {
        System.out.println("You inserted a quarter");
        machine.setState(machine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven’t inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there’s no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
    @Override
    public String toString() {
        return "Нет четвертака";
    }
}

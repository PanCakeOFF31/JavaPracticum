package headFirst.chapter_11_proxy.gum.state;

import headFirst.chapter_11_proxy.gum.machine.GumballMachine;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SoldOutState implements State {
    @NonNull
    private GumballMachine machine;

    @Override
    public void insertQuearter() {
        System.out.println("Жвачки закончились, некорректное действие");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Жвачки закончились, некорректное действие");
    }

    @Override
    public void turnCrank() {
        System.out.println("Жвачки закончились, некорректное действие");
    }

    @Override
    public void dispense() {
        System.out.println("Жвачки закончились, некорректное действие");
    }
    @Override
    public String toString() {
        return "Всё распродано";
    }
}


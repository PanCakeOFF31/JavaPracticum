package headFirst.chapter_11_proxy.gum.machine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GumballMonitor {
    private GumballMachine machine;
    public void report() {
        System.out.println("Gumball Machine: " + machine.getLocation());
        System.out.println("Current inventory: " + machine.getCount() + " gumballs");
        System.out.println("Current state: " + machine.getState());
    }
}

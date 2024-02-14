package headFirst.chapter_11_proxy.gum.state;

public interface State {
    void insertQuearter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

package headFirst.chapter_10_state.gum_v2.state;

public interface State {
    void insertQuearter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

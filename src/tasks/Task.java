package tasks;

public interface Task<T> {
    T implementation1();

    default T implementation2() {
        return null;
    }

    default T implementation3() {
        return null;
    }
}

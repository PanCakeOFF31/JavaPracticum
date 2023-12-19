package tasks;

public interface Task<T,R> {
    T implementation1(R value);

    default T implementation2(R value) {
        return null;
    }

    default T implementation3(R value) {
        return null;
    }
    default T implementation4(R value) {
        return null;
    }
}

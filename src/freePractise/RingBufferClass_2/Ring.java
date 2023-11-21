package freePractise.RingBufferClass_2;

public interface Ring<T> {
    void put(T element);

    void putWithUniqueness(T element);

    T get();

    boolean contains(T element);

    void reset();

    default void test() {

    }

}

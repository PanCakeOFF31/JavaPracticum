package freePractise.RingBufferClass_1;

public interface BufferList<T> {
    int size();

    T get(int index);

    void set(int index, T element);

}

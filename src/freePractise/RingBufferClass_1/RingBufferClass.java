package freePractise.RingBufferClass_1;

import helpers.Checker;

import java.util.Arrays;
import java.util.function.Consumer;

import static helpers.Helpers.*;

public class RingBufferClass {
    public static void ringBufferClass() {
        printSection("RingBufferClass");

        printSubSection("Тестирую RingBuffer");
        {

            RingBuffer<Integer> history = new RingBuffer<>(10);

            for (int i = 0; i < 4; i++) {
                history.add(i * 100);
            }

            Integer[] elements;

            for (int i = 0; i < 10; i++) {
                history.shiftElements(i);
                elements = new Integer[history.size()];
                history.getEls(elements);
                System.out.println("shift = " + i + " " + Arrays.toString(elements));
            }


        }
        printSubSectionEnding();

/*
        printSubSection("Изменяю объект, который лежит в массиве");
        {
            RingBuffer<A> tempRing = new RingBuffer<>();

            tempRing.add(new A());
            System.out.println("tempRing.get(0) = " + tempRing.get(0));

            A a = tempRing.get(0);
            a.changeData();

            System.out.println("tempRing.get(0) = " + tempRing.get(0));
        }
        printSubSection();
*/


/*
        history.set(0,300);
        System.out.println("history.getSize() = " + history.getSize());

        System.out.println("history.get(0) = " + history.get(0));

        for (int i = 0; i < history.getSize(); i++) {
            System.out.println("history.get(i) = " + history.get(i));
        }

        for (Object element : history.getElements()) {
//            Integer element1 = (Integer) element;
//            System.out.println(element1);
            System.out.println("element = " + element);
        }*/


   /*     Integer[] copy = Arrays.copyOf(new Integer[10],10);


        Integer[] origin = new Integer[]{10,20,30,4,5,6,7,8,1,30};
        Integer[] originCopy = new Integer[10];
        System.arraycopy(origin,0,originCopy,0,10);

        for (Integer integer : originCopy) {
            System.out.println("integer = " + integer);
        }*/


        printSectionEnding();

    }

}

class RingBuffer<T> implements BufferList<T> {
    private int size;
    private final int capacity;
    private Object[] elements;

    public RingBuffer() {
        size = 0;
        capacity = 10;
        elements = new Object[capacity];
    }

    public RingBuffer(int initialCapacity) {
        size = 0;
        capacity = initialCapacity;
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Checker.checkIndex(index, size);
        return (T) elements[index];
    }

    public void set(int index, T element) {
        Checker.checkIndex(index, size);
        Checker.checkNull(element);

        elements[index] = element;
    }

    public void add(T element) {
        Checker.checkNull(element);
        addFirst(element);
    }

    public void addFirst(T element) {
        Checker.checkNull(element);

        if (size == 0) {
            elements[0] = element;
            size++;
        } else if (size < capacity) {
            Object[] newArray = new Object[size + 1];

            for (int i = 0; i < size; i++) {
                newArray[i + 1] = elements[i];
            }

            newArray[0] = element;
            size++;
            elements = newArray;
        } else {
            shiftElements(1);
            elements[0] = element;
        }
    }

    public void forEach(Consumer<? super T> action) {
        Checker.checkNull(action);

        for (int i = 0; i < size; i++) {
            action.accept(get(i));
        }
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element))
                return i;
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public T[] getEls(T[] els) {
        for (int i = 0; i < this.size(); i++) {
            els[i] = (T) elements[i];
        }
        return els;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void shiftElements(int shift) {
        if (this.isEmpty())
            throw new ArrayStoreException();

        int correctedShift = shift % size;

        if (correctedShift == 0)
            return;

        Object[] newArray = new Object[size];

        int i;
        int j;

        for (i = correctedShift, j = 0; i < size; i++, j++) {
            newArray[i] = elements[j];
        }

        for (i = correctedShift - 1, j = 0; i >= 0; i--, j++) {
            newArray[i] = elements[size - 1 - j];
        }

        elements = newArray;
    }

    //    После удаления элемента, нужно
    private void trim() {

    }

    //    После удаления элемента из какого-то места, кроме конца, нужно пододвинуть элементы
    private void correctElements() {

    }

    public void remove() {

    }
}

class A {

    private int field = 100;

    public void changeData() {
        field = 500;
    }

    public int getField() {
        return field;
    }

    @Override
    public String toString() {
        return Integer.toString(field);
    }
}

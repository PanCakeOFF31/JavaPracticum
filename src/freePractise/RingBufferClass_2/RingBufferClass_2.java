package freePractise.RingBufferClass_2;

import helpers.Checker;

import java.util.Arrays;

import static helpers.Helpers.*;

public class RingBufferClass_2 {
    private static RingBuffer<Integer> integers = new RingBuffer<>();

    public static void ringBufferClass_2() {
        printSection("RingBufferClass_2");

        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();

        printSectionEnding();
    }

    private static void test1() {
        printPrivateInfo();
        System.out.println("integers.get() = " + integers.get());

        for (int i = 10; i <= 80; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        for (int i = 60; i <= 70; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        for (int i = 80; i <= 90; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        integers.reset();
        System.out.println("integers.get() = " + integers.get());
        printPrivateInfo();
    }

    private static void test2() {
        for (int i = 10; i <= 50; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        for (int i = 0; i < 3; i++) {
            System.out.println("integers.get() = " + integers.get());
        }
        printPrivateInfo();

        for (int i = 60; i <= 80; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        for (int i = 0; i < 5; i++) {
            System.out.println("integers.get() = " + integers.get());
        }
        printPrivateInfo();

        integers.put(300);
        printPrivateInfo();

        for (int i = 0; i < 5; i++) {
            System.out.println("integers.get() = " + integers.get());
        }
        printPrivateInfo();
    }

    private static void test3() {
        for (int i = 10; i <= 50; i += 10) {
            integers.put(i);
        }
        printPrivateInfo();

        System.out.println("integers.contains(30) = " + integers.contains(30));

        for (int i = 0; i < 3; i++) {
            System.out.println("integers.get() = " + integers.get());
        }
        printPrivateInfo();

        System.out.println("integers.contains(30) = " + integers.contains(30));
        System.out.println("integers.contains(40) = " + integers.contains(40));
    }

    private static void test4() {
        for (int i = 10; i <= 50; i += 10) {
            integers.putWithUniqueness(i);
        }
        printPrivateInfo();

        integers.putWithUniqueness(60);
        printPrivateInfo();

        integers.putWithUniqueness(30);
        printPrivateInfo();

//        integers.putUniq(60);
//        printPrivateInfo();
//
//        integers.putUniq(60);
//        printPrivateInfo();

        int count = integers.getAvailable();
        for (int i = 0; i < count; i++) {
            System.out.println("integers.get() = " + integers.get());
        }
    }

    private static void test5() {
        for (int i = 1; i <= 10; i++) {
            integers.put(i);
        }
        printPrivateInfo();

        integers.putWithUniqueness(16);
        printPrivateInfo();


        integers.putWithUniqueness(7);
        printPrivateInfo();

        integers.putWithUniqueness(11);
        printPrivateInfo();

        integers.putWithUniqueness(6);
        printPrivateInfo();

    }

    private static void test6() {
        RingBuffer<String> taskHistory = new RingBuffer<>();

        fillRingBuffer(taskHistory);
        printRingBuffer(taskHistory);

        printNewLine();

        fillRingBuffer(taskHistory);
        taskHistory.putWithUniqueness("Задача №3");
        taskHistory.putWithUniqueness("Задача №7");
        taskHistory.putWithUniqueness("Задача №7");
        printRingBuffer(taskHistory);

        printNewLine();

        fillRingBuffer(taskHistory);
        taskHistory.putWithUniqueness("Задача №1");
        printRingBuffer(taskHistory);

    }

    private static void fillRingBuffer(RingBuffer<String> ringBuffer) {
        for (int i = 1; i <= 10; i++) {
            ringBuffer.putWithUniqueness("Задача №" + i);
        }
    }

    private static <T> void printRingBuffer(RingBuffer<T> ringBuffer) {
        for (int i = 0; i < 10; i++) {
            System.out.println("taskHistory.get() = " + ringBuffer.get());
        }
    }

    private static void printPrivateInfo() {
        System.out.println("integers.getAvailable() = " + integers.getAvailable());
        System.out.println("integers.getReadPosition() = " + integers.getReadPosition());
        System.out.println("integers.getWritePosition() = " + integers.getWritePosition());
        System.out.println(Arrays.toString(integers.elements));
        printNewLine();
    }
}


class RingBuffer<T> implements Ring<T> {

    public Object[] elements;
    private int writePosition = 0;
    private int readPosition = 0;
    private int capacity = 10;
    private int available = 0;

    public RingBuffer() {
        elements = new Object[capacity];
    }

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        elements = new Object[this.capacity];
    }

    public void reset() {
        writePosition = 0;
        readPosition = 0;
        available = 0;
    }

    public void put(T element) {
        Checker.checkNull(element);

//        Ситуация, когда write догоняет read. Между ними может быть фора длинной в capacity
//        Если максимум достиг в виде capacity, то толкам read дальше, ибо количество
//        мест ограничено
        if (writePosition <= readPosition && available == capacity) {
            readPosition++;
            if (readPosition >= capacity) {
                readPosition = 0;
            }
        }

        elements[writePosition] = element;
        writePosition++;
        available++;

//        Сдвигаем корретку на новый круг
        if (writePosition >= capacity) {
            writePosition = 0;
        }

//        Если идем по записи на второй круг. Доступных больше емкости не может быть
        if (available > capacity) {
            available = capacity;
        }
    }

    public void putWithUniqueness(T element) {
        if (!this.contains(element)) {
            put(element);
        } else {
//            Object[] newArray = new Object[capacity];
//            System.arraycopy(elements, 0, newArray, 0, capacity);
            Object[] newArray = elements;

            int offset = this.offsetCalculator(element);
            int correctedAvailable = available - offset;
            int index = indexOf(element);

            for (int i = 0; i < correctedAvailable - 1; i++) {
                if (index == capacity - 1) {
                    newArray[index] = elements[0];
                    index = 0;
                    continue;
                }

                newArray[index] = elements[index + 1];
                index++;
            }

            newArray[index] = element;
            elements = newArray;
        }

    }

    public T get() {
        if (available == 0) {
            return null;
        }

        T element = (T) elements[readPosition];
        readPosition++;
        available--;
        // read не может обогнать write потому что ее ограничивают available
        // Другими словами read следует за write, но не опережает ее, в то время как
        // write может опередить

//        Сдвигаем корретку на новый круг
        if (readPosition >= capacity) {
            readPosition = 0;
        }

        return element;
    }

    public boolean contains(T element) {
        return this.indexOf(element) != -1;
    }

    public int getWritePosition() {
        return writePosition;
    }

    public int getReadPosition() {
        return readPosition;
    }

    public int getAvailable() {
        return available;
    }

    private int indexOf(T element) {
        Checker.checkNull(element);

        if (available == 0) {
            return -1;
        }

        int position = readPosition;
        for (int i = 0; i < available; i++) {

            if (position == capacity) {
                position = 0;
            }

            if (elements[position].equals(element)) {
                return position;
            }

            position++;
        }

        return -1;
    }

    //    Вспомогательный метод, нужен для вычислений, его необходимость вызвана плавающим readPosition
    private int offsetCalculator(T element) {
        Checker.checkNull(element);

        int offsetCalculator = 0;
        int position = readPosition;

        for (int i = 0; i < available; i++) {

//            Дошли до конца, переводим в начало
            if (position == capacity) {
                position = 0;
            }

            if (elements[position].equals(element)) {
                return offsetCalculator;
            }

            position++;
            offsetCalculator++;
        }

        return offsetCalculator;
    }

}



































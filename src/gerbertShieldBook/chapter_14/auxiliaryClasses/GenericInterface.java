package gerbertShieldBook.chapter_14.auxiliaryClasses;

public interface GenericInterface<T extends Comparable<T>> {

    T min();

    T max();
}


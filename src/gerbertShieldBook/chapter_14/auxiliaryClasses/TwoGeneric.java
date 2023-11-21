package gerbertShieldBook.chapter_14.auxiliaryClasses;

import java.io.PrintStream;

public class TwoGeneric<T,V> {
    private static final PrintStream console = System.out;
    T firstField;
    V secondField;

    public TwoGeneric(T firstField, V secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    public T getFirstField() {
        return firstField;
    }

    public V getSecondField() {
        return secondField;
    }

    public void showFirstFieldType() {
        console.println("Type of T is \"" + firstField.getClass().getName() + "\"");
    }
    public void showSecondFieldType() {
        console.println("Type of V is \"" + secondField.getClass().getName() + "\"");
    }
}

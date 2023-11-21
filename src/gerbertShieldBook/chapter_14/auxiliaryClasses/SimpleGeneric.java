package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class SimpleGeneric<T> {
    T objectField;

    public SimpleGeneric(T objectField) {
        this.objectField = objectField;
    }

    public T getObjectField() {
        return objectField;
    }

    public void showType() {
        System.out.println("Type of T is \"" + objectField.getClass().getName() + "\"");
    }
    public void showSelfType() {
        System.out.println(this.getClass().getName());
    }
}

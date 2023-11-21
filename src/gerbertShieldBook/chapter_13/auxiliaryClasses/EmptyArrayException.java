package gerbertShieldBook.chapter_13.auxiliaryClasses;

public class EmptyArrayException extends Exception {
    public EmptyArrayException() {
        super("Массив пустой");
    }
}

package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class GenericConstructor {
    private final double innerValue;

    public <T extends Number> GenericConstructor(T value) {
        innerValue = value.doubleValue();
    }

    public <T extends Character> GenericConstructor(T value) {
        int temp = value;
        innerValue = Integer.valueOf(temp).doubleValue();
    }

    public void showInnerValue() {
        System.out.println("innerValue = " + innerValue);
    }
}

package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class OriginalGenercis {
    Object objectField;

    public OriginalGenercis(Object objectField) {
        this.objectField = objectField;
    }

    public Object getObjectField() {
        return objectField;
    }

    public void showObjectype() {
        System.out.println("Type of Object field is \"" + objectField.getClass().getName() + "\"");
    }
}

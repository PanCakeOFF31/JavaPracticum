package freePractise.gson;

public class Weapon {
    String title;
    int length;
    double power;
    String options;

    private Weapon() {
        System.out.println("Был вызван приватный конструктор");
        length = 35;
    }

    public static Weapon of() {
        return new Weapon();
    }
}

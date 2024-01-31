package freePractise.__sofware_design_patterns.creational_design_patterns.singleton_method;

// Ленивая реализация
public class SinglObjectV1 {
    private static SinglObjectV1 instance;

    private SinglObjectV1() {
    }

    public static SinglObjectV1 getInstance() {
        if (instance == null)
            instance = new SinglObjectV1();

        return instance;
    }

    public void printInfo() {
        System.out.println(this);
    }
}

// Неленивая реализация-инициализация
class SingleObjectV2 {
    private static final SingleObjectV2 instance = new SingleObjectV2();

    private SingleObjectV2() {
    }

    public static SingleObjectV2 getInstance() {
        return instance;
    }

    public void printInfo() {
        System.out.println(this);
    }
}
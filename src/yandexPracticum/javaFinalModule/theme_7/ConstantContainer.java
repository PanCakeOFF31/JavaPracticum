package yandexPracticum.javaFinalModule.theme_7;

public class ConstantContainer {
    public static int humanLegs = 2;
    private int horseLegs = 2;

    {
        horseLegs *= 2;
    }

    static {
        humanLegs *= 2;
    }

    public ConstantContainer(int horseLegs) {
        this.horseLegs = horseLegs;
    }

    public int getHorseLegs() {
        return horseLegs;
    }
}

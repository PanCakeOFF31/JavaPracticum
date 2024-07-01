package yandexPracticum.javaFinalModule.theme_7;

public enum CarBrend implements General {
    LADA("LADA") {
        @Override
        String info() {
            return "lada info";
        }
    },
    OMODA("АМАДА"),
    BMW("БМП"),
    LISAN("ISLAM");

    CarBrend(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return super.toString() + " " + name;
    }

    @Override
    public int getWheelSize() {
        return 17;
    }

    public String alternativeName() {
        return name;
    }

    String info() {
        return "default info" + addTest();
    }

    private String addTest() {
        return " some text";
    }
}

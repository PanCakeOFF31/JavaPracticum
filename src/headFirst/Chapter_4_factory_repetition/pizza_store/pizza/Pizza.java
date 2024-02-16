package headFirst.Chapter_4_factory_repetition.pizza_store.pizza;

public class Pizza {
    private String name;
    private String dough;
    private String sauce;

    public Pizza(String name) {
        this.name = name;
    }

    public void prepare() {
        System.out.println(name + " is preparing");
    }

    public void bake() {
        System.out.println(name + " is baking");
    }

    public void cut() {
        System.out.println(name + " is cutting");
    }

    public void box() {
        System.out.println(name + " is boxing");
    }


}

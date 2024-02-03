package headFirst.chapter_4_factory.pizza_store_v1.pizza;

public abstract class Pizza {
    public void prepare() {
        System.out.println("Пицца подготавливается");
    }

    public void bake() {
        System.out.println("Пицца печётся");
    }

    public void cut() {
        System.out.println("Пицца нарезается");
    }

    public void box() {
        System.out.println("Пицца упаковывается");
    }


}

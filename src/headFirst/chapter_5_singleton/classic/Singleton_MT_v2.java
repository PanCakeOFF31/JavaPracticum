package headFirst.chapter_5_singleton.classic;

/**
 * Создание экземпляра заранее, тогда одиночка потокобезопасен
 */
public class Singleton_MT_v2 {
    private static int counter = 0;
    private static final Singleton_MT_v2 uniqueInstance = new Singleton_MT_v2();

    private Singleton_MT_v2() {
        counter++;
    }

    public static synchronized Singleton_MT_v2 getInstance() {
        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "Я Singleton с порядковым номером №" + counter;
    }
}

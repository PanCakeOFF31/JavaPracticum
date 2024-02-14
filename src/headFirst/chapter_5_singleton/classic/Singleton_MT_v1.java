package headFirst.chapter_5_singleton.classic;

/**
 * Для обеспечения потокобезопасности можно использовать ключевое слово synchronized
 */
public class Singleton_MT_v1 {
    private static int counter = 0;
    private static Singleton_MT_v1 uniqueInstance;

    private Singleton_MT_v1() {
        counter++;
    }

    public static synchronized Singleton_MT_v1 getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Singleton_MT_v1();

        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "Я Singleton с порядковым номером №" + counter;
    }
}

package headFirst.chapter_5_singleton.classic;

public class Singleton_MT_v3 {
    private static int counter = 0;
    private volatile static Singleton_MT_v3 uniqueInstance;

    private Singleton_MT_v3() {
        counter++;
    }

    public static synchronized Singleton_MT_v3 getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton_MT_v3.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new Singleton_MT_v3();
            }
        }

        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "Я Singleton с порядковым номером №" + counter;
    }
}

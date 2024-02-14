package headFirst.chapter_5_singleton.classic;

/**
 * Класс, который регулирует количество своих экземпляров
 */
public class Singleton_ST {
    private static int counter = 0;
    private static Singleton_ST uniqueInstance;

    private Singleton_ST() {
        counter++;
    }

    public static Singleton_ST getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Singleton_ST();

        return uniqueInstance;
    }

    @Override
    public String toString() {
        return "Я Singleton с порядковым номером №" + counter;
    }

    // ... Другие методы класса
}

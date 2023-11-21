package yandexPracticum.javaCoreContinuation.theme_1.lesson_4;

import java.util.*;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_4 {
    private static List<User> users = new ArrayList<>();
    private static Map<Long, User> usersMap = new HashMap<>(2_000_000);

    public static void lesson_4() {

        printSection("Lesson_4. ");

        // создадим 1 миллион пользователей
        for (long i = 1; i <= 1_000_000L; i++) {
            users.add(new User(i, "Имя " + i));
        }

        final long startTime = System.nanoTime();
        User user = findUser(378_366L);
        final long endTime = System.nanoTime();

        System.out.println("Найден пользователь: " + user);
        System.out.println("Поиск занял " + (endTime - startTime) + " наносекунд.");

        for (long i = 1; i <= 1_000_000L; ++i) {
            User newUser = new User(i,"Имя " + i);
            usersMap.put(newUser.id,newUser);
        }

        final long startTime_1 = System.nanoTime();
        User user_1 = findUser(378_366L);
        final long endTime_1 = System.nanoTime();

        System.out.println("Найден пользователь: " + user_1);
        System.out.println("Поиск занял " + (endTime_1 - startTime_1) + " наносекунд.");

        printSectionEnding();
    }

    private static User findUser(Long userId) {
        for (User user : users) {
            if (user.id.equals(userId)) {
                return user;
            }
        }

        return null;
    }

    private static User findUserMap(Long userId) {
        return usersMap.get(userId);
    }

    static class User {
        Long id;
        String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "User{id=" + id + ", name='" + name + "'}";
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            User user = (User) obj;
            return this.id.equals(user.id);
        }
    }
}

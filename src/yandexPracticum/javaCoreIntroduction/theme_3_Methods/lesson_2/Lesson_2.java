package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_2;

import java.util.Scanner;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_2 {
    public static void lesson_2() {
        printSection("Робот-помощник v1.0");

        System.out.println("Робот-помощник v1.0.");

        welcomeUserByName();
        sayHelloByTime();
        printSuccess();

        printSectionEnding();
    }

    private static void welcomeUserByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = scanner.next();
        System.out.println("Рад познакомиться, " + name + "!");
    }

    public static void sayHelloByTime(){ // Объявите метод sayHelloByTime
        Scanner scanner = new Scanner(System.in);
        System.out.println("Который час?");
        int currentHour = scanner.nextInt(); // Спросите у пользователя "Который час?" и сохраните ответ в переменную currentHour
        // В зависимости от времени предусмотрите печать приветствий
        if ((currentHour >= 22 && currentHour < 24) || (currentHour >= 0 && currentHour < 6)){
            System.out.println("Доброй ночи!");
        }
        if (currentHour >= 6 && currentHour < 12){
            System.out.println("Доброе утро!");
        }
        if (currentHour >= 12 && currentHour < 18){
            System.out.println("Добрый день!");
        }
        if (currentHour >= 18 && currentHour < 22){
            System.out.println("Добрый вечер!");
        }
    }

    public static void printSuccess() { // Объявите метод printSuccess
        System.out.println("У вас уже неплохо получается программировать!");
    }
}

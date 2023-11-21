package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_3;

import static helpers.Helpers.*;

import java.util.Scanner;

public class Lesson_3 {
    public static void lesson_3() {
        printSection("Робот-помошник v2.0");

        sayHello();
        sayHelloByTime();
        welcomeUserByName();
        printSuccess();

        printSectionEnding();
    }

    public static void welcomeUserByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String name = scanner.nextLine();
        printCity();
        String city = scanner.next();
        System.out.println("Рад познакомиться, " + name + " из " + city + "!");
    }

    public static void printSuccess() {
        System.out.println("У вас уже неплохо получается программировать!");
    }

    public static void sayHello() {
        System.out.println("Привет!");
    }

    public static void printCity() {
        System.out.println("Из какого вы города?");

    }

    public static void sayHelloByTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Который час?");
        int currentHour = scanner.nextInt();
        if (currentHour < 6 || currentHour > 22) {
            System.out.println("Доброй ночи!");
        } else if (currentHour < 12) {
            System.out.println("Доброе утро!");
        } else if (currentHour < 18) {
            System.out.println("Добрый день!");
        } else {
            System.out.println("Добрый вечер!");
        }
    }

}

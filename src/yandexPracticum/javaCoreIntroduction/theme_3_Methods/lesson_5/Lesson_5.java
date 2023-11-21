package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_5;

import static helpers.Helpers.*;
import java.util.Scanner;
public class Lesson_5 {

    public static void lesson_5() {
        printSection("return/break операторы, верная расстановка");

        System.out.println("Привет!");
        doCommand();

        printSectionEnding();
    }

    public static void doCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Получить совет о покупке евро");
            System.out.println("2 - Получить совет о покупке долларов");
            System.out.println("0 - Выход");
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Если евро стоит меньше 90 рублей - покупайте!");
            } else if (command == 2) {
                System.out.println("Если доллар стоит меньше 75 рублей - покупайте!");
            } else if (command == 0) {
                System.out.println("Выход");
                break;
            }
        }
    }

}

package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_7;

import static helpers.Helpers.*;
import java.util.Scanner;

public class Lesson_7_1 {

    public static void lesson_7_1() {
        printSection("Передача переменных в качестве аргумента");
        Scanner scanner = new Scanner(System.in);

        int balls = 15;
        System.out.println("У Пикселя " + balls + " мячиков");

        // В вызове метода происходит передача переменной по значению
        // При этому созадется копия переменной
        playPixel(balls);

        System.out.println("Пиксель вернул все мячики");
        System.out.println("Их снова " + balls);

        printSectionEnding();
    }



    private static void playPixel(int balls) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько мячиков он спрятал?");
        int hiddenBalls = scanner.nextInt();
        balls -= hiddenBalls;
        System.out.println("Осталось " + balls );
    }

}

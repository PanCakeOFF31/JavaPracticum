package yandexPracticum.javaCoreIntroduction.theme_3_Methods.lesson_4;

import java.util.Random;

import static helpers.Helpers.*;

public class Lesson_4 {

    public static void lesson_4() {
        printSection("Возвращаемое значение");

//        String highestGrossingFilm = findHighestGrossingFilm();
        String highestGrossingFilm = findHighestGrossingFilmTest();
        System.out.println("Самый кассовый фильм: " + highestGrossingFilm);

        printSectionEnding();
    }

    private static String findHighestGrossingFilm() {
        String film1 = "Титаник";
        int income1 = 2194;

        String film2 = "Аватар";
        int income2 = 2810;

        String film3 = "Тёмный рыцарь";
        int income3 = 1084;

        if (income1 > income2 && income1 > income3)
            return film1;

        if (income2 > income1 && income2 > income3)
            return film2;

        return film3;
    }

    private static String findHighestGrossingFilmTest() {

        Random random = new Random();

        String film1 = "Титаник";
        int income1 = random.nextInt(3000);

        String film2 = "Аватар";
        int income2 = random.nextInt(3000);

        String film3 = "Тёмный рыцарь";
        int income3 = random.nextInt(3000);

        System.out.println("Титаник, income1 = " + income1);
        System.out.println("Аватар, income2 = " + income2);
        System.out.println("Темный рыцарь, income3 = " + income3);

        if (income1 > income2 && income1 > income3)
            return film1;

        if (income2 > income1 && income2 > income3)
            return film2;

        return film3;
    }
}

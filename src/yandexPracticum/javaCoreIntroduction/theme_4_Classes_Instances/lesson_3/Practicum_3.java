package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_3;

import static helpers.Helpers.*;


public class Practicum_3 {
    public static void practicum_3() {
        printSection("Practicum_3");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Hamster");

        Hamster hamster_1 = new Hamster();

        System.out.println("Вес hamster_1 в начале " + hamster_1.weight);
        hamster_1.eat(10);
        hamster_1.runInWheel();
        hamster_1.hideSeed(5);
        System.out.println("Вес hamster_1 в конце " + hamster_1.weight);

        System.out.println("Я hamster_1 и меня зовут - " + hamster_1.name);
        hamster_1.name = "Хомка";
        System.out.println("Я hamster_1 и меня теперь зовут - " + hamster_1.name);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}

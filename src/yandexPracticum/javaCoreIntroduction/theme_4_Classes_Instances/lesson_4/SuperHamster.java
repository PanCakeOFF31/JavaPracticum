package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_4;

import yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_4.Hamster;

class SuperHamster extends Hamster {
    void pritnSuperName() {
        printName();
        System.out.println("Я SuperHamster!");
    }
}

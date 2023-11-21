package yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.B;

import yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.A.A;

public class B extends A{
    public int d = super.d*10;
    public void cheking() {
        System.out.println("Я класс - " + this.getClass().getName());
//        System.out.println("Я имею доступ к private int a = " + a);
//        System.out.println("Я имею доступ к package-private int b = " + b);
        System.out.println("Я унаследовал protected int c = " + c);
        System.out.println("Я унаследовал public int d = " + d);
        System.out.println("Родительской public int d = " + super.d);
    }

}

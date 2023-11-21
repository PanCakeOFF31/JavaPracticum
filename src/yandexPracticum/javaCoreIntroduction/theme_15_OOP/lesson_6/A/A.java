package yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.A;

public class A {
    private int a = 10;
    int b = 20;
    protected int c = 30;
    public int d = 40;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public void cheking() {
        System.out.println("Я класс - " + this.getClass().getName());
        System.out.println("Я имею доступ к private int a = " + a);
        System.out.println("Я имею доступ к package-private int b = " + b);
        System.out.println("Я имею доступ к protected int c = " + c);
        System.out.println("Я имею доступ к public int d = " + d);
    }
}


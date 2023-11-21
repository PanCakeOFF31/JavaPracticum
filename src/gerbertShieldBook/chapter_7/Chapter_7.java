package gerbertShieldBook.chapter_7;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_7 {
    public static void chapter_7() {
        printArticle("Chapter 7.");

//        Конструктор копирования
//        program_1();

//        Рекурсия
        program_2();

        printArticleEnding();


    }

    static void program_1() {
        printSection("Program_1. Конструктор копирования");

        Test test1 = new Test(10, 20);
        System.out.println("test1.a = " + test1.a);
        System.out.println("test1.b = " + test1.b);

        Test test2 = new Test(test1);
        System.out.println("test2.a = " + test2.a);
        System.out.println("test2.b = " + test2.b);

        printSectionEnding();
    }

    private int overload() {
        return 0;
    }

    private void overload(int a) {
//        return 0;
    }

    static void program_2() {
        printSection("Program 2. Аргументы переменной длины");

        int a = 10;
        int b = 20;

        vla(a,b);
        vla();
        vla(a,b,a,b,a,b,a);

        vla2("Maximum",a,b,a,b,a +a,b + a);
        vla2("Max");

        printSectionEnding();
    }

//    аргумент a - объявляется как массив с длинной равной числу аргументов
    static private void vla(int... a) {
        if (a.length == 0) {
            System.out.println("Количество аргументов - 0");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.printf("a[%d] = %d\n",i,a[i]);
        }
    }

    static private void vla(int a) {

    }

    static private void vla(int a,int b) {

    }

    static private void vla2(String title, int...a) {
        if (a.length == 0) {
            System.out.println("Количество аргументов - 0");
            return;
        }
        System.out.println(title);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("a[%d] = %d\n",i,a[i]);
        }
    }

//    Недопустимо ставить параметр переменной длины в начало объявления списка параметров
//    static private void illigalVLA(int... a, String title){
//
//    }


    /*static void program_*() {^
        printSection("");
        printSectionEnding();
    }*/


}

class Test {
    int a;
    int b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Test(Test obj) {
        this.a = obj.a;
        this.b = obj.b;
    }
}

abstract class abstractClass {
    public static int abstractClassField;
    protected int a;

}

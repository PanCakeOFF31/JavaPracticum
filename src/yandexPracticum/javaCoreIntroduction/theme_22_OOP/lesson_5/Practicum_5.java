package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_5;

import javax.print.Doc;

import static helpers.Helpers.*;

public class Practicum_5 {
    public static void practicum_5() {
        printSection("Practicum_5. Полиморфизм в стандартной библиотеке");

//        program_1();

        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        Document doc1 = new Passport(); // Автоматическое приведение типа
        Document doc2 = (Document) new Passport(); // Явное приведение

        doc1.method1();
        doc2.method1();

        ((Passport) doc2).method1();
        ((Passport) doc2).method2();

        Object obj1 = new Object();

//        ((String) obj1).length();

        if (doc1 instanceof Passport) {
            System.out.println("doc1 - Является экземпляром класса Passport");

            if (doc1 instanceof Document) {
                System.out.println("doc1 - Является экземпляром интерфейса Document");
            }
        }

        printSubSectionEnding();
    }

     private static void program_2() {
        printSubSection("Program_2. Параметризованный метод");

        test1(10,30.0);

        printSectionEnding();
    }
    /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/

    private static <T> void test1(T a, T b) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
    }
}

interface Document {
        public abstract void method1();
}

class Passport implements Document {
    @Override
    public void method1() {
        System.out.println("Passport.method1");
    }

    public void method2(){
        System.out.println("Passport.method2");
    }
}

class GeniralClass<T> {

}

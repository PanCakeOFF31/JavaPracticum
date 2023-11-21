package gerbertShieldBook.chapter_9;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_9 {
    public static void chapter_9() {
        printArticle("Chapter 9. Packages and interfaces");

//        program_1();

        program_2();

        printArticleEnding();

    }

    static void program_1() {
        printSection("Program_1. Interface implementation" );

        Interface obj = new InterfaceClass();
        obj.printInfo();
        obj.printInfo4();
        obj.printInfo5();

        printSectionEnding();
    }

    static void program_2() {
        printSection("Program_2. Множественное наследование");

        MyClass myClass = new MyClass();
        myClass.method1();
        myClass.method2();

        printSectionEnding();
    }

    /*static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

interface Interface {
    public final static int VOLUME = 1000;

    public void printInfo();

    void printInfo4();

    private void printIntfo2() {
        System.out.println("Это приватный метод интерфейса, который требует реализации.");
    }

    static public void printInfo3() {

    }

    default public void printInfo5(){
        System.out.println("Метод с реализацией по умолчанию в интерфейсе");
    }
}

abstract class SubInterface implements Interface {
    @Override
    public void printInfo() {
        System.out.println("Метод реализован в асбтрактном классе");
    }
}

class InterfaceClass extends SubInterface {
    @Override
    public void printInfo4() {
        System.out.println("Метод реализован в классе");
    }
}

interface Alpha {
    void method1();

    default void method2() {
        System.out.println("method2() - со стандартной реализацией, Alpha");
    }

}

interface Beta  extends  Alpha{
    void method1();
    default public void method2() {
        System.out.println("method2() - со стандартной реализацией, Beta");
        method3();
    }
     private void method3() {
         method1();
     }
}

class MyClass implements Alpha,Beta {
    @Override
    public void method1() {
        System.out.println("method1() - который реализован в классе");
    }

//    @Override
//    public void method2() {
//        Alpha.super.method2();
//        Beta.super.method2();
//    }
}



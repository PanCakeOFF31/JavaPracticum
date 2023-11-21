package javaRush.javaSyntaxPro.level_12;

import static helpers.Helpers.*;

public class Level_12 {
    public static void level_12() {
        printSection("Level 12. Классы и static");

//     Class class
//        program_1();

//        MyParadox
//        program_2();


//        program_3();

        program_4();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Class class");

        Class a = String.class;
        Class b = Integer.class;
        Class c = Double.valueOf(10.0).getClass();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program 2. Парадокс Блинова");

        MyParadox myParadox = new MyParadox();

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program 3. Когнитивный парадокс");

        Obj object = new Obj();
        object.toStr();

        System.out.println("-----------");

        Str str = new Str();
        str.toStr();

        printSubSectionEnding();
    }

  private static void program_4() {
        printSubSection("Program 4. Нестатический метод статического поля");

        StaticTest.out.println();

        printSubSectionEnding();
    }

  /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

class MyParadox {
    private final MyParadoxChild myParadoxChild = new MyParadoxChild();
    public MyParadox() {
        System.out.println("MyParadox class constructor");
    }
}

class MyParadoxChild extends MyParadox {
    public MyParadoxChild() {
        System.out.println("MyParadoxChild class constructor");
    }
}

  /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/

class Obj {

    public Obj() {
        System.out.println("Obj class has been created");
    }
    public Str toStr() {
        return new Str();
    }
}

class Str extends Obj {

    public Str() {
        super();
        System.out.println("Str class has been created");
    }
    public Str toStr() {
        return this;
    }
}

class StaticTest {

    public static StaticTest out = new StaticTest();

    public void println() {
        String out = null;
        System.out.println(this.out);
    }

    @Override
    public String toString() {
        return "out = new StaticTest()";
    }
}
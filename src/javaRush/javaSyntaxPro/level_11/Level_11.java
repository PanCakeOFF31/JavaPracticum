package javaRush.javaSyntaxPro.level_11;

import static helpers.Helpers.*;

public class Level_11 {
    public static void level_11() {
        printSection("Level 11. Объекты");

//
//        program_1();

        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Логирование конструкторов");

        Test test1 = new Test();
        Test test2 = Test.getNewTest();
        Test test3 = Test.test;
        Test test4 = Test.test;
        Test test5 = Test.getNewTest();

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program 2. Object class");

        Object obj = new Object();
        Object obj1 = new Object();
        System.out.println(obj.equals(obj));
        System.out.println(obj.equals(obj1));
        System.out.println(obj.getClass().getName());
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());

        String string = "asd";
        string.equals(string);
        System.out.println(String.class);
        System.out.println(string.getClass());

        printSubSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("Program *. ");
        printSubSectionEnding();
    }*/
}

class Test {
    private static int counter = 0;
    public static Test test = new Test();

    public Test () {
        counter += 10;
        System.out.println(counter);
    }

    public static Test getNewTest() {
        return new Test();
    }

}


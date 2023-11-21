package gerbertShieldBook.chapter_6;

import java.util.ArrayList;

import static helpers.Helpers.*;

// Введение в классы
public class Chapter_6 {
    public static void chapter_6() {
        printArticle("Chapter 6. Введение в классы");

//        program_1();
//        program_2();

        program_3();

        printArticleEnding();

    }

    static void program_1() {
        printSection("");

        {
            Program1 program1 = new Program1(1);
            ArrayList<Test> list = program1.getList();

            System.out.println(program1);
            System.out.println(list);

                program1 = new Program1(3);


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }

            System.gc();

            System.out.println(program1);
            System.out.println(program1.getList());

            System.out.println(list);
        }

        printSectionEnding();
    }

    static void program_2() {
        printSection("Program 2. ");

        Obj obj = new Obj();
        SubObj subObj = obj.subObj;

        obj = new Obj();

        printSectionEnding();
    }

    static void program_3() {
        printSection("Program 3. ");



        printSectionEnding();
    }


    /*static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

class Program1 {

    private ArrayList<Test> list = new ArrayList<>();

    public Program1(int factor) {
        list.add(new Test());
        list.add(new Test());
        list.add(new Test());
    }

    public ArrayList<Test> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "Program1";
    }
}

class Test {
    private static int ID = 0;
    private int id = 0;

    public Test() {
        ++this.ID;
        id = ID;
    }

    @Override
    public String toString() {
        return "Я  - Test, " + id;
    }
}

class Obj {
    public SubObj subObj = new SubObj();
}

class SubObj {

}
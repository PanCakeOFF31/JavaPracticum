package yandexPracticum.javaCoreContinuation.theme_1.lesson_6;

import freePractise.StructureNavigation.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_6 {
    public static void practicum_6() {
        printSection("Practicum_6. Comparator");

        program_1();
        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Self comparator");

//        List<Integer> list = new ArrayList<>();
//        list.sort();
//        String.CASE_INSENSITIVE_ORDER.compare();


        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/


     private static void program_2() {
        printSubSection("Program_2.");

        List<TestClass> list = new ArrayList<TestClass>(){{
           add(new TestClass(10,20));
           add(new TestClass(10,30));
           add(new TestClass(20,40));
           add(new TestClass(20,10));
           add(new TestClass(50,0));
           add(new TestClass(0,50));

        }};

         System.out.println("list = " + list);

         list.sort(new SimpleComparator());

         System.out.println("list = " + list);

        List<TestClass> list2 = new ArrayList<TestClass>(){{
           add(new TestClass(10,20));
           add(new TestClass(10,30));
           add(new TestClass(20,40));
           add(new TestClass(20,10));
           add(new TestClass(50,0));
           add(new TestClass(0,50));
        }};

         System.out.println("list2 = " + list2);

//         Collections.sort(list2,new SimpleComparator());
         Collections.sort(list2); // Если я использую такое, то класс должен реализовать Comparable<T>
//         и метод compareTo()

         System.out.println("list2 = " + list2);

         printSectionEnding();
    }
}

//class SimpleComparator<T extends TestClass> implements Comparator<T>
class SimpleComparator implements Comparator<TestClass>{

    @Override
    public int compare(TestClass obj1, TestClass obj2) {
        if (obj1.number1 - obj2.number1 != 0)
            return obj1.number1 - obj2.number1;
        if (obj1.number2 - obj2.number2 != 0)
            return obj1.number2 - obj2.number2;
        return 0;
    }
}

class TestClass implements Comparable<TestClass>{
    int number1;
    int number2;

    public TestClass(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return number1 + " " + number2;
    }

    @Override
    public int compareTo(TestClass object) {
        if (this.number1 - object.number1 != 0)
            return this.number1 - object.number1;
        if (this.number2 - object.number2 != 0)
            return this.number2 - object.number2;
        return 0;
    }
}



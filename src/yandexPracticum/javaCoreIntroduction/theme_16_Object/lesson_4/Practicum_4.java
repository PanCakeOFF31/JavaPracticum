package yandexPracticum.javaCoreIntroduction.theme_16_Object.lesson_4;

import helpers.Overrides;

import java.util.Objects;

import static helpers.Helpers.*;

public class Practicum_4 {
    public static void practicum_4() {
        printSection("Practicum_4. Самостоятельное переопределение метода hasCode()");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Переопределяю метод hashCode()");

        TestClass test1 = new TestClass(10,20);
        TestClass test2 = new TestClass(20,10);

        System.out.println("test1.equals(test2) - " + test1.equals(test2));

//        Объекты идентичные, но хеш-код разный
        int hash1 = test1.hashCode();
        int hash2 = test2.hashCode();

        System.out.println("hash1 = " + hash1);
        System.out.println("hash2 = " + hash2);



        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

class TestClass {
    public Integer a;
    public Integer b;

    public TestClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        TestClass testClass = (TestClass) object;
        return this.a == testClass.a &&
                this.b == testClass.b;
    }

    @Override
    public int hashCode() {
        int hash = 102103;
        if (a != null) {
            hash = (int)(long) (hash * (this.a.hashCode() % 7 * 7) * 231);
        }
        hash = (int) (hash * 1.0003D);
        if (b != null){
            hash += (int)(long) (hash * (this.b.hashCode() % 7 * 7) * 231);
        }
        return hash;
    }
}

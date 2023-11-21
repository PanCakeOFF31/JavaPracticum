package freePractise.deleteMeLater;

import static helpers.Helpers.*;

public class DeleteMeLater {

    public static void deleteMeLater() {
        printSection("DeleteMeLater:");

//        ArrayList

        printSectionEnding();
    }

    private static void foo() {

    }
}

class Test {

    int field;

    public Test(int field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return String.valueOf(field);
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

}

enum MenuOption {
    DELETE,
    INSERT;
}

interface A {
    void foo();
}

interface B {
    void foo();
}

interface C {
    void foo();
}

interface D {
    void foo();
}

interface E extends A, B {
    void foo();

    default void foo4() {

    }
}

interface F extends C, D {
    void foo();

}

abstract class G implements E {
    @Override
    public void foo() {

    }

    public void foo2() {

    }

    abstract public void foo3();
}

class H extends G {
    @Override
    public void foo2() {
        super.foo2();
    }

    @Override
    public void foo3() {

    }
}

class TestA {
    public void test() {
        System.out.println("Вызвана версия с (TestA test)");
    }

}

class TestB extends TestA {
    public void test() {
        System.out.println("Вызвана версия с (TestB test)");
    }
}




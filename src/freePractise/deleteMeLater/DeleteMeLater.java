package freePractise.deleteMeLater;

import java.time.LocalDateTime;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class DeleteMeLater {

    public static void deleteMeLater() {
        printSection("DeleteMeLater:");


/*
        List<A> list = new ArrayList<>() {{
            add(new A());
            add(new B());
            add(new C());
        }};

        List<A> copy = new ArrayList<>();

        for (A a : list) {
            copy.add(a.getMyCopy());
        }
*/


        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);

        printSectionEnding();
    }
}

interface Cloneable<T> {
    T getMyCopy();
}

class A implements Cloneable<A> {
    @Override
    public String toString() {
        return "A";
    }

    @Override
    public A getMyCopy() {
        return new A();
    }
}

class B extends A {
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public B getMyCopy() {
        return new B();
    }
}

class C extends B {
    @Override
    public String toString() {
        return "C";
    }

    @Override
    public B getMyCopy() {
        return new C();
    }
}
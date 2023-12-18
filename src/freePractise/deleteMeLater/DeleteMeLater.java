package freePractise.deleteMeLater;

import helpers.coloredString.Logger;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class DeleteMeLater {

    public static void deleteMeLater() {
        printSection("DeleteMeLater:");


        String original = "a,b,c,,,,";
        String[] result = original.split(",");
        System.out.println(Arrays.toString(result));
        System.out.println("result.length = " + result.length);

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

        class A implements Comparable<A> {
            int a;
            String title;

            public A(int a, String title) {
                this.a = a;
                this.title = title;
            }

            @Override
            public int compareTo(A o) {
                return this.a - o.a;
            }

            @Override
            public int hashCode() {
                return Objects.hash(a);
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;

                if (object == null || getClass() != object.getClass()) return false;

                A a = (A) object;
                return this.a == a.a;
            }

            @Override
            public String toString() {
                return "A{a:" + this.a + ", title:\"" + this.title + "}";
            }
        }

        TreeSet<A> tree = new TreeSet<>(Comparator.naturalOrder());
        tree.add(new A(20, "2"));
        tree.add(new A(30, "3"));
        tree.add(new A(10, "1"));
        tree.remove(new A(30, "4"));
        tree.add(new A(30, "4"));

        System.out.println(tree);

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
package freePractise.deleteMeLater;

import helpers.coloredString.Logger;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.UnaryOperator;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class DeleteMeLater {

    public static void deleteMeLater() {
        printSection("DeleteMeLater:");

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

//        for (int i = 0; i < 10; i++) {
//            if (i == 0)
//                try {
//                    throw new ArithmeticException();
//                } catch (ArithmeticException e) {
//
//                }
//            if (i == 5)
//                throw new ArithmeticException();
//        }

        Logger.printMessage("TreeSet");
        {
//            TreeSet требует переопределения метода compareTo() для корректной работы
            TreeSet<A> tree = new TreeSet<>(Comparator.naturalOrder());
            tree.add(new A(20, "2"));
            tree.add(new A(10, "1"));
            tree.remove(new A(30, "4"));
            tree.add(new A(40, "4"));

            System.out.println(tree);
        }

        Logger.printMessage("HashSet");
        {
//            HashSet требует переопределения метода hashCode() и equals() для корректной работы
            HashSet<A> tree = new HashSet<>();
            tree.add(new A(20, "2"));
            tree.add(new A(30, "3"));
            tree.add(new A(10, "1"));
            tree.remove(new A(30, "4"));

            System.out.println(tree);
//            tree.forEach(n -> System.out.println(n.hashCode()));
        }

        {
            int a = 10;
            int b = a + 20;

            new A(10, "Asd").a = 20;
        }

//        UnaryOperator<String> operator = (String::toUpperCase);
//        UnaryOperator<String> sameOperator = ((String text) -> text.toUpperCase());
//
//        String text = "some text";
//        UnaryOperator<String> basedOnText = (text::toUpperCase);



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
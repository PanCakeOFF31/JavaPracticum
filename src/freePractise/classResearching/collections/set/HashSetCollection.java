package freePractise.classResearching.collections.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static helpers.Helpers.*;

public class HashSetCollection {
    private static Set<Integer> set = new HashSet<>();

    static void hashSetCollection() {
        printArticle("HashSet");

//        part_1();
//        part_2();
        part_3();
        printArticleEnding();
    }

    private static void part_1() {
        printSection("part_1");

        set = new HashSet<>(Set.of(10, 20, 30, 40));

        System.out.println("set.size() = " + set.size());
        System.out.println("set = " + set);

        set.clear();
        System.out.println("set.size() = " + set.size());
        System.out.println("set = " + set);

        printSectionEnding();
    }

    private static void part_2() {
        printSection("part_2. HashSet и собственный класс A");

        Set<A> set = new HashSet<>();

        A a1 = new A(100);
        A a2 = new A(150);
        A a3 = new A(100);
        A a4 = new A(100);
        set.add(a1);
        set.add(a2);
        set.add(a3);

        System.out.println("a1.hashCode() = " + a1.hashCode());
        System.out.println("a2.hashCode() = " + a2.hashCode());
        System.out.println("a3.hashCode() = " + a3.hashCode());
        System.out.println("a4.hashCode() = " + a4.hashCode());

        System.out.println("set - " + set);
        System.out.println("set.size() = " + set.size());

        System.out.println("set.contains(a4) = " + set.contains(a4));

        set.clear();
        printSectionEnding();
    }

    private static void part_3() {
        printSection("part_3");

        set.addAll(Set.of(10,20,30));

        Set<Set<Integer>> superSet = new HashSet<>();
        superSet.add(set);

        System.out.println("superSet = " + superSet);

        printSectionEnding();
    }
    /*
    private static void part_() {
        printSection("part_");

        printSectionEnding();
    }
    */
}

class A {
    private int length;

    public A(int length) {
        this.length = length;
    }

    public int getLengh() {
        return length;
    }

    public void setLengh(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return new String("A = " + length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }

    @Override
    public boolean equals(Object obj) {
        return this.length == (((A) obj).getLengh());
    }

}

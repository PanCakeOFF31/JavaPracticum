package freePractise.classResearching.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helpers.Helpers.*;

public class CollectionsClass {

    private static List<Integer> list = new ArrayList<>();

    static void collectionsClass() {
        printArticle("utility Collections class");

        part_1();

        printArticleEnding();
    }

    private static void part_1() {
        printSection("part_1. Введение");

        list = new ArrayList<>();

        Collections.addAll(list, 37);
        Collections.addAll(list, 74, 84);

        printStaticList();

        List<Integer> tempList = new ArrayList<>();
        tempList.add(45);
        tempList.add(46);
        tempList.add(47);
        tempList.forEach(number -> list.addLast(number));

        tempList.clear();
        tempList.addAll(List.of(10,20,30,40,60,70));

        printStaticList();
        System.out.println("tempList = " + tempList);

        Collections.reverse(list);
        printStaticList();

        Collections.shuffle(list);
        printStaticList();

        Collections.copy(tempList,list);
        System.out.println("tempList = " + tempList);

        tempList.clear();
        tempList.addAll(List.of(10,20,30,40,60,70));
        tempList = List.copyOf(list);

        printStaticList();
        System.out.println("tempList = " + tempList);

        Collections.rotate(list,3);
        printStaticList();

        System.out.println("Collections.disjoint(list,tempList) = " + Collections.disjoint(list, tempList));
        System.out.println("Collections.disjoint(list,List.of(999)) = " + Collections.disjoint(list, List.of(999)));

        List<Integer> fake = Collections.nCopies(10,999);
        List<Integer> notFake = new ArrayList<>(fake);
        notFake.add(111);
        notFake.set(0,333);

        System.out.println("notFake = " + notFake);

        Collections.fill(notFake,77);

        System.out.println("notFake = " + notFake);


        printSectionEnding();
    }

    private static void printStaticList() {
        System.out.println("list = " + list);
    }

    /*
        private static void part_() {
            printSection("part_");

            printSectionEnding();
        }
    */
}

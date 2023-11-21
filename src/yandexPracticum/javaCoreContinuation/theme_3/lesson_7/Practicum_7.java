package yandexPracticum.javaCoreContinuation.theme_3.lesson_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_7 {
    public static void practicum_7() {
        printSection("Practicum_7. Collections");

        program_1();

        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Unmodifiable lists");

        List<String> emptyList = Collections.emptyList();
        List<String> singletone = Collections.singletonList("Maxim");
        List<String> nCopies = Collections.nCopies(5, "Maxim");

        System.out.println("emptyList = " + emptyList);
        System.out.println("singletone = " + singletone);
        System.out.println("nCopies = " + nCopies);

        List<String> list = new ArrayList<>() {{
           add("C++");
           add("Java");
           add("Java Script");
           add("HTML");
        }};

        List<String> originList = Collections.unmodifiableList(list);
        list.add("CSS");
        list.remove("Java");

        System.out.println("list = " + list);
        System.out.println("originList = " + originList);

        printSubSectionEnding();
    }

     private static void program_2() {
        printSubSection("Program_2. Copying, sorting");

         List<String> list = new ArrayList<>() {{
             add("C++");
             add("Java");
             add("Java Script");
             add("HTML");
         }};

         List<String> otherList = new ArrayList<>() {{
            add("asd");
            add("asd");
            add("asd");
            add("asd");
         }};

         System.out.println("otherList = " + otherList);

         Collections.copy(otherList,list);

         System.out.println("list = " + list);
         System.out.println("otherList = " + otherList);

//         Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
//         list.sort();

         System.out.println("list = " + list);

         {
             List<Integer> numbers = new ArrayList<>() {{
                add(10);
                add(20);
                add(40);
                add(5);
                add(0);
             }};

//             numbers.sort();
         }

//         Collections.sort();
//         Collections.mi


         printSectionEnding();
    }

    /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

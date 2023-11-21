package yandexPracticum.javaCoreIntroduction.theme_11_list_hash.lesson_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static helpers.Helpers.*;

public class Practicum_7 {
    public static void practicum_7() {
        printSection("Practicum_7. Операции с хеш-таблицами");

//
//        program_1();

        program_2();


        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        HashMap<String,Integer> a = new HashMap<>();
        HashMap<Test,Integer> b = new HashMap<>();

        String str1 = "Маским - крутой";
        String str2 =  new String("Маским - крутой");
        System.out.println(str1 == str2);

        a.put(str1, 100);
        a.put(str2, 200);

        System.out.println(a.get(str1));
        System.out.println(a.get(str2));

        Test test_1 = new Test();
        Test test_2 = new Test();

        b.put(test_1,10);
        b.put(test_2, 20);

        System.out.println(b.get(test_1));
        System.out.println(b.get(test_2));

        System.out.println(test_1);
        System.out.println(test_2);

        System.out.println(a.values());
        System.out.println(b.values());

        printSubSectionEnding();
    }

     private static void program_2() {
        printSubSection("Program_2. ...");

         HashMap<String,Integer> a = new HashMap<>();

         a.put("asd",123);
         a.put("cxzasd",1453);
         a.put("asdasdaf",423);

         for (String x: a.keySet()) {
             System.out.println(x);
         }

         for (Integer x: a.values()) {
             System.out.println(x);
         }

         System.out.println(a.remove("asd"));
         System.out.println(a);
         System.out.println(a.get("asd"));

         a.clear();

         System.out.println(a);

         Scanner scanner = new Scanner(System.in);
         int c= Integer.parseInt(scanner.nextLine());
         System.out.println(c);



        printSubSectionEnding();
    }

    /* private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

class Test {

    int a;
    int b;

}

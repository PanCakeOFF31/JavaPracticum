package yandexPracticum.javaCoreContinuation.theme_14.lesson_1;

import java.util.Collections;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");
        
        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();
        
        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        Class<? extends Integer> intClass = Integer.valueOf(10).getClass();
        System.out.println("intClass = " + intClass);

        Class<? extends Integer> intClass1 = Integer.class;

        class A {

        }

        System.out.println(A.class.isInstance(null));
        System.out.println(A.class.isInstance(new A()));

        System.out.println("A.class = " + A.class);

//        int a = new Integer(10);

//        Collections.singletonList()



        printSectionEnding();
    }
    
}

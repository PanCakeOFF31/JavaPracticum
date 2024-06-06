package javaRush;

import javaRush.javaCore.JavaCore;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class JavaRush {
    public static void javaRush() {

//        Java Syntax Pro 20 levels
//        javaSyntaxPro();

//        Java Core 10 levels
        JavaCore.javaCore();

    }

    public static void main(String[] args) {
        program_1();
    }

    private static void program_1() {
        printSection("Program_1. ");




        printSectionEnding();
    }

    private static interface Home {
        void method();

        public default void method1() {

        }

        private static void method2() {

        }

    }

    static public class A {
        protected void getValue() {
        }
    }

    static public class B extends A {
        @Override
        public void getValue() {
            super.getValue();
        }
    }

    public class C {

    }
}
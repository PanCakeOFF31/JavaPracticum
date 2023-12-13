package freePractise.nestedClasses;

import static helpers.Helpers.*;

public class NestedClasses {
    public static void nestedClasses() {
        printArticle("NestedClasses:");

        program_1();
        program_2();
        program_3();
        program_4();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. static nested class");

//        Обращение к публичному статическому методу публичного статического класса
        OuterClass_1.methodOuterClass_1();
//        Обращение к публичному статическому методу вложенного публичного статического класса
        OuterClass_1.NestedClass_4 temp = new OuterClass_1.NestedClass_4();

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. inner class");

//        Создание переменной внешнего класса
        OuterClass_2 temp1 = new OuterClass_2();
//        Обращение к публичному методу внешнего класса
        temp1.methodOuterClass_2();

//        Создание переменной типа публичного вложенного (внутреннего) класса
        OuterClass_2.InnerClass_4 temp2 = temp1.new InnerClass_4();
//        Обращение к публичному методу внутреннего публичного класса
        temp2.method1();

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. local class");


        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Anonymous class");
        AnonymousClass<Integer> ac1 = new AnonymousClass<Integer>() {
            private static void test() {

            }
        };

        printSectionEnding();
    }


}

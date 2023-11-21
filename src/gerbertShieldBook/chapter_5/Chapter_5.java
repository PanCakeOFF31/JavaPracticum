package gerbertShieldBook.chapter_5;

import static helpers.Helpers.*;

// Control statements - управляющие операторы
public class Chapter_5 {
    public static void chapter_5() {
        printArticle("Chapter 5. Control statements - управляющие операторы");

//        ...
//        program_1();

//        program_2();

        program_3();

        printArticleEnding();

    }

    static void program_1() {
        printSection("Program 1. Операторы выбора - Selection statements");
        /*{
            int a;
            int b;
            for (a = 0, b = 0; a + b < 20; ++a, ++b) {
                System.out.println(a);
                System.out.println(b);
            }
        }*/
        {
            int[] a = {1, 2, 3};
            for (var x : a) {
                System.out.println(x);
            }
        }
        {

        }

        printSectionEnding();
    }

    static void program_2() {
        printSection("Program 2. Использование оператора break как формы goto");

        outerLoop: for (int i = 0; i < 4; i++) {
            innerLoop: for (int j = 0; j < 4; j++) {
                System.out.printf("i = %d, j = %d\t",i,j);
                if (i == 1 && j == 1 )
                    break innerLoop;
                if (i == 2 && j == 2 )
                    break outerLoop;
            }
            System.out.println();
        }
        System.out.println();

        printSectionEnding();
    }

    static void program_3() {
        printSection("Program 3. Continue with label");

        outer: for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1)
                    continue outer;
                System.out.printf("i = %d, j = %d\t\n",i,j);
            }
            System.out.println("1");
        }
        System.out.println("End");

        printSectionEnding();
    }

    /*static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

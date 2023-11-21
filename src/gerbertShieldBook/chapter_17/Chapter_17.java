package gerbertShieldBook.chapter_17;


import static helpers.Helpers.*;

public class Chapter_17 {
    public static void chapter_17() {
        printArticle("Chapter_17");

//        program_1();
//        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. instanceof vs instanceof var");

        String var1 = "asd";
        String var2 = "adssxz";
        Integer var3 = 10;

        Number var4 = Integer.valueOf(100);
        Number var5 = Integer.valueOf(100);

        System.out.println("var4 = " + var4);
        if (var4 instanceof Integer intvalue) {
            intvalue *= 2;
            var4 = intvalue;
        }
        System.out.println("var4 = " + var4);

        System.out.println("var5 = " + var5);
        if (var5 instanceof Integer) {
            Integer intvalue = (Integer) var5;
            intvalue *= 3;
            var5 = intvalue;
        }
        System.out.println("var5 = " + var5);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. instanceof - other example");

        Object[] array = new Object[] {
                new String("Alpha"),
                new String("Beta"),
                15.5,
                new String("Gamma"),
                Integer.valueOf(15)
        };

        for (int i = 0; array[i] instanceof String element; i++) {
            System.out.println("element = " + element);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof String str)
                System.out.println("str = " + str);
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Sealed ...");



        printSectionEnding();
    }
}

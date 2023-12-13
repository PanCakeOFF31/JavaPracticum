package gerbertShieldBook.chapter_18;

import helpers.coloredString.Logger;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_18 {
    private final static String[] strings = {
            "away",
            "anger",
            "ecology",
            "eCoLogy",
            "document",
            "fold",
            "damp",
            "football",
            "cat",
            "bandit",
            "damper",
            "accept",
            "lower",
            "fanny",
            "center",
            "apple",
            "cup",
            "burger",
            "chess"
    };

    public static void chapter_18() {
        printArticle("Chapter 18. String Handling");

//                  Strings


//        program_1();
//
//        program_2();

//        equals(), equalsIgnoreCase()
//        program_3();

//        startsWith(), endsWith()
//        program_4();

//        replace(), replaceAll()
//        program_5();

//        trim(), strip()
//        program_6();

//        repeat(), toLowerCase(), toUpperCase()
//        program_7();

//        join()
//        program_8();

//        program_9();

//        matches(), regionMatches()
//        program_10();

//        transform()
//        program_11();

//        JSON
//        program_12();


//        program_13();
//        program_14();
//        program_15();
//        program_16();
//        program_17();
//        program_18();
//        program_19();

//                  StringBuilder/StringBuffer

//        constructors
//        program_21();

//        capacity()
//        program_22();

//        program_23();

//        delete(), deleteCharAt()
//       program_24();

//        append(), insert(), setCharAt()
//        program_25();

//        replace()
        program_26();

//        program_27();
//        program_28();
//        program_29();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. The String Constructors");

        printSubSection("new String(char[] value)");
        {
            char[] chars = {'Z', 'Б', '7'};
            String str1 = new String(chars);
            System.out.println("str1 = " + str1);

            char[] chars2 = {'Z', 'Б', '7', 'a', '_'};
            String str2 = new String(chars2, 2, 3);
            System.out.println("str2 = " + str2);
        }

        printSubSection("new String(byte[] value)");
        {
            byte byte1 = (byte) 0b0101_1111;
            byte byte2 = (byte) 0b0111_1111;
            byte[] bytes = {byte1, byte2};

            String str2 = new String(bytes);
            System.out.println("str2 = " + str2);
        }

        printSubSection("new String(int[] codePoints)");
        {

            int[] codePoints1 = {0xF, 0xFF, 0xFFF, 0xFFFF, 0xFFFFF};
            String str1 = new String(codePoints1, 0, 5);
            System.out.println("str1 = " + str1);

            for (int i = 0; i < str1.length(); i++) {
                System.out.println((int) str1.charAt(i));
            }

            int[] codePoints2 = {1054, 0x0429, (int) 'ы'};
            String str2 = new String(codePoints2, 0, 3);
            System.out.println("str2 = " + str2);

            for (int i = 0; i < str2.length(); i++) {
                System.out.println((int) str2.charAt(i));
            }

            String str3 = "\ud83d\ude02";
            System.out.println("str3 = " + str3);
            System.out.println((int) '\ud83d');
            System.out.println((int) '\ude02');
        }

        printSubSection("new String(String), new String(StringBuilder)");
        {
            String original = "some original text";
            String copy = new String(original + "end");
            String transformer = new String(new StringBuilder("some tex"));

            System.out.println("original = " + original);
            System.out.println("copy = " + copy);
            System.out.println("transformer = " + transformer);
        }

        printSubSection("temp");
        {
            char character1 = 'Я';
            System.out.println("character1 = " + character1);
            System.out.println("character1 = " + (int) character1);

            System.out.println(Character.charCount(0xFFFFF));

            String str1 = new String();
        }
        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. toString(), concat(), valueOf(), getChars()");

        printSubSection("concat()");
        {
            String str1 = "some text";
            String str2 = "other text";

            String concatenated = str1.concat(str2);

            System.out.println("str1 = " + str1);
            System.out.println("str2 = " + str2);
            System.out.println("concatenated = " + concatenated);
        }

        printSubSection("getChars()");
        {
            char[] chars = new char[50];
            String test = "This is a demo of the getChars method.";

            test.getChars(0, 21, chars, 0);

            for (int i = 0; i < 21; i++) {
                System.out.print(chars[i]);
            }

            System.out.println();
        }

        printSubSection("getBytes()");
        {
            byte[] bytes;

            String test = "А";

            bytes = test.getBytes();

            for (byte b : bytes) {
                System.out.print(b);
            }

            System.out.println();

            byte[] bytes1 = {(byte) 0b1101_0000, -112,
                    (byte) 0b1110_1010, (byte) 0b1010_1100, (byte) 0b1010_1100};

            String inferenced = new String(bytes1);
            System.out.println("inferenced = " + inferenced);
        }

        printSubSection("toCharArray()");
        {
            String str1 = "some text";
            char[] chars = str1.toCharArray();

            for (char c : chars) {
                System.out.print(c);
            }

            System.out.println();
        }
        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. equals(), equalsIgnoreCase()");

        String text1 = "Hello";
        String text2 = "hElLo";

        System.out.println(text1.equals(text2));
        System.out.println(text1.equalsIgnoreCase(text2));

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. startsWith(), endsWith()");

        String str1 = "MaxalskdjklasdjklaxaM";
        System.out.println(str1.startsWith("Max"));
        System.out.println(str1.endsWith("xaM"));

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. replace(), replaceAll()");

        String origin = "This is a text.";

        String replace1 = origin.replace("is", "was");
        String replace2 = origin.replaceAll("\\bis\\b", "was");

        System.out.println("origin = " + origin);

        System.out.println("replace1 = " + replace1);
        System.out.println("replace2 = " + replace2);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. trim(), strip(), translateEscape()");

        printSection("test");
        {
            String str1 = "text";
            String str2 = "TEXT";

            System.out.println(String.format("%1$s,%1$s,%2$s", str1, str2));
            System.out.println(String.format("%15s", str1));
        }

        printSubSection("stripLeading()");
        {
            String origin = "   \t    some text \t\t";
            System.out.println("\"" + origin.stripLeading() + "\"");
        }

        printSubSection("stripTrailing()");
        {
            String origin = "   \t    some text \t\t";
            System.out.println("\"" + origin.stripTrailing() + "\"");
        }

        printSubSection("strip()");
        {
            String origin = "   \t    some text \t\t";
            System.out.println("\"" + origin.strip() + "\"");
        }

        printSubSection("stripIndent()");
        {
            String origin = "first line\n    second line";
            System.out.println("origin = " + origin);

            origin = origin.indent(10);
            System.out.print(origin);

            System.out.print(origin.stripIndent());
        }

        printSubSection("translateEscape()");
        {
            String str1 = "\\tmaxim";
            System.out.println("str1 = " + str1);
            System.out.println("str1.translateEscapes() = " + str1.translateEscapes());
        }

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. repeat(), toUpperCase(), toLowerCase()");

        String origin = "text " + "a".repeat(10);
        System.out.println("origin = " + origin);

        System.out.println("origin.toUpperCase() = " + origin.toUpperCase());
        System.out.println("origin.toLowerCase() = " + origin.toLowerCase());

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. join()");

        String str1 = "Alpha";
        String str2 = "Beta";
        String str3 = "Gamma";

        String joined1 = String.join(" ", str1, str2, str3);
        String joined2 = String.join(", ", str1, str2, str3);
        String joined3 = String.join("", str1, str2, str3);

        System.out.println("joined1 = " + joined1);
        System.out.println("joined2 = " + joined2);
        System.out.println("joined3 = " + joined3);

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. matches(), regionMatches()");

        String regex = "^a.*";
        System.out.println("regex = " + regex);

        String other = "col";

        Logger.printMessage("matches()");
        for (String str : strings) {
            if (str.matches(regex))
                System.out.println(str);
        }

        Logger.printMessage("regionMatches()");
        for (String str : strings) {
            if (str.regionMatches(1, other, 0, other.length()))
                System.out.println(str);
        }

        Logger.printMessage("regionMatches()");
        for (String str : strings) {
            if (str.regionMatches(true, 1, other, 0, other.length()))
                System.out.println(str);
        }

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. transform()");

        String origin = "some text";
        String transformed = origin.transform(n -> "START " + n + " END.");

        System.out.println("origin = " + origin);
        System.out.println("transformed = " + transformed);

        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. JSON");

        class Person {
            String name = "persons'name";
            String sername = "persons's sername";
            int age = 40;

            @Override
            public String toString() {
                return "{name: \"" + name
                        + "\", sername: " + sername
                        + ", age: " + age
                        + "}";
            }
        }

        System.out.println("new Person() = " + new Person());

        printSectionEnding();
    }

    private static void program_21() {
        printSection("Program_21. StringBuffer's constructors");

        String str1 = "some text - 1";
        CharSequence str2 = "some text - 2";

        StringBuilder builder1 = new StringBuilder(str1);
        StringBuilder builder2 = new StringBuilder(str2);

        StringBuilder builder3 = new StringBuilder();
        StringBuilder builder4 = new StringBuilder(100);

        System.out.println("builder1 = " + builder1);
        System.out.println("builder2 = " + builder2);

        printSectionEnding();
    }

    private static void program_22() {
        printSection("Program_22. StringBuilder: capacity()");

        StringBuilder builder1 = new StringBuilder(1);
        System.out.println("builder1.capacity() = " + builder1.capacity());

        builder1.append('Я');
        System.out.println("builder1.capacity() = " + builder1.capacity());

        for (byte b : builder1.toString().getBytes()) {
            System.out.println(b);
        }

//        StringBuilder builder2 = new StringBuilder(1_073_741_824);
        StringBuilder builder2 = new StringBuilder(536_870_912);
        for (int i = 0; i < 536_870_912; i++) {
            builder2.append("Я");
        }

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

    private static void program_23() {
        printSection("Program_23. ");

        StringBuilder builder1 = new StringBuilder(10);

        builder1.append("abcdefghij");

        System.out.println("builder1.length() = " + builder1.length());
        System.out.println("builder1.capacity() = " + builder1.capacity());

        builder1.append("k");

        System.out.println("builder1.length() = " + builder1.length());
        System.out.println("builder1.capacity() = " + builder1.capacity());

        StringBuilder builder2 = new StringBuilder(536_870_912);
        for (int i = 0; i < 536_870_912; i++) {
            builder2.append("Я");
//            builder2.append("a");
        }

        System.out.println("builder2.length() = " + builder2.length());
        System.out.println("builder2.capacity() = " + builder2.capacity());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

    private static void program_24() {
        printSection("Program_24. StringBuilder: delete(), deleteCharAt()");

        StringBuilder builder1 = new StringBuilder("Some text.");
        System.out.println("builder1 = " + builder1);

        builder1.delete(4, 5);
        System.out.println("builder1 = " + builder1);

        builder1.insert(4, " ");

        builder1.deleteCharAt(4);
        System.out.println("builder1 = " + builder1);

        printSectionEnding();
    }

    private static void program_25() {
        printSection("Program_25. StringBuilder: append(), insert(), setCharAt()");

        StringBuilder builder1 = new StringBuilder("Some text");

        builder1.append(" end.");
        System.out.println("builder1 = " + builder1);

        builder1.insert(0, "Start ");
        System.out.println("builder1 = " + builder1);

        builder1.setCharAt(0, 'X');
        System.out.println("builder1 = " + builder1);

        printSectionEnding();
    }

    private static void program_26() {
        printSection("Program_26. StringBuilder: replace()");

        StringBuilder builder1 = new StringBuilder("Some text");
        System.out.println("builder1 = " + builder1);

        builder1.replace(0, 5, ("X".repeat(10) + " "));
        System.out.println("builder1 = " + builder1);

        printSectionEnding();
    }
}

















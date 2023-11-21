package freePractise.classResearching.stringBufferBuilder;

import static helpers.Helpers.*;

public class StringBufferAndStringBuilder {
    public static void stringBufferAndStringBuilder() {
        printSection("StringBuffer Class и StringBuilder Class"); // 44 chars
        String string = "Maxim, Wind, House and others 341 and 123!!!";

        printSubSection("StringBuffer");
        {

/*            StringBuffer str1 = new StringBuffer("StringBuffer конструктор №1");
            StringBuffer str2 = new StringBuffer(50);
            StringBuffer str3 = new StringBuffer(string);

            System.out.println(str1.toString());
            System.out.println(str2.toString());
            System.out.println(str3.toString());*/

        }
        printSubSectionEnding();

        printSubSection("StringBuilder");
        {

            StringBuilder str1 = new StringBuilder("StringBuilder конструктор №1");
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3 = new StringBuilder(50);
            StringBuilder str4 = new StringBuilder(string);
            String appended = "Acmxlmkca."; // 10 characters
            String insertedStart = "Start of sentence. ";
            String insertedEnd = "End of sentence. ";

            printSubSection("Конструкторы StringBuilder");
            System.out.println("new StringBuilder(\"StringBuilder конструктор №1\")" +
                    "\n\tэкземпляр содержит в себе такие же символы как в String литерале");
            System.out.println("new StringBuilder()" +
                    "\n\tэкземпляр без символов с длинной 0 и емкость 16 символов");
            System.out.println("new StringBuilder(50)" +
                    "\n\tэкземпляр пустой с емкостью в 50 символов");
            System.out.println("new StringBuilder(string)" +
                    "\n\tэкземпляр на основе переменной типа String");
            printSubSectionEnding();

            printSubSection("Исходные экземпляры StringBuilder");
            printStringBuildersInfo(str1,str2,str3,str4);
            printSubSectionEnding();

            printSubSection("Метод для добавления - append()");
            str1.append(appended);
            str2.append(appended);
            str3.append(appended);
            str4.append(appended);
            printStringBuildersInfo(str1,str2,str3,str4);
            printSubSectionEnding();

            printSubSection("Метод для помещения в определенное место - insert()");
            char[] temp = {'A','B','C'};

            str1.insert(0,insertedStart);
            str2.insert(str2.length(),insertedEnd);
            str3.insert(0,str3.substring(0,str3.length()/2));
            str4.insert(str4.length(),temp);
            str4.insert(str4.length(),temp);

            printStringBuildersInfo(str1,str2,str3,str4);
            printSubSectionEnding();

            printSubSection("reverse(), replace(), ");
            StringBuilder t = new StringBuilder(str3);
            System.out.println("str3.equals(str3) - " + str3.equals(str3));
            System.out.println("str3.compareTo(t) - " + str3.compareTo(t));
            str1.reverse();
            str2.replace(0,str2.length()/2,"Replaced text");
            System.out.println("str4.indexOf(\"i\") - " + str4.indexOf("i"));
            System.out.println("str4.lastIndexOf(\"i\") - " + str4.lastIndexOf("i"));
            str4.ensureCapacity(300);
            printStringBuildersInfo(str1,str2,str3,str4);
            printSubSectionEnding();

            printSubSection("Method summary:");
            System.out.println("append()");
            System.out.println("insert()");
            System.out.println("replace()");
            System.out.println("length()");
            System.out.println("capacity()");
            System.out.println("reverse()");
            System.out.println("indexOf()");
            System.out.println("lastIndexOf()");
            System.out.println("charAt()");
            System.out.println("compareTo()");
            System.out.println("ensureCapacity()");
            printSubSectionEnding();

        }
        printSubSectionEnding();



        printSectionEnding();

    }

    private static void printStringBuildersInfo(StringBuilder str1, StringBuilder str2,
                                             StringBuilder str3,StringBuilder str4) {
        System.out.println("str1.toString() - " + str1.toString());
        System.out.println("str1.length() - " + str1.length());
        System.out.println("str1.capacity() - " + str1.capacity());
        System.out.println("str2.toString() - " + str2.toString());
        System.out.println("str2.length() - " + str2.length());
        System.out.println("str2.capacity() - " + str2.capacity());
        System.out.println("str3.toString() - " + str3.toString());
        System.out.println("str3.length() - " + str3.length());
        System.out.println("str3.capacity() - " + str3.capacity());
        System.out.println("str4.toString() - " + str4.toString());
        System.out.println("str4.length() - " + str4.length());
        System.out.println("str4.capacity() - " + str4.capacity());
    }
}

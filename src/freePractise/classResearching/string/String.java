package freePractise.classResearching.string;

import java.util.Arrays;

import static helpers.Helpers.*;

public class String {
    public static void string() {
        printArticle("String class");
        printSection("Методы класса:");
        {
            java.lang.String[] staticMethods = {"format()", "join()", "valueOf", "copyValueOf"};
            System.out.println(Arrays.toString(staticMethods));

        }
        printSectionEnding();

        printSection("Методы экземпляров");

        {
            java.lang.String[] classMethods1 = {"replace()", "toCharArray()", "", "",};
            java.lang.String[] classMethods2 = {"", "", "", "",};
            java.lang.String[] classMethods3 = {"", "", "", "",};
            java.lang.String[][] classMethods = {classMethods1};
            System.out.println(Arrays.deepToString(classMethods));
        }
        printSection("Методы: replace(), toCharArray()");
        {
            char[] tempChar;

            java.lang.String path = "D:\\user\\files\\photo.jpg";
            System.out.printf("Изначальный путь: \"%s\"\n", path);
            path = path.replace('\\', '/');
            System.out.printf("Новый путь: \"%s\"\n", path);

            tempChar = path.toCharArray();
            System.out.println(Arrays.toString(tempChar));
        }
        printSectionEnding();

        printSection("Методы: substring(),");
        {
            java.lang.String string = "How to split two variables using delimiter?";
            java.lang.String temp = string.replace("w", "-W-");
            System.out.println(temp);
            temp = string.replaceAll("o", "-O-");
            System.out.println(temp);
        }
        printSubSectionEnding();

        printSection("Методы: indexOf(), lastIndexOf(), startWith(), endsWith()");
        {
            java.lang.String string = "How to split two variables using delimiter?";
            java.lang.String subString = "split two variables";
            java.lang.String subSubString = "two variables";

            System.out.println("string - " + string);
            System.out.println("subString - " + subString);
            System.out.println("subSubString - " + subSubString);

            int temp = string.indexOf(subString);
            System.out.println(string.substring(temp, temp + subString.length()));

            temp = string.lastIndexOf('o');
            System.out.println(string.charAt(temp));

            System.out.println(subString.endsWith(subSubString));

            System.out.println(string.contains(subString));


        }
        printSectionEnding();


        printSectionEnding();
        printSection(" Методы: split(), valueOf(), copyValueOf(), format()");
        {
            char[] charArray = {'A', 'B', 'C', 'D', 'E'};
            java.lang.String[] stringArray = "Max,Min,Average".split(",");
            java.lang.String temp = null;

            temp = java.lang.String.join("_", stringArray);
            System.out.println(temp);

            temp = java.lang.String.valueOf(charArray, 1, 4);
            System.out.println(temp);

            temp = java.lang.String.format("Abcs = %d", 10);
            System.out.println(temp);

            temp = java.lang.String.copyValueOf(charArray);
            System.out.println(temp);
        }
        printSectionEnding();

        printArticleEnding();


    }
}

package freePractise;

import helpers.OneDimensionalArray;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SplitTesting {
    public static void splitTesting() {

        String str1 = "First,Second,Third\nFirst,Third,Fifth\n ,Sec, Minute";

        String[] strArray = str1.split("\n");

        System.out.println(Arrays.toString(strArray));
        OneDimensionalArray.printOneDimensionalArray(strArray);
        System.out.println(strArray.length);

        final HashMap<String, ArrayList<String>> decompString = new HashMap<>();

        for (int i = 0; i < strArray.length; i++) {
            ArrayList<String> string = new ArrayList<>();
            String[] temp;
            String stringName;

            temp = strArray[i].split(",");
            Collections.addAll(string, temp);
            stringName = "Строка - " + (i+1);

            decompString.put(stringName, string);
        }

        decompString.put("Test", null);

        System.out.println(decompString.get("Строка - 1"));
        System.out.println(decompString.get("Строка - 2"));
        System.out.println(decompString.get("Строка - 3"));

        for (String str : decompString.get("Строка - 1")) {
            System.out.println(str);
        }

    }
}

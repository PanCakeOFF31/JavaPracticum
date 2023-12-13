package tasks.task_4_Split_String;

import java.util.Arrays;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Task_4 {
    private static final String UNDER_SCORE = "_";
    private static final Test_Task_4 test = new Test_Task_4();

    public static void task_4() {
        printSection("Task_");

        test.superTest();
        test.superTest_1();

        printSectionEnding();
    }

    public String check(String s) {
        if (s == null || s.isEmpty()) {
            return "[]";
        }

        String correctedString = s.length() % 2 == 0 ? s : s + "_";
        String[] arr = new String[correctedString.length() / 2];

        for (int i = 0; i <= correctedString.length() - 2; i += 2) {
            arr[i / 2] = correctedString.substring(i, i + 2);
        }

        return Arrays.toString(arr);
    }

    public String check_1(String s) {
        if (s == null || s.isEmpty()) {
            return "[]";
        }

        if (s.length() % 2 != 0)
            s = s + "_";

        int length = s.length()/2;

        String[] sub = new String[length];

        for (int i = 0; i < length; i++) {
            sub[i] = String.valueOf(s.charAt(i * 2)) + s.charAt(i * 2 + 1);
        }

        return Arrays.toString(sub);
    }

    public boolean check_22() {
        return false;
    }
}

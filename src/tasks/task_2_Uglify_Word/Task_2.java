package tasks.task_2_Uglify_Word;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

/*
 * 7 kyu
 * Uglify Word
 * In this kata, you have to make a function named uglify_word
 * (uglifyWord in Java and Javascript). It accepts a string parameter.
 * */
public class Task_2 {
    public static void task_2() {
        printSection("Task_2");
        Test_Task_2 test = new Test_Task_2();

        test.superTest();
        test.superTest_1();

        printSectionEnding();
    }

    String check(String str) {
        int flag = 1;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (Character.isLetter(character)) {
                if (flag == 1) {
                    result.append(Character.toUpperCase(character));
                    flag = 0;
                } else {
                    result.append(Character.toLowerCase(character));
                    flag = 1;
                }
            } else {
                result.append(character);
                flag = 1;
            }
        }

        return result.toString();
    }

    String check_1(String str) {
        boolean flag = true;
        var result = new StringBuilder();

        for (char character : str.toCharArray()) {
            if (Character.isLetter(character)) {
                if (flag) {
                    result.append(Character.toUpperCase(character));
                } else {
                    result.append(Character.toLowerCase(character));
                }

                flag = !flag;
            } else {
                result.append(character);
                flag = true;
            }
        }

        return result.toString();
    }

    boolean check_2() {
        return false;
    }
}

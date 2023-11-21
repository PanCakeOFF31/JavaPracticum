package tasks.task_1_Detect_Pangram;

import java.util.ArrayList;

import static helpers.Helpers.*;

public class Task_1 {
    public static void task_1() {
        printSection("Task_1");
        Test test = new Test();

        System.out.println("Test.test1() = " + test.test1());
        System.out.println("Test.test2() = " + test.test2());
        System.out.println("Test.test3() = " + test.test3());

        System.out.println("Test.test1_1() = " + test.test1_1());
        System.out.println("Test.test2_1() = " + test.test2_1());
        System.out.println("Test.test3_1() = " + test.test3_1());
        printSectionEnding();
    }

    public boolean check(String sentence) {
        boolean result;
        ArrayList<Character> list = new ArrayList<>();
        int letterCounter = 0;

        for (char lowerCaseCharacter : sentence.toLowerCase().toCharArray()) {
            if (Character.isLetter(lowerCaseCharacter) && !list.contains(lowerCaseCharacter)) {
                ++letterCounter;
                list.add(lowerCaseCharacter);
            }
        }

        result = letterCounter == 26;

        return result;
    }

    public boolean check_1(String sentence) {
        boolean result = false;

        for (char character = 'a' ; character <= 'z'; ++character) {
            if (!sentence.toLowerCase().contains(String.valueOf(character))){
                return result;
            }
        }

        result = true;

        return result;
    }
}

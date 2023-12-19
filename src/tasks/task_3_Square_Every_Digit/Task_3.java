package tasks.task_3_Square_Every_Digit;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Task_3 {
    private static final Test_Task_3 test = new Test_Task_3();

    public static void task_3() {
        printSection("Task_3");

        test.superTest();
        test.superTest_1();

        printSectionEnding();
    }

    public int check(int n) {
        if (n == 0)
            return 0;

        var tempString = new StringBuilder();
        int result;
        int previousValue = 0;
        int module = 10;
        int counter = 0;

        while ((n % (module / 10) != n)) {
            int reminder = n % module;
            int temp = ((reminder) - previousValue) / ((int) Math.pow(10, counter));
            tempString.insert(0, (int) Math.pow(temp, 2));
            previousValue = reminder;
            module = module * 10;
            counter++;
        }

        result = Integer.parseInt(tempString.toString());

        return result;
    }

    public boolean check_1() {
        return false;
    }

    public boolean check_2() {
        return false;
    }
}

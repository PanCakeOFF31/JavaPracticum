package tasks.task_5;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Task_5 {
    private static final Test_Task_5 test = new Test_Task_5();

    public static void task_5() {
        printSection("Task_5. ");

        test.test1();

        printSectionEnding();
    }

    public boolean check() {
        return false;
    }

    public boolean check_1() {
        return false;
    }

    public boolean check_2() {
        return false;
    }
}

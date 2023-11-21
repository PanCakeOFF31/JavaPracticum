package tasks.task_;

import static helpers.Helpers.*;

public class Task_ {
        private static final Test_Task_ test = new Test_Task_();
    public static void task_() {
        printSection("Task_");

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

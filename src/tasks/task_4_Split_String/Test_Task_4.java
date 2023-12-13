package tasks.task_4_Split_String;

import freePractise.logger_coloredString.Logger;

class Test_Task_4 {
    private static final Task_4 task = new Task_4();

    private <T> boolean resultCheck(T expected, T result) {
        return expected.equals(result);
    }

    boolean test1() {
        String str = "abc";
        String expected = "[ab, c_]";
        return resultCheck(expected, task.check(str));
    }

    boolean test2() {
        String str = "abcdef";
        String expected = "[ab, cd, ef]";
        return resultCheck(expected, task.check(str));
    }

    boolean test3() {
        String str = "HelloWorld";
        String expected = "[He, ll, oW, or, ld]";
        return resultCheck(expected, task.check(str));

    }

    boolean test4() {
        String str = "Hello World!";
        String expected = "[He, ll, o , Wo, rl, d!]";
        return resultCheck(expected, task.check(str));
    }

    boolean test5() {
        String str = "";
        String expected = "[]";
        return resultCheck(expected, task.check(str));
    }

    boolean test1_1() {
        String str = "abc";
        String expected = "[ab, c_]";
        return resultCheck(expected, task.check_1(str));
    }

    boolean test2_1() {
        String str = "abcdef";
        String expected = "[ab, cd, ef]";
        return resultCheck(expected, task.check_1(str));
    }

    boolean test3_1() {
        String str = "HelloWorld";
        String expected = "[He, ll, oW, or, ld]";
        return resultCheck(expected, task.check_1(str));

    }

    boolean test4_1() {
        String str = "Hello World!";
        String expected = "[He, ll, o , Wo, rl, d!]";
        return resultCheck(expected, task.check_1(str));
    }

    boolean test5_1() {
        String str = "";
        String expected = "[]";
        return resultCheck(expected, task.check_1(str));
    }

    void superTest() {
        Logger.printMessage("The super tests of the check() method");
        System.out.println("test1() = " + this.test1());
        System.out.println("test2() = " + this.test2());
        System.out.println("test3() = " + this.test3());
        System.out.println("test4() = " + this.test4());
        System.out.println("test5() = " + this.test5());
    }

    void superTest_1() {
        Logger.printMessage("The super tests of the check_1() method");
        System.out.println("test1_1() = " + this.test1_1());
        System.out.println("test2_1() = " + this.test2_1());
        System.out.println("test3_1() = " + this.test3_1());
        System.out.println("test4_1() = " + this.test4_1());
        System.out.println("test5_1() = " + this.test5_1());
    }

}

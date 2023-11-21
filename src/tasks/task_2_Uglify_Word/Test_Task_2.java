package tasks.task_2_Uglify_Word;

public class Test_Task_2 {

    private static final Task_2 task = new Task_2();
    private boolean resultCheck(String expected, String result) {
        return expected.equals(result);
    }

    boolean test1() {
        String expected = "AaA";
        String result = task.check("AAA");
        return resultCheck(expected,result);
    }

    boolean test2() {
        String expected = "AaA";
        String result = task.check("AaA");
        return resultCheck(expected,result);
    }

    boolean test3() {
        String expected = "BbB";
        String result = task.check("BbB");
        return resultCheck(expected,result);
    }
    boolean test4() {
        String expected = "AaA-BbB-CcC";
        String result = task.check("aaa-bbb-ccc");
        return resultCheck(expected,result);
    }
    boolean test5() {
        String expected = "AaA-BbB-CcC";
        String result = task.check("AaA-BbB-CcC");
        return resultCheck(expected,result);
    }
    boolean test6() {
        String expected = "EeEe-FfFf-GgGg";
        String result = task.check("eeee-ffff-gggg");
        return resultCheck(expected,result);
    }
    boolean test7() {
        String expected = "EeEe-FfFf-GgGg";
        String result = task.check("EeEe-FfFf-GgGg");
        return resultCheck(expected,result);
    }
    boolean test8() {
        String expected = "QwE123AsDf456ZxC";
        String result = task.check("qwe123asdf456zxc");
        return resultCheck(expected,result);
    }
    boolean test9() {
        String expected = "HeLlO WoRlD";
        String result = task.check("Hello World");
        return resultCheck(expected,result);
    }
    boolean test1_1() {
        String expected = "AaA";
        String result = task.check_1("AAA");
        return resultCheck(expected,result);
    }

    boolean test2_1() {
        String expected = "AaA";
        String result = task.check_1("AaA");
        return resultCheck(expected,result);
    }

    boolean test3_1() {
        String expected = "BbB";
        String result = task.check_1("BbB");
        return resultCheck(expected,result);
    }
    boolean test4_1() {
        String expected = "AaA-BbB-CcC";
        String result = task.check_1("aaa-bbb-ccc");
        return resultCheck(expected,result);
    }
    boolean test5_1() {
        String expected = "AaA-BbB-CcC";
        String result = task.check_1("AaA-BbB-CcC");
        return resultCheck(expected,result);
    }
    boolean test6_1() {
        String expected = "EeEe-FfFf-GgGg";
        String result = task.check_1("eeee-ffff-gggg");
        return resultCheck(expected,result);
    }
    boolean test7_1() {
        String expected = "EeEe-FfFf-GgGg";
        String result = task.check_1("EeEe-FfFf-GgGg");
        return resultCheck(expected,result);
    }
    boolean test8_1() {
        String expected = "QwE123AsDf456ZxC";
        String result = task.check_1("qwe123asdf456zxc");
        return resultCheck(expected,result);
    }
    boolean test9_1() {
        String expected = "HeLlO WoRlD";
        String result = task.check_1("Hello World");
        return resultCheck(expected,result);
    }

    void superTest() {
        System.out.println("test.test1() = " + this.test1());
        System.out.println("test.test2() = " + this.test2());
        System.out.println("test.test3() = " + this.test3());
        System.out.println("test.test4() = " + this.test4());
        System.out.println("test.test5() = " + this.test5());
        System.out.println("test.test6() = " + this.test6());
        System.out.println("test.test7() = " + this.test7());
        System.out.println("test.test8() = " + this.test8());
        System.out.println("test.test9() = " + this.test9());
    }

    void superTest_1() {
        System.out.println("test.test1_1() = " + this.test1_1());
        System.out.println("test.test2_1() = " + this.test2_1());
        System.out.println("test.test3_1() = " + this.test3_1());
        System.out.println("test.test4_1() = " + this.test4_1());
        System.out.println("test.test5_1() = " + this.test5_1());
        System.out.println("test.test6_1() = " + this.test6_1());
        System.out.println("test.test7_1() = " + this.test7_1());
        System.out.println("test.test8_1() = " + this.test8_1());
        System.out.println("test.test9_1() = " + this.test9_1());
    }
}

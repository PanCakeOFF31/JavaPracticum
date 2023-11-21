package tasks.task_1_Detect_Pangram;

class Test  {
    private static final Task_1 task = new Task_1();
     boolean test1() {
        String pangram = "The quick brown fox jumps over the lazy dog.";
        return resultCheck(true,task.check(pangram));
    }
    boolean test2() {
        String pangram = "\"You shall not pass!\"";
        return resultCheck(false,task.check(pangram));
    }

    boolean test3() {
        String pangram = "\"qazwsxedcrfvtgbyhnujmikolpsbacvsadkjfvlhasdfnmxpohlxzmvkxnzzvama\"";
        return resultCheck(true,task.check(pangram));
    }
    boolean test1_1() {
        String pangram = "The quick brown fox jumps over the lazy dog.";
        return resultCheck(true,task.check_1(pangram));
    }
    boolean test2_1() {
        String pangram = "\"You shall not pass!\"";
        return resultCheck(false,task.check_1(pangram));
    }

    boolean test3_1() {
        String pangram = "\"qazwsxedcrfvtgbyhnujmikolpsbacvsadkjfvlhasdfnmxpohlxzmzvkxnzvama\"";
        return resultCheck(true,task.check_1(pangram));
    }

    private boolean resultCheck(boolean expected, boolean result) {
        return expected == result;
    }

}

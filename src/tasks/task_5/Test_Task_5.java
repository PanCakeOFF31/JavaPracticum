package tasks.task_5;

class Test_Task_5 {
    private static final Task_5 task = new Task_5();
    private <T> boolean resultCheck(T expected, T result) {
        return expected.equals(result);
    }
    boolean test1() {
        return resultCheck(null,task.check());
    }

    boolean test2() {
        return resultCheck(null,null);
    }

    boolean test3() {
        return resultCheck(null,null);
    }

    void superTest() {
        System.out.println("test1() = " + this.test1());
        System.out.println("test2() = " + this.test2());
        System.out.println("test3() = " + this.test3());
    }

}

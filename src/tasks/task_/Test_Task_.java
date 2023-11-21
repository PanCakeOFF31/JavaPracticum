package tasks.task_;

class Test_Task_ {
    private static final Task_ task = new Task_();
    private <T> boolean resultCheck(T expected, T result) {
        return expected.equals(result);
    }
    boolean test1() {
        return resultCheck(null,null);
    }

    boolean test2() {
        return resultCheck(null,null);
    }

    boolean test3() {
        return resultCheck(null,null);
    }

    void superTest() {
        System.out.println("this.test1() = " + this.test1());
        System.out.println("this.test2() = " + this.test2());
        System.out.println("this.test3() = " + this.test3());
    }

}

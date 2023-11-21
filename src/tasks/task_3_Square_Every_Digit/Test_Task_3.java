package tasks.task_3_Square_Every_Digit;

class Test_Task_3 {
    private static final Task_3 task = new Task_3();
    private <T> boolean resultCheck(T expected, T result) {
        return expected.equals(result);
    }
    boolean test1() {
        return resultCheck(811181, task.check(9119));
    }

    boolean test2() {
        return resultCheck(0,task.check(0));
    }

    boolean test3() {
        return resultCheck(1111,task.check(1111));
    }

    void superTest() {
        System.out.println("this.test1() = " + this.test1());
        System.out.println("this.test2() = " + this.test2());
        System.out.println("this.test3() = " + this.test3());
    }

    void superTest_1(){

    }

}

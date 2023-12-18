package tasks.task_6;

import tasks.Task;

public class Task_6 implements Task<String> {
    @Override
    public String implementation1() {
        return "maxim";
    }

    @Override
    public String implementation2() {
        return Task.super.implementation2();
    }

    @Override
    public String implementation3() {
        return Task.super.implementation3();
    }
}

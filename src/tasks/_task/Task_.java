package tasks._task;

import tasks.Task;

public class Task_ implements Task<String> {
    @Override
    public String implementation1() {
        return null;
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

package tasks._task;

import tasks.Task;

public class Task_ implements Task<String,String> {
    @Override
    public String implementation1(String value) {
        return null;
    }

    @Override
    public String implementation2(String value) {
        return Task.super.implementation2(value);
    }

    @Override
    public String implementation3(String value) {
        return Task.super.implementation3(value);
    }
}

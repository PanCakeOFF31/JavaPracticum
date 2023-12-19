package tasks.task_6_Sum_of_Digits;

import tasks.Task;

public class Task_6 implements Task<Integer, Integer> {
    //    Моя реализация
    @Override
    public Integer implementation1(Integer n) {
        int result = 0;

        int previousValue = 0;
        int module = 10;
        int counter = 0;

        while ((n % (module / 10) != n)) {
            int reminder = n % module;
            result += ((reminder) - previousValue) / ((int) Math.pow(10, counter));
            previousValue = reminder;
            module = module * 10;
            counter++;
        }

        if (result >= 10)
            result = implementation1(result);

        return result;
    }

    //    Чужая крутая реализация
    @Override
    public Integer implementation2(Integer value) {
        while (value > 9)
            value = value % 10 + value / 10;
        return value;
    }

    //    Чужая крутая реализация
    @Override
    public Integer implementation3(Integer value) {
        return (value != 0 && value % 9 == 0) ? 9 : value % 9;
    }

    //    Чужая крутая реализация
    @Override
    public Integer implementation4(Integer value) {
        return (1 + (value - 1) % 9);
    }
}

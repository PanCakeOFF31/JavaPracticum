package tasks.task_6_Sum_of_Digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task_6_Test {
    Task_6 task = new Task_6();

    @Test
    public void test1_1() {
        var expected = 6;
        var result = task.implementation1(6);
        assertEquals(expected, result);
    }

    @Test
    public void test1_2() {
        var expected = 6;
        var result = task.implementation1(942);
        assertEquals(expected, result);
    }

    @Test
    public void test1_3() {
        var expected = 6;
        var result = task.implementation1(132189);
        assertEquals(expected, result);
    }

    @Test
    public void test1_4() {
        var expected = 2;
        var result = task.implementation1(493193);
        assertEquals(expected, result);
    }

    @Test
    public void test2_1() {
        var expected = 6;
        var result = task.implementation2(6);
        assertEquals(expected, result);
    }

    @Test
    public void test2_2() {
        var expected = 6;
        var result = task.implementation2(942);
        assertEquals(expected, result);
    }

    @Test
    public void test2_3() {
        var expected = 6;
        var result = task.implementation2(132189);
        assertEquals(expected, result);
    }

    @Test
    public void test2_4() {
        var expected = 2;
        var result = task.implementation2(493193);
        assertEquals(expected, result);
    }

    @Test
    public void test3_1() {
        var expected = 6;
        var result = task.implementation3(6);
        assertEquals(expected, result);
    }

    @Test
    public void test3_2() {
        var expected = 6;
        var result = task.implementation3(942);
        assertEquals(expected, result);
    }

    @Test
    public void test3_3() {
        var expected = 6;
        var result = task.implementation3(132189);
        assertEquals(expected, result);
    }

    @Test
    public void test3_4() {
        var expected = 2;
        var result = task.implementation3(493193);
        assertEquals(expected, result);
    }
    @Test
    public void test4_1() {
        var expected = 6;
        var result = task.implementation4(6);
        assertEquals(expected, result);
    }

    @Test
    public void test4_2() {
        var expected = 6;
        var result = task.implementation4(942);
        assertEquals(expected, result);
    }

    @Test
    public void test4_3() {
        var expected = 6;
        var result = task.implementation4(132189);
        assertEquals(expected, result);
    }

    @Test
    public void test4_4() {
        var expected = 2;
        var result = task.implementation4(493193);
        assertEquals(expected, result);
    }

}

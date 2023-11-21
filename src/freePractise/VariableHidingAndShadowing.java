package freePractise;

public class VariableHidingAndShadowing {
    static void variableHidingAndShadowing() {
        Test_1 test_1 = new Test_1();
        Test_2 test_2 = new Test_2();
        Test_3 test_3 = new Test_3();
//        System.out.println(test_1.x);
//        System.out.println(test_2.x);
        test_2.test();
        test_3.test();
    }
}

class Test_1 {
    protected int x = 10;
}

class Test_2 extends Test_1 {
//    Сокрытие переменной - x
    protected int x = 20;
    void test() {
//        Затенение переменной - х, которая скрывает переменную - х
        int x = 30;
        System.out.println(x);
        System.out.println(super.x);
        System.out.println(this.x);
    }
}

class Test_3 extends Test_2 {
    protected  int x = 50;
    void test() {
        int x = 30;
        System.out.println(x);
        System.out.println(super.x);
        System.out.println(this.x);
    }
}
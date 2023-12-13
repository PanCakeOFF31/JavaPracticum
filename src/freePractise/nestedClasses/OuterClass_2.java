package freePractise.nestedClasses;

import freePractise.logger_coloredString.Logger;

public class OuterClass_2 {
    private int outer_a = 10;
    private class InnerClass_1 {

    }

    class InnerClass_2 {

    }


    protected class InnerClass_3 {

    }

    public class InnerClass_4 {
        public int inner_a = 20;
        public void method1() {
            Logger.printCallingMethod();
            System.out.println("outer_a = " + outer_a);
            System.out.println("inner_a = " + inner_a);
        }

        public int getInner_a() {
            return inner_a;
        }
    }

    public void methodOuterClass_2() {
        Logger.printCallingMethod();
        System.out.println("outer_a = " + outer_a);

        InnerClass_4 inner = new InnerClass_4();
        System.out.println("inner.getInner_a() = " + inner.getInner_a());
    }
}

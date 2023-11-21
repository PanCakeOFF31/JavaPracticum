package freePractise.nestedClasses;

public class OuterClass_1 {
    /**
     * <p style="color: green">Доступ к NestedClass_1 есть только у OuterClass_1 </p>
     */
    private static class NestedClass_1 {

    }

    /**
     * <p style="color: green"></p>
     */
    static class NestedClass_2 {

    }

    /**
     * <p style="color: green"></p>
     */
    protected static class NestedClass_3 {

    }

    /**
     * <p style="color: green"></p>
     */
    public static class NestedClass_4 {
        public void method1() {

        }
    }

    public static void methodOuterClass_1() {
        NestedClass_1 temp1 = new NestedClass_1();
        OuterClass_1.NestedClass_1 temp2 = new NestedClass_1();
        NestedClass_1 temp3 = new OuterClass_1.NestedClass_1();
    }

}

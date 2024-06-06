package javaRush.javaCore.level_5;

public class B extends A
{
    @Override
    String getValue() {
        return "value-1";
    }

    @Override
    B getA() {
        return new B();
    }
}

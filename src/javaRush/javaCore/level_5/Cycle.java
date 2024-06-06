package javaRush.javaCore.level_5;

import lombok.Getter;

@Getter
public class Cycle {
    private String str;
    private static String staticStr;
    private final String finalStr = "10";
    private int a = getSum() + 5;
    private int b = getSum() - a;
    private int c = getSum() - b;

//    Анонимный блок инициализации
    {
        str = "10";
        b = 10;
    }

//    Статический блок инициализации
    static {
        staticStr = "10";
    }

    int getSum() {
        return a  + b + c;
    }
}

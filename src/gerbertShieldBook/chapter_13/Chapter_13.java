package gerbertShieldBook.chapter_13;

import gerbertShieldBook.chapter_13.auxiliaryClasses.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static helpers.Helpers.*;

public class Chapter_13 {
    public static void chapter_13() {
        printArticle("Chapter 13. Lambda expressions");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
        program_9();
        program_10();
        program_11();
        program_12();
        program_13();
        program_14();

        printArticleEnding();

    }

    private static void program_1() {
        printSection("Program_1. Lambda expression fundamentals");

//        Переменной типа функционального интерфейса присваивается лямбда-выражение
//        Анонимный метод определяет реализацию абстрактного метода int getNumber()
        MyNumber myNumber = () -> 144;

        System.out.println(myNumber.getNumber());

        myNumber = () -> (int) (Math.random() * 100);

        System.out.println(myNumber.getNumber());
        System.out.println(myNumber.getNumber());

//        Не совместимый между телом лямбды и объявление абстрактного метода
//        myNumber = () -> "123";

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. A lambda expression takes a parameter");

        LambdaDemo_1 isEven = (int x) -> (x % 2) == 0;

        int a = 10;
        System.out.println(isEven.test(a));
        System.out.println(isEven.test(11));

//        Можно не указывать ни тип, ни круглые скобки
        LambdaDemo_1 isPositive = x -> x > 0;

        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. A lambda expression takes two parameters");

        LambdaDemo_2 isFactor = (x, y) -> x % y == 0;
        isFactor = (int x, int y) -> x % y == 0;

        System.out.println(isFactor.test(20, 10));
        System.out.println(isFactor.test(20, 6));

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Block lambda expressions");

//        Переменной функционального интерфейса можно присвоить любую соответствуюзую лямбда функцию
        BlockLambdaDemo_1 factorial;

//        Здесь абстрактный метод использует параметр с типом int
        factorial = (int n) -> {
            int result = 1;

            for (int i = 1; i < n; i++) {
                result *= i;
            }

            return result;
        };

        System.out.println(factorial.function(10));
        System.out.println(factorial.function(7));

        BlockLambdaDemo_2 reverse;

//        Здесь в сигнатуре абстрактного метода указан тип String
        reverse = (String str) -> {
            StringBuilder result = new StringBuilder(str);
            return result.reverse().toString();
        };

        System.out.println(reverse.function("Maxim"));
        System.out.println(reverse.function("maxam"));
        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Generic Functional Interfaces");

//        Специфичная версия функционального интерфейса
        GenericFunctionInterface<Integer> factorial = (n) -> {
            int result = 1;

            for (int i = 1; i < n; i++) {
                result *= i;
            }

            return result;
        };

        System.out.println(factorial.function(4));

//        Другая специфичная версия функционального интерфейса
        GenericFunctionInterface<String> reverse = (str) -> {
            StringBuilder result = new StringBuilder(str);
            return result.reverse().toString();
        };

        System.out.println(reverse.function("the super-puper man"));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Passing Lambda expressions as argument");

        String originString = "Maxim Blinov, Hi noob!";
        String modifedString;

        modifedString = stringOperations((str) -> str.toUpperCase(), originString);
        System.out.println("modifedString = " + modifedString);

        modifedString = stringOperations((str) -> str.toLowerCase(), originString);
        System.out.println("modifedString = " + modifedString);

        PassedLambda trimSpaces = (String str) -> {
            StringBuilder result = new StringBuilder();
            for (String s : str.split(" ")) {
                result.append(s);
            }
            return result.toString();
        };

        modifedString = stringOperations(trimSpaces, originString);
        System.out.println("modifedString = " + modifedString);

        PassedLambda emtyVar;
//        Попытка передать не инициализированную переменную функционального интерфейса - без реализации
//        stringOperations(emtyVar,"Maxim");

        printSectionEnding();
    }

    private static String stringOperations(PassedLambda passedLambda, String string) {
        return passedLambda.function(string);
    }

    private static void program_7() {
        printSection("Program_7. Lambda expression and exceptions");

        DoubleNumericArrayFunc average = n -> {
            if (n.length == 0)
                throw new EmptyArrayException();

            double sum = 0;
            for (double v : n) {
                sum += v;
            }
            return sum / n.length;
        };

        double[] testArray = new double[]{10.0, 15.0, 30.0};
        double[] emptyArray = new double[]{};

        try {
            System.out.println(average.function(testArray));
            System.out.println(average.function(emptyArray));
        } catch (EmptyArrayException e) {
            System.out.println("Исключение обнаружено - " + e.getMessage());
        }

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Lambda expressions and variable capture");
//        Лямбда принимает финальные или фактически финальные переменные

        int num = 100;

        MyNumber_2 number = (n) -> {
//            Нельзя изменять переменные из объемлющей области, потому что они являются финальными
//            num ++;
            n += num + 20;
            return n;
        };
//          Эта строка кода превратит effectively final в not effectively final
//        num ++;

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. Methods references to static methods");

        String originalString = "Lambdas add power to Java";

        String modified = stringModifying(Chapter_13::toUpperCase, originalString);

        System.out.println("modified = " + modified);

        printSectionEnding();
    }

    private static String stringModifying(StringModifying sm, String string) {
        return sm.func(string);
    }

    private static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    private static void program_10() {
        printSection("Program_10. Method reference to instance methods");

        StringModifier stringModifier = new StringModifier();
        String originalString = "Lambdas add power to Java";

        String modified = stringModifying(stringModifier::toUpperCase, originalString);
        System.out.println("modified = " + modified);

        modified = stringModifying(stringModifier::toLowerCase, originalString);
        System.out.println("modified = " + modified);

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Большая задача с температурами");


        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. Method references with Generic");

        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 7, 9, 4};
        String[] strings = new String[]{"one", "two", "three", "one", "two"};

        int count = 0;

        count = myCountMatching(Chapter_13::<Integer>countMatching, integers, 4);
        System.out.println("count = " + count);

        count = myCountMatching(Chapter_13::<String>countMatching, strings, "one");
        System.out.println("count = " + count);

        printSectionEnding();
    }

    private static <T> int countMatching(T[] elements, T value) {
        int counter = 0;

        for (T element : elements) {
            if (element.equals(value))
                counter++;
        }

        return counter;
    }

    private static <T> int myCountMatching(GenericInterface<T> gi, T[] elements, T value) {
        return gi.function(elements, value);
    }

    private static void program_13() {
        printSection("Program_13. Constructor reference");

        ConstructorReference createMyClass = MyClass_1::new;

        System.out.println(createMyClass.function(100));
        System.out.println(createMyClass.function(100));
        System.out.println(createMyClass.function(100));

        printSectionEnding();
    }

    private static void program_14() {
        printSection("program_13. Predefined functional interfaces");

        UnaryOperator<Integer> factorial = (n) -> {
            int result;
            int i;
            for (i = 1, result = 1; i <= n; i++) {
                result *= i;
            }
            return Integer.valueOf(result);
        };

        System.out.println(factorial.apply(10));
        System.out.println(factorial.apply(3));

        printSectionEnding();
    }


}






























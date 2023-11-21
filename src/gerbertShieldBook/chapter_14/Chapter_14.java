package gerbertShieldBook.chapter_14;

import gerbertShieldBook.chapter_14.auxiliaryClasses.*;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_14 {


    public static void chapter_14() {
        printArticle("Chapter 14. Generics");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();
//        program_10();
        program_11();

        printArticleEnding();

    }

    private static void program_1() {
        printSection("Program_1. Generics. A simple generic class");

        SimpleGeneric<Integer> intObject;
        intObject = new SimpleGeneric<Integer>(144);

        intObject.showType();
        System.out.println("value - \"" + intObject.getObjectField() + "\"");

        SimpleGeneric<String> stringObject;
        stringObject = new SimpleGeneric<>("Maxim");

        stringObject.showType();
        System.out.println("value - \"" + stringObject.getObjectField() + "\"");

//         Данная строка не выполняется, потому что SimpleGeneric<Integer> и
//         SimpleGeneric<String> - два разных типа, две специфические версии одной заготовки
//        intObject = stringObject;

        intObject.showSelfType();

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Original Generics");

        OriginalGenercis integerGeneric = new OriginalGenercis(144);
        OriginalGenercis stringGeneric = new OriginalGenercis("Maxim");

        integerGeneric.showObjectype();
        System.out.println("value - \"" + (Integer) integerGeneric.getObjectField() + "\"");

        stringGeneric.showObjectype();
        System.out.println("value - \"" + (String) stringGeneric.getObjectField() + "\"");

        integerGeneric = stringGeneric;
        integerGeneric.showObjectype();
//        Подменили ссылки и попытались привести к Integer, ошибка времени исполнения
//        System.out.println("value - \"" + (Integer) integerGeneric.getObjectField() + "\"");

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. The generic with two type parameters");

        TwoGeneric<Integer, String> twoGeneric;
        twoGeneric = new TwoGeneric<>(24, "Maxim");

        System.out.println("twoGeneric.getFirstField() = " + twoGeneric.getFirstField());
        System.out.println("twoGeneric.getSecondField() = " + twoGeneric.getSecondField());

        twoGeneric.showFirstFieldType();
        twoGeneric.showSecondFieldType();

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Bounded types and wildcard arguments");
//        Ограниченный тип и аргумент с подстановочным знаком

        Integer[] integers = new Integer[]{10, 30, 10, 30};
        Double[] doubles = new Double[]{0.0, 100.0, 0.0, 20.0, 0.0, 0.0};
        Float[] floats = new Float[]{0.0F, 100.0F, 5.0F, 20.0F, 0.0F, 0.0F};

        BoundedGeneric<Integer> integerBoundedGeneric;
        integerBoundedGeneric = new BoundedGeneric<>(integers);

        BoundedGeneric<Double> doubleBoundedGeneric;
        doubleBoundedGeneric = new BoundedGeneric<>(doubles);

        BoundedGeneric<Float> floatBoundedGeneric;
        floatBoundedGeneric = new BoundedGeneric<>(floats);

        System.out.println("integerBoundedGeneric.average() = " + integerBoundedGeneric.average());
        System.out.println("doubleBoundedGeneric.average() = " + doubleBoundedGeneric.average());
        System.out.printf("floatBoundedGeneric.average() = %.1f%n", floatBoundedGeneric.average());

//        Type parameter 'java.lang.String' is not within its bound;
//        should extend 'java.lang.Number'
//        BoundedGeneric<String> stringBoundedGeneric;

        if (integerBoundedGeneric.isSameAverage(doubleBoundedGeneric)) {
            System.out.println("integers имеет такое-же среднее как и doubles");
        }
        if (integerBoundedGeneric.isSameAverage(floatBoundedGeneric)) {
            System.out.println("integers имеет такое-же среднее как и floats");
        }

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Bounded wildcard argument - ограниченный аргумент");
//        Ограниченный аргумент с подстановочным знаком

        final TwoDimensional[] twoDimensionals = new TwoDimensional[]{
                new TwoDimensional(10.5, 4.3),
                new TwoDimensional(-3.3, 4.1),
                new TwoDimensional(3, 1),
                new TwoDimensional(4, 7.7)
        };

        final ThreeDimansional[] threeDimansionals = new ThreeDimansional[]{
                new ThreeDimansional(5.5, 10.5, 4.3),
                new ThreeDimansional(5.5, -3.3, 4.1),
                new ThreeDimansional(5.5, 3, 1),
                new ThreeDimansional(5.5, 4, 7.7)
        };

        final FourDimensional[] fourDimensionals = new FourDimensional[]{
                new FourDimensional(6.9, 5.5, 10.5, 4.3),
                new FourDimensional(6.9, 5.5, -3.3, 4.1),
                new FourDimensional(6.9, 5.5, 3, 1),
                new FourDimensional(6.9, 5.5, 4, 7.7)
        };


        Coordinates<TwoDimensional> twoDimensionalCoordinates = new Coordinates<>(twoDimensionals);
        Coordinates<ThreeDimansional> threeDimansionalCoordinates = new Coordinates<>(threeDimansionals);
        Coordinates<FourDimensional> fourDimensionalCoordinates = new Coordinates<>(fourDimensionals);

        Coordinates.showXY(twoDimensionalCoordinates);
        Coordinates.showXY(threeDimansionalCoordinates);
        Coordinates.showXY(fourDimensionalCoordinates);

//        Coordinates.showXYZ(twoDimensionalCoordinates);
        Coordinates.showXYZ(threeDimansionalCoordinates);
        Coordinates.showXYZ(fourDimensionalCoordinates);

//        Coordinates.showXYZT(twoDimensionalCoordinates);
//        Coordinates.showXYZT(threeDimansionalCoordinates);
        Coordinates.showXYZT(fourDimensionalCoordinates);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Generic method");

        Integer[] integers = new Integer[]{
                10, 20, 30, 35, 50
        };

        Integer number = 35;

        System.out.println("GenericMethod.isIn(number,integers) = " + GenericMethod.isIn(number, integers));

//        Указание аргументов типа обобщенного метода
        System.out.println(GenericMethod.<Integer, Integer>isIn(10, new Integer[]{20, 10, 30}));

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Generic constructor");

        Integer number_1 = 44;
        Float number_2 = 44f;
        Character number_3 = 'A';

        GenericConstructor doubleObject_1 = new GenericConstructor(number_1);
        GenericConstructor doubleObject_2 = new GenericConstructor(number_2);
        GenericConstructor doubleObject_3 = new GenericConstructor(number_3);

        doubleObject_1.showInnerValue();
        doubleObject_2.showInnerValue();
        doubleObject_3.showInnerValue();

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Generic interface");

        GenericClass<Integer> integres = new GenericClass<>(new Integer[]{10, 20, -30, 40, 0});

        System.out.println("integres.min() = " + integres.min());
        System.out.println("integres.max() = " + integres.max());

        Double[] da = new Double[]{0.0, 100.0, 0.0, 20.0, 0.0, 0.0};
        GenericClass<Double> doubles = new GenericClass<>(da);

        System.out.println("doubles.min() = " + doubles.min());
        System.out.println("doubles.max() = " + doubles.max());

//        Данный класс является специфической версией обобщенного интерфейса
        IntegerGenericClass ints = new IntegerGenericClass(new Integer[]{10, 20, -30, 40, 0});

        System.out.println("ints.min() = " + ints.min());
        System.out.println("ints.max() = " + ints.max());

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. ");

        GenericSuperClass<Integer> obj1 = new GenericSubclass<Integer, String>();
//        GenericSuperClass<String> obj2 = new GenericSubclass<Integer,String>();

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. Run-time type comparisons");

        Gen1<Integer> integerObj1 = new Gen1<>();
        Gen2<Integer> integerObj2 = new Gen2<>();

        if (integerObj1 instanceof Gen1<?>) {
            System.out.println("integerObj1 является экземпляром класса Gen1<?>");
        }

        if (integerObj1 instanceof Gen2<?>) {
            System.out.println("integerObj1 является экземпляром класса Gen2<?>");
        }

        if (integerObj2 instanceof Gen1<?>) {
            System.out.println("integerObj2 является экземпляром класса Gen1<?>");
        }

        if (integerObj2 instanceof Gen2<?>) {
            System.out.println("integerObj2 является экземпляром класса Gen2<?>");

        }

        if (integerObj1 instanceof Gen1<? extends Number>) {
            System.out.println("integerObj1 является экземпляром класса Gen2<? extends Number>");
        }

  /*      if (integerObj1 instanceof Gen1<String>) {
            System.out.println("integerObj1 является экземпляром класса Gen2<String>");
        }*/

//        Допустимое приведение
        Gen1<Integer> integerObj21 = (Gen1<Integer>) integerObj2;

//        Недопустимое приведение
//        Gen2<Long> integerObj22 = (Gen1<Long>) integerObj2;


        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Some generic restricts");

        ResrictiedGeneric<Integer> resrictiedGeneric = new ResrictiedGeneric<>(1,new Integer[]{});

        ResrictiedGeneric<?>[] resrictiedGenerics = new ResrictiedGeneric<?>[10];
//        Второе ограничение
//        ResrictiedGeneric<Integer>[] intResrictiedGenerics = new ResrictiedGeneric<Integer>[10];

        printSectionEnding();
    }

}





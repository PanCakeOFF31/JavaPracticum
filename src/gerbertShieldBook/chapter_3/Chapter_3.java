package gerbertShieldBook.chapter_3;

import static helpers.Helpers.*;
import static helpers.OneDimensionalArray.*;
import static helpers.TwoDimensionalArray.*;

// Data types, variables and arrays
public class Chapter_3 {
    public static void chapter_3() {
        printArticle("Chapter 3. Data types, variables and arrays");

//        Целочисленные литералы и их формы записи
//        program_1();

//        Литералы с плавающей точкой
//        program_2();

//        Символьные литералы
//        program_3();

//        Переменные
//        Динамическая типизация
//        Области видимости и время жизни переменных
//        program_4();

//        Преобразование (conversion) и приведение (casting) типов, автоматическое преобразование (type promotion)
//        program_5();

//        Одномерные массивы - One-dimensional arrays
//        program_6();

//        Многомерные массивы - Multi-dimensional arrays
//        program_7();

//        Выведение типов локальных переменных - Type Inference
//        program_8();

        printArticleEnding();
    }

    static void program_1() {
        printSection("Целочисленные литералы:");

        System.out.println("По умолчанию литералы целочисленные.");
        System.out.println("Чтобы явно указать long тип, нужно дописать L/l в конце");

        System.out.println("Цело число записанное в виде 10 в десятичной системе = " + 10);
        System.out.println("Цело число записанное в виде 0b101010 в переводе на десятичную систему = " + 0b101010);
        System.out.println("Цело число записанное в виде 0B1010 в переводе на десятичную систему = " + 0B1010);
        System.out.println("Цело число записанное в виде 010 в переводе на десятичную систему = " + 010);
        System.out.println("Цело число записанное в виде 0x10f в переводе на десятичную систему = " + 0x10f);
        System.out.println("Цело число записанное в виде 0X10F в переводе на десятичную систему = " + 0X10F);

        int numberOne = 123_456____789;
        System.out.println("Нижнее подчеркивание, numberOne = 123_456_____789, numberOne = " + numberOne);
        System.out.println("Двоичная форма записи с подчеркиванием, 0b1110_1010_0110 = " + 0b1110_1010_0110);
        System.out.println("Явное указание требуется для long literal, 0xfFFl или 0XFffFL= " + 0xffFfl);

        printSectionEnding();
    }

    static void program_2() {
        printSection("Литералы с плавающей точкой");

        System.out.println("Для указания литерала с типом double D/d можно не добавлять в конце.");
        System.out.println("Литералы с плавающей точкой и типом double 45.2312 или 45.2312d или 45.2312D эквиваленты = " + 45.2312D);

        System.out.println("Для указания литерала с типом float требуется в конце дописать F/f");
        System.out.println("Литералы с плавающей точкой и типом float требуют явного указания, 45.2312f или 45.2312F = " + 45.2312F);

        printSubSection("Десятичная техническая форма записи");
        System.out.println("Для указания научной формы записи используется конструкция, примеры: e+2/E-3/E+0");
        System.out.println("234123.3e10 или 234123.3E10 будет литералом типа double со значением равным: " + 234123.3E10);
        printSubSectionEnding();

        printSubSection("Шестнадцатеричная научная форма записи");
        System.out.println("В ситуации, когда используется шестнадцатеричная форма записи, экспонента заменяется буквой P/p, так как E/e уже занята.");
        System.out.println("Пример №1. Литерал с типом float - \"0xfeP3f\", где 0xfe =  254, P3 = 2^3, итого: 254*3 = " + 0xfeP3f);
        System.out.println("Пример №2. Литерал с явным указанием типа double - \"0XfeP-4D\", гдк 0Xfe = 254, P-4 = 2^-4, итого: 254*1/16 = " + 0XfeP-4D);
        printSubSectionEnding();

        printSectionEnding();
    }

    static void program_3() {
        printSection("Символьные литералы");

        // Стандартный вариант написать символ
        char character_1 = 'B';
        // Указать индекс в десятичной СИ
        char character_2 = 100;
        char character_3 = 73;
        // Указать индекс символа в шестнадцатеричной СИ
        char character_4 = '\u002F';
        // Указать индекс в восьмеричной СИ
        char character_5 = '\117';

        System.out.println("Объявляем такую запись - \"character_1 = 'B'\", проверяем, что character_1 = " + character_1);
        System.out.println("Объявляем такую запись - \"character_2 = 100\", проверяем, что character_2 = " + character_2);
        System.out.println("Объявляем такую запись - \"character_3 = 73\", проверяем, что character_3 = " + character_3);
        System.out.println("Объявляем такую запись - \"character_4 = '\\u002F'\", проверяем, что character_4 = " + character_4);
        System.out.println("Объявляем такую запись - \"character_5 = '\\117'\", проверяем, что character_5 = " + character_5);

        printSectionEnding();
    }

    static void program_4() {
        printSection("Переменные, область видимости и время жизни");

        // Первая переменная в области видимости тела метода
        int x = 10;
        System.out.println("Вывод первой переменной, объявленной в начале метода program_4(), x = " + x);

        if (x == 10) {
            // Объявление второй переменной, внутренняя область видимости
            int y = 30;
            System.out.println("Вывод первой переменной, объявленной в начале метода program_4(), x = " + x);
            System.out.println("Вывод второй переменной, во внутренней области видимости, y = " + y);
        }

        // Здесь об переменной y ничего не известно, так как мы покинули ее области видимости
        // Время жизни ограничивается входом в scope и выходом этого scope
//        System.out.printf("y = " + y);

        if (x == 10) {
            // Объявление третей переменной, внутренняя область видимости
            int y = 20;
            System.out.println("Вывод первой переменной, объявленной в начале метода program_4(), x = " + x);
            System.out.println("Вывод третей переменной, во внутренней области видимости, y = " + y);
        }

        for (int i = 0; i < 3; i++) {
            // При входе объявляется переменная
            int y = 15;
            y += 30;
            System.out.println("iteration #" + i + ", y = " + y);
            // При завершении каждой итерации переменные удаляются
        }

        // Здесь аргменты условной конструкции уже не существуют, к ним нельзя обратиться
//        System.out.println("i = " + i);

        printSectionEnding();
    }

    static void program_5() {
        printSection("Преобразование и приведение типов");

        byte var_1 = 127;
        short var_2 = 260;
        int var_3 = 50;
        long var_4 = 60L;

        char var_5 = 'A';

        float var_6 = 66000.3F;
        double var_7 = 142.34;

        byte var_10;
        short var_11;
        int var_12;
        long var_13;

        // Присвоение byte к byte
        var_10 = var_1;
        System.out.println("byte var_10 = byte var_1 (127). var_10 = " + var_10);

        // Присвоение short к byte, неявное преобразование не допустимо, short хранит больше допустимых значений чем byte
        // Требуется выполнить явное преобразование типов для корректности операции
        var_10 = (byte) var_2;
        System.out.println("byte var_10 = short var_2 (260), var_10 = " + var_10);

        var_11 = (short) var_6;
        System.out.println("short var_11 = float var_6 (66000.3F), var_11 = " + var_11);

        // При вычислениях целых чисел происходит не явное автоматическое расширение типов (расширенное приведение) до integer
        // Требуется явно указать целевой тип
        // var_10 = var_1 * 3; Даннаый участок кода не компилируемый
        var_10 = (byte) (var_1 * 3);

        // Type promotion - продвижение типов в выражениях с разным типов операндов
        // Приоритеты: byte/short/char->int->long->float->double
        System.out.println("byte var_1 + float var_6 = " + (var_1 + var_6));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Массивы, одномерный массив");

        // Объявление переменных с типом целочисленный одномерный массив без инициализации значений элементов массива
        int[] array_1;
        float array_2[];

        array_1 = new int[4];
        array_2 = new float[5];

        // Объявление и присвоение переменной с типом целочисленный одномерный массив размером в 0 элементов
        int[] array_3 = new int[0];

        boolean[] array_4 = new boolean[2];
        // Инициализатор массив содержит выражения
        int[] array_5 = {10, 10 * 2, 30, 15, array_1.length, 30};

        System.out.println("array_1.length = " + array_1.length);
        printOneDimensionalArray(array_1);

        System.out.println("array_2.length = " + array_2.length);
        printOneDimensionalArray(array_2);

        System.out.println("array_3.length = " + array_3.length);
        printOneDimensionalArray(array_3);

        System.out.println("array_4.length = " + array_4.length);
        printOneDimensionalArray(array_4);

        String[] stringArray = new String[3];
        System.out.println("stringArray.length = " + stringArray.length);
        printOneDimensionalArray(stringArray);

        System.out.println("array_5.length = " + array_5.length);
        printOneDimensionalArray(array_5);

        // Две эквивалентные формы записи
        int[] array_6 = new int[5];
        int array_7[] = new int[5];

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Многомерные массивы");
        printSubSection("Стандартный двумерный массив");

        int[][] twoD_1 = new int[3][4];

        System.out.println("Размеры массива строка/столбец: " + twoD_1.length + "x" + twoD_1[0].length);
        printTwoDimensionalArray(twoD_1);

        printSubSectionEnding();
        printSubSection("Ступенчатый, нерегулярный массив");

        int[][] twoD_2 = new int[4][];
        twoD_2[0] = new int[5];
        twoD_2[1] = new int[2];
        twoD_2[2] = new int[10];
        twoD_2[3] = new int[0];

        System.out.println("Размеры массива - 4 строки, столбцы разные");
        printTwoDimensionalArray(twoD_2);

        printSubSectionEnding();
        printSubSection("Массив с автозаполнением");

        int[][] twoD_3 = new int[5][3];
        fillTwoDimansionalArray(twoD_3,0,10);
        printTwoDimensionalArray(twoD_3);

        printSubSectionEnding();
        printSubSection("Инициализация массива с помощью списка инициализации - инициализатор массива");

        int[][] twoD_4 = {{1,2,3},
                        {4,5,6,7,8,9},
                        {10,11,12},
                        {}};
        printTwoDimensionalArray(twoD_4);

        printSubSectionEnding();
        printSubSection("Альтернативная форма объявления массива");

        // Две эквивалентные формы записи
        int[] array_6 = new int[5];
        int array_7[] = new int[5];

        printSubSectionEnding();
        printSectionEnding();
    }

    private static void program_8() {
        printSection("Type inference of local variables");

        double var1 = 100.0;
        var var2 = 100.1;
        var var = 31;
        int var3 = -var;

        // При использовании var с массивами, указывать квадратные скобки не нужно
        var array1 = new int[2];
        var array2 = new int[2][2];

        // Ошибочные объявления
//        var var10;
//        var[] array10 = new int[3];

        System.out.println("var может быть как ключевым словом так и идентификатором");
        System.out.println("double var1 = " + var1);
        System.out.println("var var2 = " + var2);
        System.out.println("var var = " + var);
        System.out.println("int var3 = " + var3);

        printOneDimensionalArray(array1);
        printTwoDimensionalArray(array2);

        printSectionEnding();
    }

        /*private static void program_*() {
        printNewSection("");
        printSectionEnding();
    }*/
}

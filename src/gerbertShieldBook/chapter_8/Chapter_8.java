package gerbertShieldBook.chapter_8;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_8 {
    public static void chapter_8() {
        printArticle("Chapter 8. Inheritance");

//        program_1();

//        program_2();

        program_3();

        printArticleEnding();

    }

    static void program_1() {
        printSection("Program_1. Проверяю как получить доступ к private родителя");

        SuperClass superClass = new SuperClass(10, 20);
        SubClass subClass = new SubClass(14, 16, 18);
        SubSubClass subSubClass = new SubSubClass(2, 3, 4, 6);

        System.out.println(superClass.getA());
        System.out.println(superClass.getB());

        subClass.setA(100);
        System.out.println(subClass.getA());
        System.out.println(subClass.getB());
        System.out.println(subClass.getC());

        subSubClass.setA(999);
        System.out.println(subSubClass.getA());
        System.out.println(subSubClass.getB());
        System.out.println(subSubClass.getC());


        printSectionEnding();
    }

    static void program_2() {
        printSection("Program_2. Абстрактный класс");

        FourAngleFigure figure;
        figure = new Rectangular(10, 20);

        System.out.println("figure.getHeight() = " + figure.getHeight());
        System.out.println("figure.getWidth() = " + figure.getWidth());
        System.out.println("figure.area() = " + figure.area());

        figure = new Rhombus(10, 15, 90);
        System.out.println("figure.getHeight() = " + figure.getHeight());
        System.out.println("figure.getWidth() = " + figure.getWidth());
        System.out.println("figure.area() = " + figure.area());


//        Type casting
        var testFigure1 = getFigure(0);
        testFigure1.finalMethod();
        ((Rectangular)testFigure1).getPerimeter();
        var testFigure2 = getFigure(1);
        testFigure2.finalMethod();
//        testFigure2.getPerimeter();
//        var testFigure3 = getFigure(2);
//        System.out.println("testFigure1.getClass() = " + testFigure1.getClass());

        printSectionEnding();
    }

    private static FourAngleFigure getFigure(int which) {
        switch (which) {
            case 0: return new Rectangular(10,20);
            case 1: return new Rhombus(10,20,90);
            default: return null;
        }
    }

    static void program_3() {
        printSection("");

        

        printSectionEnding();
    }

    /*static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

class SuperClass {
    protected int a;
    private int b;
//    private  a;

    public SuperClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}

class SubClass extends SuperClass {
    private int c;

    public SubClass(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    @Override
    public void setA(int a) {
        super.a = a;
    }

    public int getA() {
        return super.getA();
    }

    @Override
    public void setB(int b) {
        super.setB(b);
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}

class SubSubClass extends SubClass {
    private int d;

    public SubSubClass(int a, int b, int c, int d) {
        super(a, b, c);
        this.d = d;
    }

    @Override
    public void setA(int a) {
        super.setA(a);
    }
}

abstract class FourAngleFigure {
    private double width;
    private double height;

    protected FourAngleFigure(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    abstract protected double area();

    final public void finalMethod() {
        System.out.println("Метод of FourAngleFigure");
    }

}

class Rectangular extends FourAngleFigure {

    public Rectangular(double width, double height) {
        super(width, height);
    }

    @Override
    protected double area() {
        return super.getWidth() * super.getHeight();
    }

    public int getPerimeter() {
        return 0;
    }
}

class Rhombus extends FourAngleFigure {
    private double angelInDegree;

    public Rhombus(double width, double height, double angleInDegree) {
        super(width, height);
        this.angelInDegree = angleInDegree;
    }

    @Override
    protected double area() {
        return super.getWidth() * super.getHeight() * Math.sin(Math.toRadians(angelInDegree));
    }
}



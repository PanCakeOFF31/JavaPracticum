package yandexPracticum.javaCoreIntroduction.theme_16_Object.lesson_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static helpers.Helpers.*;

public class Practicum_1 {
    public static void practicum_1() {
        printSection("Practicum_1");

        program_1();

        program_2();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. Метод equals()");

        Book book1 = new Book("Волкодав", "Мария Семенова", 575);
        Book book2 = new Book("Волкодав", "Мария Семенова", 575);
        String book3 = new String(" ");
        Book book4 = new Book(null, "Мария Семенова", 575);

        System.out.println("book1 == book1 - " + (book1 == book1));
        System.out.println("book1.equals(book1) - " + (book1.equals(book1)));
        System.out.println("book1.equals(null) - " + (book1.equals(null)));
        System.out.println("book1.equals(book2) - " + (book1.equals(book2)));
        System.out.println("book1.equals(book3) - " + (book1.equals(book3)));
        System.out.println("book1.equals(book4) - " + (book1.equals(book4)));

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Progra_2. Проверяю непонятку");

        test(new Test1(), new Test2());
        test(new Test2(), new Test1());

        printSectionEnding();
    }

    static void test(Object a, Object b) {
        System.out.println(a.equals(b));

    }



     /*private static void program_*() {
        printSubSection("");
        printSectionEnding();
    }*/
}

class Test1 {
    @Override
    public boolean equals(Object obj) {
        System.out.println("Метод сравнения класса Test1");
        return false;
    }

}

class Test2 {
    @Override
    public boolean equals(Object obj) {
        System.out.println("Метод сравнения класса Test2");
        return false;
    }
}

class Book {
    public String title;
    public String author;
    public int pagesNumber;

    public Book(String title, String author, int pagesNumber) {
        this.title = title;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }

    @Override  // аннотация сигнализует о том, что мы переопределяем метод
    public boolean equals(Object obj) {
        if (this == obj) {
            System.out.println("Вы передали тот же самый объект");
            return true; // проверяем адреса объектов
        }

        if (obj == null) {
            System.out.println("Вы передали ссылки null");
            return false;
        }

        if (!(obj instanceof Book)) {
            System.out.println("Вы сравниваете объекты разных классов");
        }

        if (this.getClass() != obj.getClass()) {
            System.out.println("Вы сравниваете объекты разных классов");
            return false;
        }

        Book book = (Book) obj;
        boolean isEqual = this.title.equals(book.title) &&
                this.author.equals(book.author) &&
                (this.pagesNumber == book.pagesNumber);

        return isEqual;

    }
}

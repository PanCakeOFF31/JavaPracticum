package freePractise.lombok;

import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Lombok {
    public static void main(String[] args) {
        printArticle("Lombok annotations");

//        program_1();
        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Annotations");

        {
            Person person1 = new Person();
            Person person2 = Person.createPersin("asd", 10, true);
            Person person3 = new Person("Maxim", null);

            System.out.println("person1 = " + person1);
            System.out.println("person2 = " + person2);
            System.out.println("person3 = " + person3);
        }

        {
//            Book book1 = Book.of("Red ball", 156.6);
//            Book book2 = Book.of("Green ball", 256.6);

            Book book1 = new Book("Red ball", 156.6);
            Book book2 = new Book("Green ball", 256.6);

            System.out.println("book1 = " + book1);
            System.out.println("book2 = " + book2);

            Book book3 = book1.withTitle("Ultra");
            System.out.println("book3 = " + book3);

            book3.setPrice(300.5);
            System.out.println("book3 = " + book3);
        }

        {
            Book book1 = new Book("Red ball", 100.0);
            var book2 = book1.withPrice(200.0);

            System.out.println("book1 = " + book1);
            System.out.println("book2 = " + book2);

            System.out.println("book1.equals(book2) = " + book1.equals(book2));
        }

        Logger.printMessage("Box");
        {
//            Box box1 = new Box(10, 20);
//            System.out.println("box1 = " + box1);

            Box box2 = Box.builder().width(100).height(200).build();
            System.out.println("box2 = " + box2);
        }

        printSectionEnding();
    }
    
    private static void program_2() {
        printSection("Program_2. ");
    
        
                
        printSectionEnding();
    }
}














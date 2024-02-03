package headFirst;

import headFirst.chapter_4_factory.Chapter_4_Factory;

import static helpers.Helpers.printArticle;
import static helpers.Helpers.printArticleEnding;

public class HeadFirst {
    public static void main(String[] args) {
        printArticle("HeadFirst");

//        Strategy
//        Chapter_1_Strategy.chapter_1();
//        Observer
//        Chapter_2_Observer.chapter_2();
//        Decorator
//        Chapter_3_Decorator.chapter_3();

//        Factory
        Chapter_4_Factory.chapter_4();


        printArticleEnding();
    }
}

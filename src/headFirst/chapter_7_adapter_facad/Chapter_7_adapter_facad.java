package headFirst.chapter_7_adapter_facad;

import headFirst.chapter_7_adapter_facad.zoo.adapter.TurkeyAdapter;
import headFirst.chapter_7_adapter_facad.zoo.ducks.Duck;
import headFirst.chapter_7_adapter_facad.zoo.ducks.MallardDuck;
import headFirst.chapter_7_adapter_facad.zoo.turky.Turkey;
import headFirst.chapter_7_adapter_facad.zoo.turky.WildTurkey;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;

public class Chapter_7_adapter_facad {
    public static void chapter_7() {
        printArticle("Adapter and Facade Pattern");

        program_1();
        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Adapter. Адаптер от индюшке к утке");

        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
//        Чтобы работать с индюшкой как с уткой, нужен адаптер.
//        Целевой интерфейс - Duck
//        Адаптер - turkeyAdapter
//        Адаптируемый объект - индюшка
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        Logger.printMessage("Прямые вызовы");
        {

            System.out.println("The duck says...");
            duck.quack();

            System.out.println("The Turkey says...");
            turkey.gobble();

            System.out.println("The TurkeyAdapter says...");
            turkeyAdapter.quack();
        }

        Logger.printMessage("Тестирование Duck интерфейса");
        {
            testDuck(duck);
            testDuck(turkeyAdapter);
        }


        printSectionEnding();
    }

//    Функционал написанный для утки, хочу так же работать с индюшкой.
    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    private static void program_2() {
        printSection("Program_2. Facade");



        printSectionEnding();
    }
}

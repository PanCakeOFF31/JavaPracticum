package headFirst;

import headFirst.chapter_2_observer_repetition.Chapter_2_Observer_Repetition;

import static helpers.Helpers.printArticle;
import static helpers.Helpers.printArticleEnding;

public class HeadFirst {
    public static void main(String[] args) {
        printArticle("HeadFirst");

//        Strategy - гибкая модификация алгоритмов (композиция)
//        Chapter_1_Strategy.chapter_1();
//        Chapter_1_Strategy_Repetition_v1.chapter_1();
//        Chapter_1_Strategy_Repetition_v2.chapter_1();

//        Observer - работаем по подписке (список наблюдателей/композиция)
//        Chapter_2_Observer.chapter_2();
        Chapter_2_Observer_Repetition.chapter_2();

//        Decorator - масштабируем заворотом (композиция - декоратор/оберток)
//        Chapter_3_Decorator.chapter_3();
//        Factory - инкапсулируем генераторов(композиция/наследование)
//        Chapter_4_Factory.chapter_4();
//        Singleton
//        Chapter_5_Singleton.chapter_5();
//        Command
//        Chapter_6_command.chapter_6();
//        Adapter and Facade
//        Chapter_7_adapter_facad.chapter_7();
//        Template Method
//        Chapter_8_template_method.chapter_8();
//        Iterator and Компоновщик
//        Chapter_9_iterator.chapter_9();
//        State
//        Chapter_10_state.chapter_10();
//        Заместитель - Proxy
//        Chapter_11_proxy.chapter_11();
//        Составные паттерны
//        Chapter_12_composite.chapter_12();

        printArticleEnding();
    }
}

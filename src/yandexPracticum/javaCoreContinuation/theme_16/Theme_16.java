package yandexPracticum.javaCoreContinuation.theme_16;

import static helpers.Helpers.printArticle;
import static helpers.Helpers.printArticleEnding;
import static yandexPracticum.javaCoreContinuation.theme_16.lesson_1.Practicum_1.practicum_1;
import static yandexPracticum.javaCoreContinuation.theme_16.lesson_2.Practicum_2.practicum_2;
import static yandexPracticum.javaCoreContinuation.theme_16.lesson_3.Practicum_3.practicum_3;
import static yandexPracticum.javaCoreContinuation.theme_16.lesson_4.Practicum_4.practicum_4;
import static yandexPracticum.javaCoreContinuation.theme_16.lesson_5.Practicum_5.practicum_5;

public class Theme_16 {
    public static void theme_16() {
        printArticle("Theme_16. Internet, HTTP, JSON");

//
//        Http-server. EndPoints
        practicum_1();
//        GSON, Gson, GsonBuilder, TypeAdapter
        practicum_2();
//        HttpExchange methods
        practicum_3();

//        HttpClient
        practicum_4();

//        processing JSON
        practicum_5();

        printArticleEnding();
    }
}

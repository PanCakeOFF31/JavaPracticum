package yandexPracticum.javaCoreContinuation.theme_16.lesson_4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_4 {
    public static void main(String[] args) {
//        Первое знакомство
//        program_1();

//        Запуск HTTP-клиента
//        program_2();

//        httpbin.org
        program_3();
    }


    public static void practicum_4() {
        printSection("Practicum_4");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        URI uri = URI.create("https://ru.wikipedia.org/wiki/Список_кодов_состояния_HTTP");

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .version(HttpClient.Version.HTTP_1_1)
                .header("Accept", "text/html")
                .build();

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        HttpClient clientDefault = HttpClient.newHttpClient();


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. ");

        try {
            URI uri = URI.create("https://ya.ru");

            HttpClient clien = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(uri)
                    .version(HttpClient.Version.HTTP_1_1)
                    .header("Accept", "text/html")
                    .build();

            HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();

            HttpResponse<String> response = clien.send(request, handler);
            System.out.println("Код ответа: " + response.statusCode());
            System.out.println("Тело ответа: \n" + response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println("Введен некорректный адрес");
        }


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. httpbin.org");

        int requestedStatus = 500;
        URI uri = URI.create("http://httpbin.org/status/" + requestedStatus);
        HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int status = response.statusCode();
            // обрабатываем коды успешного состояния
            if(status >= 200 && status <= 299) {
                System.out.println("Сервер успешно обработал запрос. Код состояния: " + status);
                return;
            }
            // обрабатываем коды состояния, говорящие об ошибке на стороне клиента
            if(status >= 400 && status <= 499) {
                System.out.println("Сервер сообщил о проблеме с запросом. Код состояния: " + status);
                return;
            }
            // обрабатываем коды состояния, говорящие об ошибке на стороне сервера
            if(status >= 500 && status <= 599) {
                System.out.println("Сервер сообщил о внутренней проблеме и невозможности обработать запрос." +
                        " Код состояния: " + status);
            } else { // обрабатываем остальные коды состояния
                System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + status);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Во время выполнения запроса ресурса по url-адресу: '" + uri + "' возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }
        printSectionEnding();
    }

}

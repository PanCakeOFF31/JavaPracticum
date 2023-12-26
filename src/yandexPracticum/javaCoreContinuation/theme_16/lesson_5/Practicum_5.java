package yandexPracticum.javaCoreContinuation.theme_16.lesson_5;

import com.google.gson.*;
import helpers.coloredString.ColoredString;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_5 {
    public static void main(String[] args) {

//        program_3();
//        program_9();
    }

    public static void practicum_5() {
        printSection("Practicum_5");

//        JSON methods
        program_1();
        program_2();
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
        printSection("Program_1. JSON");

        Logger.printMessage("toJson(), non Nulls()");
        {
            Gson gson = new Gson();

            A a1 = new A(10, 20, 30);
            A a2 = new A(10, 10, 15, "Box");

            String jsonObject1 = gson.toJson(a1);
            String jsonObject2 = gson.toJson(a2);

            System.out.println("jsonObject1 = " + jsonObject1);
            System.out.println("jsonObject2 = " + jsonObject2);
        }

        Logger.printMessage("toJson(), serializeNulls()");
        {
            Gson gson = new GsonBuilder().serializeNulls().create();

            A a1 = new A(10, 20, 30);
            A a2 = new A(10, 10, 15, "Box");

            String jsonObject1 = gson.toJson(a1);
            String jsonObject2 = gson.toJson(a2);

            System.out.println("jsonObject1 = " + jsonObject1);
            System.out.println("jsonObject2 = " + jsonObject2);
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. ");

        JsonElement jsonElement = JsonParser.parseString("{\"width\":10,\"height\":10,\"weight\":15,\"title\":\"Box\"}");

        System.out.println("jsonElement.isJsonNull() = " + jsonElement.isJsonNull());
        System.out.println("jsonElement.isJsonObject() = " + jsonElement.isJsonObject());

        printSectionEnding();
    }

    static class A {
        int width;
        int height;
        int weight;
        String title;

        public A(int width, int height, int weight) {
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        public A(int width, int height, int weight, String title) {
            this(width, height, weight);
            this.title = title;
        }
    }

    private static void program_3() {
        printSection("Program_3. ipwhois");

        HttpClient client = HttpClient.newHttpClient();

        URI url = URI.create("https://ipwhois.app/json/46.226.227.20?lang=en");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // передаем парсеру тело ответа в виде строки, содержащей данные в формате JSON
                JsonElement jsonElement = JsonParser.parseString(response.body());
                if (!jsonElement.isJsonObject()) { // проверяем, точно ли мы получили JSON-объект
                    System.out.println("Ответ от сервера не соответствует ожидаемому.");
                    return;
                }
                // преобразуем результат разбора текста в JSON-объект
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                // получаем название страны
                String country = jsonObject.get("country").getAsString();
                // получаем название города
                String city = jsonObject.get("city").getAsString();
                // получаем значение широты
                double latitude = jsonObject.get("latitude").getAsDouble();

                System.out.println("Страна: " + country);
                System.out.println("Город: " + city);
                System.out.println("Широта: " + latitude);
            } else {
                System.out.println("Что-то пошло не так. Сервер вернул код состояния: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) { // обрабатываем ошибки отправки запроса
            System.out.println("Во время выполнения запроса возникла ошибка.\n" +
                    "Проверьте, пожалуйста, адрес и повторите попытку.");
        }

        printSectionEnding();
    }

}

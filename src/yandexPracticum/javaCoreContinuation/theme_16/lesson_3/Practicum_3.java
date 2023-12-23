package yandexPracticum.javaCoreContinuation.theme_16.lesson_3;

import com.sun.net.httpserver.*;
import helpers.coloredString.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_3 {
    public static void main(String[] args) {
//        MyServer
//        program_1();
//        HttpExchange: getRequestBody()
//        try {
//            program_2();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();
    }

    public static void practicum_3() {
        printSection("Practicum_3");


        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        class RootHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                System.out.println("Был совершен запрос к серверу");
                exchange.sendResponseHeaders(200, 0);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write("<h1>Hello from java server!</h1>".getBytes());
                }
            }
        }

        try {
            InetSocketAddress address = new InetSocketAddress("localhost", 8080);
            HttpServer server = HttpServer.create(address, 0);
            HttpContext contextRoot = server.createContext("/", new RootHandler());

            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printSectionEnding();
    }

    private static void program_2() throws IOException {
        printSection("Program_2. HttpExchange: methods()");
        final int PORT = 8080;

        class HelloHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                Logger.printMarkMessage("Началась обработка /hello запроса");

                InputStream input = exchange.getRequestBody();
                String body = new String(input.readAllBytes(), StandardCharsets.UTF_8);

                System.out.println("Тело запроса: " + body);
                exchange.sendResponseHeaders(200, 0);

                String method = switch (exchange.getRequestMethod()) {
                    case "GET" -> "\nВы использовали GET метод";
                    case "POST" -> "\nВы использовали POST метод";
                    default -> "\nВы использовали неизвестный серверу метод";
                };

                String headers = "\n" + exchange.getRequestHeaders().keySet().toString();
                String host = "\n" + exchange.getRequestHeaders().get("Host").toString();

                String response1 = "Рады видеть вас наверно!";
                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(response1.getBytes(StandardCharsets.UTF_8));
                    output.write(body.getBytes());
                    output.write(method.getBytes());
                    output.write(headers.getBytes());
                    output.write(host.getBytes());
                }
            }
        }

        InetSocketAddress address = new InetSocketAddress(PORT);
        HttpServer server = HttpServer.create();
        server.bind(address, 0);

        server.createContext("/hello", new HelloHandler());

        server.start();
        Logger.printMarkMessage("HTTP-server is started");

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. ");
        class HelloHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {

                String method = httpExchange.getRequestMethod();
                System.out.println("Началась обработка " + method + " /hello запроса от клиента.");

                Headers requestHeaders = httpExchange.getRequestHeaders();
                System.out.println("Заголовки запроса: " + requestHeaders.entrySet());

                String response = "Hello!";
                httpExchange.sendResponseHeaders(200, 0);

                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(response.getBytes());
                }

//                httpExchange.getRequestURI().getPath();
//                httpExchange.getRequestHeaders().get();
//                Boolean.parseBoolean
            }
        }

        try {
            HttpServer httpServer = HttpServer.create();
            httpServer.bind(new InetSocketAddress(8080), 0);
            httpServer.createContext("/hello", new HelloHandler());

            httpServer.start();
            System.out.println("HTTP-сервер запущен на " + 8080 + " порту!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

}

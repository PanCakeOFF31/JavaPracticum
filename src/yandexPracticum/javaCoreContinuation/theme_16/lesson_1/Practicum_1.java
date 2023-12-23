package yandexPracticum.javaCoreContinuation.theme_16.lesson_1;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Practicum_1 {
    public static void main(String[] args) {
        program_1();
    }

    public static void practicum_1() {
        printSection("Practicum_1");

//        HttpServer. Endpoints
        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. HttpServer");
        class HelloHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                System.out.println("Началась обработка /hello запроса от клиента.");

                String response = "<div style=\"color: red\">Hey! Glad to see you on our server.</div>";

                exchange.sendResponseHeaders(200, 0);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(response.getBytes());
                }
            }
        }
        class DayHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                System.out.println("Началась обработка /day запроса от клиента.");
                Random random = new Random();
                int day = random.nextInt(7);

                String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

                String response = days[day];
                exchange.sendResponseHeaders(200, 3);

                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        }

        try {
            HttpServer server = HttpServer.create();
            InetSocketAddress socket = new InetSocketAddress(8080);


            server.bind(socket, 0);
            HttpContext contex1 = server.createContext("/hello", new HelloHandler());
            server.createContext("/day", new DayHandler());

            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }


}

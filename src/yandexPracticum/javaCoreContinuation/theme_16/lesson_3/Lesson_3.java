package yandexPracticum.javaCoreContinuation.theme_16.lesson_3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_3 {
    private static final int PORT = 8080;
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        class PostsHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

                // получите информацию об эндпоинте, к которому был запрос
                String requestPath = exchange.getRequestURI().getPath();
                String requestMethod = exchange.getRequestMethod();

                Endpoint endpoint = getEndpoint(requestPath, requestMethod);

                switch (endpoint) {
                    case GET_POSTS: {
                        writeResponse(exchange, "Получен запрос на получение постов", 200);
                        break;
                    }
                    case GET_COMMENTS: {
                        writeResponse(exchange, "Получен запрос на получение комментариев", 200);
                        break;
                    }
                    case POST_COMMENT: {
                        writeResponse(exchange, "Получен запрос на добавление комментария", 200);
                        break;
                    }
                    default:
                        writeResponse(exchange, "Такого эндпоинта не существует", 404);
                }
            }
        }



        try {

            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            httpServer.createContext("/posts", new PostsHandler());
            httpServer.start();

            System.out.println("HTTP-сервер запущен на " + PORT + " порту!");
//            httpServer.stop(1);
        } catch (IOException e) {

        }
    }

    private static Endpoint getEndpoint(String requestPath, String requestMethod) {
        Endpoint endpoint = Endpoint.UNKNOWN;
        String[] strings = requestPath.split("/");

        switch (requestMethod) {
            case "GET":
                if (strings.length == 2)
                    endpoint = Endpoint.GET_POSTS;
                if (strings.length == 4)
                    endpoint = Endpoint.GET_COMMENTS;
                break;
            case "POST":
                if (strings.length == 4)
                    endpoint = Endpoint.POST_COMMENT;
                break;
        }

        return endpoint;
    }

    private static void writeResponse(HttpExchange exchange,
                                      String responseString,
                                      int responseCode) throws IOException {
        exchange.sendResponseHeaders(responseCode, 0);

        if (!responseString.isEmpty()) {
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(responseString.getBytes());
            }

        }
    }

    enum Endpoint {GET_POSTS, GET_COMMENTS, POST_COMMENT, UNKNOWN}
}

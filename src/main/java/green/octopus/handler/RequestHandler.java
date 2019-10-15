package green.octopus.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        String content = "sdfs";
        OutputStream os = httpExchange.getResponseBody();
        httpExchange.sendResponseHeaders(200, content.length());
        httpExchange.getResponseHeaders().add("Content-Type","text/plain");
        os.write(content.getBytes());
        os.close();
    }
}

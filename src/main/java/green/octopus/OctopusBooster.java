package green.octopus;

import com.sun.net.httpserver.HttpServer;
import green.octopus.handler.RequestHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class OctopusBooster {

    private static final int SERVER_PORT = 8080;
    private static final int THREAD_POOL_SIZE = 20;

    public static void main(String[] args) {
        HttpServer server;
        try {
            server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);

            server.createContext("/api/v1/users", new RequestHandler());

            server.setExecutor(Executors.newFixedThreadPool(THREAD_POOL_SIZE));
            server.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
}
//java -classpath target/doll-dagga-buzz-buzz-ziggety-zag-FIRST-NAH.jar green.octopus.OctopusBooster
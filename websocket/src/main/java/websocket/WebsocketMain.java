package websocket;

import java.io.IOException;

import org.glassfish.tyrus.server.Server;

import jakarta.websocket.DeploymentException;

public class WebsocketMain {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 8080;
        String path = "/ws";
        String link = String.format("ws://%s:%d%s/math", host, port, path);
        Server sock = new Server(host, port, path,null, WebsocketConnector.class);

        try {
            sock.start();
            System.out.println("Server started. link: " + link);
            System.in.read();
        } catch (DeploymentException | IOException e) {
            System.out.println(e);
        } finally {
            sock.stop();
        }
    }
}
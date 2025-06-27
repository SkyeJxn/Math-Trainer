package websocket;

import org.glassfish.tyrus.server.Server;

public class WebsocketMain {

    public static void main(String[] args) {
        Server sock = new Server("Localhost", 8080, "/ws", WebsocketConnector.class);

        try {
            sock.start();
            System.out.println("Server started. link: ws://localhost:8080/ws/math");
            System.in.read();
        } catch (java.io.IOException | javax.websocket.DeploymentException e) {
            e.printStackTrace();
        } finally {
            sock.stop();
        }
    }
}

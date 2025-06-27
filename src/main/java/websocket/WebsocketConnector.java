package websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;

import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/math")
public class WebsocketConnector {
    
    @OnMessage
    public String onMessage(String message, Session session){
        return "Ret: " + message;
    }
}
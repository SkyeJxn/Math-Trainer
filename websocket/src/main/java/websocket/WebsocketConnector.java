package websocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import core.GameController;
import core.GamePrints;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
@SuppressWarnings("ConvertToTryWithResources")

@ServerEndpoint("/math")
public class WebsocketConnector {
    private static final Map<Session, runState> sess = new ConcurrentHashMap<>();

    private static class runState{
        int configStep = 0;
        boolean useLives, useTaskTimer, useRoundTimer = false;
        int tasks = 5, range = 10, lives = 3;
        int currentTask = 0;
        GameController game;
        boolean gameLoop = false;
    }

    @OnOpen
    public void onOpen(Session session) throws IOException{
        System.out.println("started new session. ID: " + session.getId());
        runState state = new runState();
        sess.put(session, state);
        session.getBasicRemote().sendText(GamePrints.printBox(" MATH TRAINER "));
        session.getBasicRemote().sendText("Want to Configure the game? (Y/N)");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException{
        runState run = sess.get(session);
        if (run == null){
            session.getBasicRemote().sendText("Session Error. reconnect");
            session.close();
        }

        if (!run.gameLoop){
            config(session, run, message);
        } else {
            if (run.game == null) startGame(session, run);
            try{
                int ans = Integer.parseInt(message);
                String res = run.game.checkTask(ans);
                session.getBasicRemote().sendText(res);

                run.currentTask++;

                if(!run.game.getLiving()){
                    session.getBasicRemote().sendText(String.format("Game Over!\n%s\n%s\nClosing connection now.", run.game.endRoundTime(), run.game.gameEnding()));
                    sess.remove(session);
                    session.close();
                } else if(run.currentTask >= run.tasks){
                    session.getBasicRemote().sendText(String.format("Round finished!\n%s\n%s\nClosing connection now.", run.game.endRoundTime(), run.game.gameEnding()));
                    sess.remove(session);
                    session.close();
                } else{
                    session.getBasicRemote().sendText(run.game.newTask());
                }
            } catch (NumberFormatException e){
                session.getBasicRemote().sendText("Enter valid number");
            }
        }
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("Session closed. ID: " + session.getId());
    }

    private void config(Session session, runState run, String message) throws IOException{
        switch(run.configStep){
            case 0 -> {
                run.gameLoop = message.trim().equalsIgnoreCase("n");
                if (!run.gameLoop){
                    run.configStep++;
                    session.getBasicRemote().sendText("Set new Task range:");
                } else {
                    startGame(session, run);
                }
            }
            case 1 -> {
                try {
                    run.range = Integer.parseInt(message.trim());
                } catch (NumberFormatException e) {
                    run.range = 10;
                }
                run.configStep++;
                session.getBasicRemote().sendText("Set new Task count:");
            }
            case 2 -> {
                try {
                    run.tasks = Integer.parseInt(message.trim());
                } catch (NumberFormatException e) {
                    run.tasks = 5;
                }
                run.configStep++;
                session.getBasicRemote().sendText("Use Task Timer?: (Y/N)");
            }
            case 3 -> {
                run.useTaskTimer = message.trim().equalsIgnoreCase("Y");
                run.configStep++;
                session.getBasicRemote().sendText("Use Round Timer?: (Y/N)");
            }
            case 4 -> {
                run.useRoundTimer = message.trim().equalsIgnoreCase("Y");
                run.configStep++;
                session.getBasicRemote().sendText("Use Lives?: (Y/N)");
            }
            case 5 -> {
                run.useLives = message.trim().equalsIgnoreCase("Y");
                run.configStep++;
                if (run.useLives) session.getBasicRemote().sendText("How many Lives?:");
            }
            case 6 -> {
                if (run.useLives){
                    try {
                        run.lives = Integer.parseInt(message);
                    } catch (NumberFormatException e) {
                        run.lives = 3;
                    }
                }
                run.gameLoop = true;

                startGame(session, run);
            }
        }
    }

    private void startGame(Session session, runState run) throws IOException{
        run.game = new GameController();
        run.currentTask = 0;
        run.game.changeConfig(
            run.useLives,
            run.useTaskTimer,
            run.useRoundTimer,
            run.tasks,
            run.range,
            run.lives
        );
        session.getBasicRemote().sendText(run.game.newTask());
        run.game.startRoundTime();
    }
}
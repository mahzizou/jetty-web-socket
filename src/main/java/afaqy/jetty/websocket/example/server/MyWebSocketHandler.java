package afaqy.jetty.websocket.example.server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

@WebSocket
public class MyWebSocketHandler {

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.println("Close: statusCode=" + statusCode + ", reason=" + reason);
    }

    @OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("Connect: " + session.getRemoteAddress().getAddress());
        try {
            session.getRemote().sendString("Hello Web Browser: " + Time.valueOf(LocalTime.now()));
        } catch(IOException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    // 3shan lw al client 2fl al session
                    if(session.isOpen()){
                        session.getRemote().sendString("PING: " + Time.valueOf(LocalTime.now()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask, 1000, 2000);
    }

    @OnWebSocketMessage
    public void onMessage(String message) {
        System.out.println("Message: " + message);
    }

}
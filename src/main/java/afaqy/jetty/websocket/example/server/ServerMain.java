package afaqy.jetty.websocket.example.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;


public class ServerMain {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        WebSocketHandler wsHandler = new WebSocketHandler() {
            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(MyWebSocketHandler.class);
            }
        };
        server.setHandler(wsHandler);
        server.start();
        server.join();

    }

}

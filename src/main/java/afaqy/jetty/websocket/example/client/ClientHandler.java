package afaqy.jetty.websocket.example.client;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class ClientHandler{

    Session session = null;

    public ClientHandler () throws URISyntaxException, DeploymentException, IOException {
        URI urRI =  new URI("ws://localhost:8080");
        ContainerProvider.getWebSocketContainer().connectToServer(this, urRI);
    }

    @OnOpen
    public void processOpen(Session session){
        this.session = session;
    }

    @OnMessage
    public void processMessage(String message){
        System.out.println(message);
    }

    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

}
package afaqy.jetty.websocket.example.client;

import javax.websocket.DeploymentException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

public class ClientMain {

    public static void main(String[] args) throws DeploymentException, URISyntaxException, IOException {
        ClientHandler clientHandler = new ClientHandler();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while (true) {
            try {
                message = br.readLine();
                clientHandler.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

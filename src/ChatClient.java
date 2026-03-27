
import java.io.IOException;
import java.net.Socket;

public class ChatClient {

    private final String serverIP;
    private final int port;
    private final User user;

    public ChatClient(String serverIP, int port, String username) {
        this.serverIP = serverIP;
        this.port = port;
        user = new User(username);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void start() {
        try {
            Socket socket = new Socket(serverIP, port);
            System.out.println("Connected to Server\n\n");

            new Thread(new MessageSender(socket, user)).start();
            new Thread(new MessageReceiver(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

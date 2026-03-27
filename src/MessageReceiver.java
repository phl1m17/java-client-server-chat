
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReceiver extends ChatEntity implements Runnable {

    private ChatServer server;
    private ClientConnection client;

    public MessageReceiver(Socket socket) {
        super(socket);
    }

    public MessageReceiver(Socket socket, ChatServer server, ClientConnection client) {
        super(socket);
        this.server = server;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                Message msg = Message.deserialize(line);

                if (server != null) {
                    System.out.println(
                            msg.getSender().getName() + ": " + msg.getContent());
                    server.broadcast(msg, client);
                } else {
                    System.out.println(
                            msg.getSender().getName() + ": " + msg.getContent());
                }
            }

        } catch (IOException e) {
        }
    }
}
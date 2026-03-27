
import java.io.PrintWriter;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private final int port;
    private final List<ClientConnection> clients = new ArrayList<>();

    public ChatServer(int port) {
        this.port = port;
    }

    public void broadcast(Message msg, ClientConnection sender) {
        for (ClientConnection client : clients) {
            if (client != sender) {
                client.out.println(msg);
            }
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            System.out.println("Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ClientConnection client = new ClientConnection(out);
                clients.add(client);
                System.out.println("Client connected!");

                new Thread(
                        new MessageReceiver(clientSocket, this, client)).start();
            }

        } catch (BindException e) {
            System.out.println("\n\nThere is a server already runnning on port " + port);
            System.out.println("Please check the existing server with lsof -i :" + port);
            System.out.println("and kill them using kill -9 [PID #]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

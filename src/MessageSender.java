
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MessageSender extends ChatEntity implements Runnable {

    private final User user;

    public MessageSender(Socket socket, User user) {
        super(socket);
        this.user = user;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = Main.sc;

            while (true) {
                String text = sc.nextLine();

                if (text.equalsIgnoreCase("/exit")) {
                    Message leave = new Message(
                            user.getName() + " left the chat");
                    out.println(leave);
                    socket.close();
                    break;
                }

                Message msg = new Message(user, text);
                out.println(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
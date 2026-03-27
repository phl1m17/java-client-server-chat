import java.net.Socket;

public abstract class ChatEntity {
    protected Socket socket;

    public ChatEntity(Socket socket) {
        this.socket = socket;
    }
}

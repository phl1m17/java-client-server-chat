import java.io.PrintWriter;

public class ClientConnection {
    public final PrintWriter out;

    public ClientConnection(PrintWriter out) {
        this.out = out;
    }
}